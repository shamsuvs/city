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


import com.google.gson.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The Class StackExchangeApiJsonClient.
 */
public class StackExchangeApiJsonClient extends BaseStackExchangeApiClient {

	private static final Map<Class<? extends SchemaEntity>, String> LIST_PLACE_HOLDERS = new HashMap<Class<? extends SchemaEntity>, String>();

	static {

		LIST_PLACE_HOLDERS.put(Question.class, "items");

	}

	/** The parser. */
	private final JsonParser parser = new JsonParser();

	protected static final Charset UTF_8_CHAR_SET = Charset
			.forName("utf-8");



	/**
	 * Instantiates a new stack exchange api json client.
	 * 
	 * @param applicationKey
	 *            the application key
	 * @param accessToken
	 *            the access Token
	 * @param site
	 *            the stack exchange site
	 */
	public StackExchangeApiJsonClient(String applicationKey,
                                      String accessToken, StackExchangeSite site) {
		super(applicationKey, accessToken, site);
	}

	/**
	 * Instantiates a new stack exchange api json client.
	 * 
	 * @param applicationKey
	 *            the application key
	 * @param site
	 *            the stack exchange site
	 * @param apiVersion
	 *            the api version
	 */
	public StackExchangeApiJsonClient(String applicationKey,
                                      StackExchangeSite site, String apiVersion) {
		super(applicationKey, site, apiVersion);
	}



	protected <T> PagedList<T> unmarshallList(Class<T> clazz,
                                              InputStream jsonContent) {
		try {
			JsonElement response = parser.parse(new InputStreamReader(
					jsonContent, UTF_8_CHAR_SET));
			if (response.isJsonObject()) {
				JsonObject adaptee = response.getAsJsonObject();
				PagedList<T> list = new PagedArrayList<T>();
				if (adaptee.has("quota_max")) {
					list.setQuotaMax(adaptee.get("quota_max").getAsInt());
				}
				if (adaptee.has("quota_remaining")) {
					list.setQuotaRemaining(adaptee.get("quota_remaining")
							.getAsInt());
				}
				if (adaptee.has("page")) {
					list.setPage(adaptee.get("page").getAsInt());
				}
				if (adaptee.has("pagesize")) {
					list.setPageSize(adaptee.get("pagesize").getAsInt());
				}
				if (adaptee.has("has_more")) {
					list.setHasMore(adaptee.get("has_more").getAsBoolean());
				}
				if (adaptee.has("backoff")) {
					list.setBackoff(adaptee.get("backoff").getAsInt());
				}
				String placeHolder = LIST_PLACE_HOLDERS.get(clazz);
				if (adaptee.has(placeHolder)) {
					JsonArray elements = adaptee.get(placeHolder)
							.getAsJsonArray();
					if (elements != null) {
						Gson gson = getGsonBuilder().create();
						for (JsonElement o : elements) {
							list.add(gson.fromJson(o, clazz));
						}
					}
				}
				return list;
			}

		} catch (Exception e) {
		}
		return null;
	}

	protected <T> T unmarshallObject(Class<T> clazz, InputStream jsonContent) {
		if (clazz.equals(Error.class)) {
			try {
				JsonElement response = parser.parse(new InputStreamReader(
						jsonContent, UTF_8_CHAR_SET));
				if (response.isJsonObject()) {
					Gson gson = getGsonBuilder().create();
					return gson.fromJson(response, clazz);
				}
			} catch (Exception e) {
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.stackexchange.client.impl.StackOverflowApiGateway#
	 * marshallObject(java.lang.Object)
	 */
	protected String marshallObject(Object element) {
		try {
			StringWriter writer = new StringWriter();

			return writer.toString();
		} catch (Exception e) {
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.impl.BaseStackOverflowApiClient#
	 * createStackOverflowApiUrlBuilder(java.lang.String)
	 */
	protected ApiUrlBuilder createStackOverflowApiUrlBuilder(String methodName) {
		return getApiProvider().createApiUrlBuilder(methodName,
				getApplicationKey(), getAccessToken(), getSite(),
				getApiVersion());
	}

	protected GsonBuilder getGsonBuilder() {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {

			@Override
			public Date deserialize(JsonElement source, Type arg1,
                                    JsonDeserializationContext arg2) throws JsonParseException {
				return new Date(source.getAsLong() * 1000);
			}

		});

		builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

		return builder;
	}

}
