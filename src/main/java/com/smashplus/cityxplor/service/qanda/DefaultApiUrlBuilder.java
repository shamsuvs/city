/*
 * Copyright 2010 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */
package com.smashplus.cityxplor.service.qanda;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.logging.Logger;

/**
 * The Class DefaultApiUrlBuilder.
 */
public class DefaultApiUrlBuilder implements ApiUrlBuilder {

	/** The Constant API_URLS_FILE. */
	public static final String API_URLS_FILE = "StackOverflowApiUrls.properties";

	/** The Constant logger. */
	private static final Logger logger = Logger
			.getLogger(DefaultApiUrlBuilder.class.getCanonicalName());

	/** The Constant API_URLS_PLACEHOLDER_START. */
	private static final char API_URLS_PLACEHOLDER_START = '{';

	/** The Constant API_URLS_PLACEHOLDER_END. */
	private static final char API_URLS_PLACEHOLDER_END = '}';

	/** The Constant DEFAULT_VERSION. */
	private static final String DEFAULT_VERSION = "2.3";

	/** The url format. */
	private String urlFormat;

	/** The parameters map. */
	private Map<String, String> parametersMap = new HashMap<String, String>();

	/** The fields map. */
	private Map<String, String> fieldsMap = new HashMap<String, String>();

	/** The Constant stackOverflowApiUrls. */
	private static final Properties stackOverflowApiUrls = new Properties();

	String getQuestion="{host}/{version}/questions/{id}?{filter}{site}{key}{access_token}{page}{pagesize}";
	String getQuestionTags="{host}/{version}/search/advanced?accepted=True&order=desc&sort=votes&{tagged}{site}{filter}{page}{pagesize}";


	/**
	 * Instantiates a new default api url builder.
	 * 
	 * @param methodName
	 *            the method name
	 * @param applicationId
	 *            the application id
	 * @param accessToken
	 *            the access Token
	 * @param accessToken
	 *            the access Token
	 * @param site
	 *            Stack Exchange Site
	 * @param providerHost
	 *            the provider host
	 */
	public DefaultApiUrlBuilder(String methodName, String applicationId,
                                String accessToken, StackExchangeSite site, String providerHost) {
		if (stackOverflowApiUrls.containsKey(methodName)) {
			this.urlFormat = stackOverflowApiUrls.getProperty(methodName);
			if (applicationId != null) {
				parametersMap.put("key", applicationId);
			}
			if (accessToken != null) {
				parametersMap.put("access_token", accessToken);
			}
			if (site != null) {
				parametersMap.put("site", site.value());
			}
			fieldsMap.put("host", providerHost);
			fieldsMap.put("version", DEFAULT_VERSION);
		} else {
			throw new UnsupportedOperationException("Method '" + methodName
					+ "' not supported.");
		}
	}

	/**
	 * Instantiates a new default api url builder.
	 * 
	 * @param methodName
	 *            the method name
	 * @param applicationId
	 *            the application id
	 * @param site
	 *            Stack Exchange Site
	 * @param providerHost
	 *            the provider host
	 * @param apiVersion
	 *            the api version
	 */

	public DefaultApiUrlBuilder(String methodName, String applicationId,
                                String accessToken, StackExchangeSite site, String providerHost,
                                String apiVersion) {


			this.urlFormat = getQuestion;
			if(methodName.contains("Tag")){
				this.urlFormat = getQuestionTags;
			}
			if (applicationId != null) {
				parametersMap.put("key", applicationId);
			}
			if (accessToken != null) {
				parametersMap.put("access_token", accessToken);
			}
			if (site != null) {
				parametersMap.put("site", site.value());
			}
			fieldsMap.put("host", providerHost);
			fieldsMap.put("version", apiVersion);

	}

	/**
	 * With method.
	 * 
	 * @param methodName
	 *            the method name
	 * 
	 * @return the api url builder
	 */
	public ApiUrlBuilder withMethod(String methodName) {
		if (stackOverflowApiUrls.containsKey(methodName)) {
			this.urlFormat = stackOverflowApiUrls.getProperty(methodName);
		} else {
			throw new UnsupportedOperationException("Method '" + methodName
					+ "' not supported.");
		}

		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.provider.url.ApiUrlBuilder#withParameter
	 * (java.lang.String, java.lang.String)
	 */
	public ApiUrlBuilder withParameter(String name, String value) {
		if (value != null && value.length() > 0) {
			parametersMap.put(name, encodeUrl(value));
		}

		return this;
	}

	public ApiUrlBuilder withParameters(String name, Collection<String> values) {
		return withParameters(name, values, " ");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.stackexchange.client.provider.url.ApiUrlBuilder#
	 * withParameters(java.lang.String, java.util.Collection)
	 */
	public ApiUrlBuilder withParameters(String name, Collection<String> values,
                                        String delimiter) {
		if (values != null && !values.isEmpty()) {
			StringBuilder builder = new StringBuilder();
			for (Iterator<String> iterator = values.iterator(); iterator
					.hasNext();) {
				builder.append(iterator.next());
				if (iterator.hasNext()) {
					builder.append(delimiter);
				}
			}
			parametersMap.put(name, encodeUrl(builder.toString()));
		}

		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.stackexchange.client.provider.url.ApiUrlBuilder#
	 * withParameters(java.lang.String, java.util.Collection)
	 */
	public ApiUrlBuilder withFields(String name, Collection<String> values) {
		if (values != null && !values.isEmpty()) {
			StringBuilder builder = new StringBuilder();
			for (Iterator<String> iterator = values.iterator(); iterator
					.hasNext();) {
				builder.append(iterator.next());
				if (iterator.hasNext()) {
					builder.append("%20");
				}
			}
			fieldsMap.put(name, builder.toString());
		}

		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.stackexchange.client.provider.url.ApiUrlBuilder#
	 * withParameterEnum(java.lang.String,
	 * com.google.code.stackexchange.schema.ValueEnum)
	 */
	public ApiUrlBuilder withParameterEnum(String name, ValueEnum value) {
		withParameter(name, value.value());

		return this;
	}

	public ApiUrlBuilder withSort(SortEnum sort) {
		if (sort != null) {
			withParameter("sort", sort.value());
			if (sort.order() != null) {
				withParameter("order", sort.order().value());
			}
		}
		return this;
	}




	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.provider.url.ApiUrlBuilder#withId
	 * (long)
	 */
	@Override
	public ApiUrlBuilder withId(long id) {
		withField("id", String.valueOf(id), false);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.provider.url.ApiUrlBuilder#withIds
	 * (long[])
	 */
	@Override
	public ApiUrlBuilder withIds(long... ids) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < ids.length; i++) {
			builder.append(ids[i]);
			if (i < ids.length - 1) {
				builder.append(";");
			}
		}
		withField("id", builder.toString(), false);
		return this;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.provider.url.ApiUrlBuilder#withIds
	 * (long[])
	 */
	@Override
	public ApiUrlBuilder withIds(String param, long... ids) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < ids.length; i++) {
			builder.append(ids[i]);
			if (i < ids.length - 1) {
				builder.append(";");
			}
		}
		withField(param, builder.toString(), false);
		return this;
	}

	@Override
	public ApiUrlBuilder withIds(List<Long> ids) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < ids.size(); i++) {
			builder.append(ids.get(i));
			if (i < ids.size() - 1) {
				builder.append(";");
			}
		}
		withField("id", builder.toString(), false);
		return this;
	}


	public ApiUrlBuilder withFilter(String filter) {
		if (filter != null && !filter.isEmpty()) {
			withParameter("filter", filter);
		}
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.stackexchange.client.provider.url.ApiUrlBuilder#
	 * withParameterEnumMap(java.util.Map)
	 */
	public ApiUrlBuilder withParameterEnumMap(
			Map<? extends ValueEnum, String> enumMap) {
		for (ValueEnum parameter : enumMap.keySet()) {
			withParameter(parameter.value(), enumMap.get(parameter));
		}

		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.stackexchange.client.provider.url.ApiUrlBuilder#
	 * withEmptyField(java.lang.String)
	 */
	public ApiUrlBuilder withEmptyField(String name) {
		fieldsMap.put(name, "");

		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.provider.url.ApiUrlBuilder#withField
	 * (java.lang.String, java.lang.String)
	 */
	public ApiUrlBuilder withField(String name, String value) {
		withField(name, value, false);

		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.provider.url.ApiUrlBuilder#withField
	 * (java.lang.String, java.lang.String, boolean)
	 */
	public ApiUrlBuilder withField(String name, String value, boolean escape) {
		if (escape) {
			fieldsMap.put(name, encodeUrl(value));
		} else {
			fieldsMap.put(name, value);
		}

		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.provider.url.ApiUrlBuilder#withFieldEnum
	 * (java.lang.String, com.google.code.stackexchange.schema.ValueEnum)
	 */
	public ApiUrlBuilder withFieldEnum(String name, ValueEnum value) {
		if (value.value() == null || value.value().length() == 0) {
			fieldsMap.put(name, "");
		} else {
			fieldsMap.put(name, value.value());
		}

		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.stackexchange.client.provider.url.ApiUrlBuilder#
	 * withFieldEnumSet(java.lang.String, java.util.Set)
	 */
	public ApiUrlBuilder withFieldEnumSet(String name,
                                          Set<? extends ValueEnum> enumSet) {
		StringBuilder builder = new StringBuilder();
		if (!enumSet.isEmpty()) {
			builder.append(":");
			Iterator<? extends ValueEnum> iter = enumSet.iterator();
			builder.append("(");
			while (iter.hasNext()) {
				ValueEnum fieldEnum = iter.next();
				builder.append(fieldEnum.value());
				if (iter.hasNext()) {
					builder.append(",");
				}
			}
			builder.append(")");
		}

		fieldsMap.put(name, builder.toString());

		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.provider.url.ApiUrlBuilder#buildUrl
	 * ()
	 */
	public String buildUrl() {
		StringBuilder urlBuilder = new StringBuilder();
		StringBuilder placeHolderBuilder = new StringBuilder();
		Map<String, String> fieldsLeftMap = new HashMap<String, String>(
				fieldsMap);
		Map<String, String> parametersLeftMap = new HashMap<String, String>(
				parametersMap);
		boolean placeHolderFlag = false;
		boolean firstParameter = true;
		for (int i = 0; i < urlFormat.length(); i++) {
			if (urlFormat.charAt(i) == API_URLS_PLACEHOLDER_START) {
				placeHolderBuilder = new StringBuilder();
				placeHolderFlag = true;
			} else if (placeHolderFlag
					&& urlFormat.charAt(i) == API_URLS_PLACEHOLDER_END) {
				String placeHolder = placeHolderBuilder.toString();
				if (fieldsMap.containsKey(placeHolder)) {
					urlBuilder.append(fieldsMap.get(placeHolder));
					fieldsLeftMap.remove(placeHolder);
				} else if (parametersMap.containsKey(placeHolder)) {
					StringBuilder builder = new StringBuilder();
					if (firstParameter) {
						firstParameter = false;
					} else {
						builder.append("&");
					}
					builder.append(placeHolder);
					builder.append("=");
					builder.append(parametersMap.get(placeHolder));
					urlBuilder.append(builder.toString());
					parametersLeftMap.remove(placeHolder);
				} else {
					// we did not find a binding for the placeholder.
					// skip it.
					// urlBuilder.append(API_URLS_PLACEHOLDER_START);
					// urlBuilder.append(placeHolder);
					// urlBuilder.append(API_URLS_PLACEHOLDER_END);
				}
				placeHolderFlag = false;
			} else if (placeHolderFlag) {
				placeHolderBuilder.append(urlFormat.charAt(i));
			} else {
				urlBuilder.append(urlFormat.charAt(i));
			}
		}

		if (fieldsLeftMap.size() > 0) {
			logger.fine("Field [" + fieldsLeftMap.keySet().iterator().next()
					+ "] not suitable for API: " + urlFormat);
		}

		if (parametersLeftMap.size() > 0) {
			logger.fine("Parameter ["
					+ parametersLeftMap.keySet().iterator().next()
					+ "] not suitable for API: " + urlFormat);
		}

		logger.fine("URL generated: " + urlBuilder.toString());

		return urlBuilder.toString();
	}

	/**
	 * Encode url.
	 * 
	 * @param original
	 *            the original
	 * 
	 * @return the string
	 */
	private static String encodeUrl(String original) {
		try {
			return URLEncoder.encode(original,
					"utf-8");
		} catch (UnsupportedEncodingException e) {
			// should never be here..
			return original;
		}
	}


	@Override
	public ApiUrlBuilder withIds(String... ids) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < ids.length; i++) {
			builder.append(ids[i]);
			if (i < ids.length - 1) {
				builder.append(";");
			}
		}
		withField("id", builder.toString(), false);
		return this;
	}
}
