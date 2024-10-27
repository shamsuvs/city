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


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

/**
 * The Class StackExchangeApiGateway.
 */
public abstract class StackExchangeApiGateway {

	/** The LOG. */
	protected final Logger LOG = Logger
			.getLogger(getClass().getCanonicalName());

	/** The Constant GZIP_ENCODING. */
	private static final String GZIP_ENCODING = "gzip";

	/** The request headers. */
	protected Map<String, String> requestHeaders;

	/** The api provider. */
	private ApiProvider apiProvider = new StackExchangeApiProvider();

	/** The Stack Exchange Site . */
	protected StackExchangeSite site;

	/** The application key. */
	protected String applicationKey;

	/** The Access Token. */
	protected String accessToken;

	/** The api version. */
	protected String apiVersion = "2.3";

	/** The max rate limit. */
	private int maxRateLimit = -1;

	/** The current rate limit. */
	private int currentRateLimit = -1;

	/**
	 * Gets the api version.
	 * 
	 * @return the api version
	 */
	public String getApiVersion() {
		return apiVersion;
	}

	/**
	 * Sets the api version.
	 * 
	 * @param apiVersion
	 *            the new api version
	 */
	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * Sets the request headers.
	 * 
	 * @param requestHeaders
	 *            the request headers
	 */
	public void setRequestHeaders(Map<String, String> requestHeaders) {
		this.requestHeaders = requestHeaders;
	}

	/**
	 * Gets the request headers.
	 * 
	 * @return the request headers
	 */
	public Map<String, String> getRequestHeaders() {
		return requestHeaders;
	}

	/**
	 * Adds the request header.
	 * 
	 * @param headerName
	 *            the header name
	 * @param headerValue
	 *            the header value
	 */
	public void addRequestHeader(String headerName, String headerValue) {
		requestHeaders.put(headerName, headerValue);
	}

	/**
	 * Removes the request header.
	 * 
	 * @param headerName
	 *            the header name
	 */
	public void removeRequestHeader(String headerName) {
		requestHeaders.remove(headerName);
	}

	/**
	 * Gets the application key.
	 * 
	 * @return the application key
	 */
	public String getApplicationKey() {
		return applicationKey;
	}

	/**
	 * Sets the application key.
	 * 
	 * @param applicationKey
	 *            the new application key
	 */
	public void setApplicationKey(String applicationKey) {
		this.applicationKey = applicationKey;
	}

	/**
	 * Gets the api provider.
	 * 
	 * @return the api provider
	 */
	public ApiProvider getApiProvider() {
		return apiProvider;
	}

	/**
	 * Sets the api provider.
	 * 
	 * @param apiProvider
	 *            the new api provider
	 */
	public void setApiProvider(ApiProvider apiProvider) {
		this.apiProvider = apiProvider;
	}

	/**
	 * Gets the max rate limit.
	 * 
	 * @return the max rate limit
	 */
	public int getMaxRateLimit() {
		return maxRateLimit;
	}

	/**
	 * Gets the current rate limit.
	 * 
	 * @return the current rate limit
	 */
	public int getCurrentRateLimit() {
		return currentRateLimit;
	}

	public StackExchangeSite getSite() {
		return site;
	}

	public void setSite(StackExchangeSite site) {
		this.site = site;
	}

	/**
	 * Convert stream to string.
	 * 
	 * @param is
	 *            the is
	 * 
	 * @return the string
	 */
	protected static String convertStreamToString(InputStream is) {
		/*
		 * To convert the InputStream to String we use the
		 * BufferedReader.readLine() method. We iterate until the BufferedReader
		 * return null which means there's no more data to read. Each line will
		 * appended to a StringBuilder and returned as String.
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return sb.toString();
	}

	/**
	 * Call api method.
	 * 
	 * @param apiUrl
	 *            the api url
	 * 
	 * @return the input stream
	 */
	protected InputStream callApiMethod(String apiUrl) {
		return callApiMethod(apiUrl, HttpURLConnection.HTTP_OK);
	}

	/**
	 * Call api method.
	 * 
	 * @param apiUrl
	 *            the api url
	 * @param expected
	 *            the expected
	 * 
	 * @return the input stream
	 */
	protected InputStream callApiMethod(String apiUrl, int expected) {
		try {
			URL url = new URL("https://"+apiUrl);
			//URL url = new URL("/2.3/questions/56961628?order=desc&sort=activity&site=stackoverflow");
			//URL url = new URL("https://api.stackexchange.com/2.3/questions/56961628?key=U4DMV*8nvpm3EOpvf69Rxw((&site=stackoverflow&order=desc&sort=activity&filter=default");

			System.out.println("https://"+apiUrl);

			//System.out.println("https://api.stackexchange.com/2.3/questions/56961628?key=U4DMV*8nvpm3EOpvf69Rxw((&site=stackoverflow&order=desc&sort=activity&filter=default");

			HttpURLConnection request = (HttpURLConnection) url
					.openConnection();



			for (String headerName : requestHeaders.keySet()) {
				request.setRequestProperty(headerName,
						requestHeaders.get(headerName));
			}

			request.connect();

			if (request.getResponseCode() != expected) {
				InputStream wrappedInputStream = getWrappedInputStream(
						request.getErrorStream(),
						GZIP_ENCODING.equalsIgnoreCase(request
								.getContentEncoding()));
				Error error = unmarshallObject(Error.class, wrappedInputStream);

			} else {
				return getWrappedInputStream(request.getInputStream(),
						GZIP_ENCODING.equalsIgnoreCase(request
								.getContentEncoding()));
			}
		} catch (IOException e) {
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



	/**
	 * Call api method.
	 * 
	 * @param apiUrl
	 *            the api url
	 * @param xmlContent
	 *            the xml content
	 * @param contentType
	 *            the content type
	 * @param method
	 *            the method
	 * @param expected
	 *            the expected
	 * 
	 * @return the input stream
	 */
	protected InputStream callApiMethod(String apiUrl, String xmlContent,
                                        String contentType, String method, int expected) {
		try {
			URL url = new URL(apiUrl);
			HttpURLConnection request = (HttpURLConnection) url
					.openConnection();



			for (String headerName : requestHeaders.keySet()) {
				request.setRequestProperty(headerName,
						requestHeaders.get(headerName));
			}

			request.setRequestMethod(method);
			request.setDoOutput(true);

			if (contentType != null) {
				request.setRequestProperty("Content-Type", contentType);
			}

			if (xmlContent != null) {
				PrintStream out = new PrintStream(new BufferedOutputStream(
						request.getOutputStream()));

				out.print(xmlContent);
				out.flush();
				out.close();
			}

			request.connect();


			if (request.getResponseCode() != expected) {
				InputStream wrappedInputStream = getWrappedInputStream(
						request.getErrorStream(),
						GZIP_ENCODING.equalsIgnoreCase(request
								.getContentEncoding()));
				String result = getStringFromInputStream(wrappedInputStream);
				System.out.println(result);

				Error error = unmarshallObject(Error.class, wrappedInputStream);

			} else {
				return getWrappedInputStream(request.getInputStream(),
						GZIP_ENCODING.equalsIgnoreCase(request
								.getContentEncoding()));
			}
		} catch (IOException e) {
		}
	return null;
	}

	/**
	 * Close stream.
	 * 
	 * @param is
	 *            the is
	 */
	protected void closeStream(InputStream is) {
		try {
			if (is != null) {
				is.close();
			}
		} catch (IOException e) {
			LOG.log(Level.SEVERE, "An error occurred while closing stream.", e);
		}
	}

	/**
	 * Close connection.
	 * 
	 * @param connection
	 *            the connection
	 */
	protected void closeConnection(HttpURLConnection connection) {
		try {
			if (connection != null) {
				connection.disconnect();
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE,
					"An error occurred while disconnecting connection.", e);
		}
	}


	/**
	 * Gets the wrapped input stream.
	 * 
	 * @param is
	 *            the is
	 * @param gzip
	 *            the gzip
	 * 
	 * @return the wrapped input stream
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	protected InputStream getWrappedInputStream(InputStream is, boolean gzip)
			throws IOException {
		if (gzip) {
			return new BufferedInputStream(new GZIPInputStream(is));
		} else {
			return new BufferedInputStream(is);
		}
	}

	/**
	 * Unmarshall object.
	 * 
	 * @param clazz
	 *            the clazz
	 * @param xmlContent
	 *            the xml content
	 * 
	 * @return the t
	 */
	protected abstract <T> T unmarshallObject(Class<T> clazz,
                                              InputStream xmlContent);

	/**
	 * Unmarshall object.
	 * 
	 * @param clazz
	 *            the clazz
	 * @param xmlContent
	 *            the xml content
	 * 
	 * @return the t
	 */
	protected abstract <T> PagedList<T> unmarshallList(Class<T> clazz,
                                                       InputStream xmlContent);

	/**
	 * Marshall object.
	 * 
	 * @param element
	 *            the element
	 * 
	 * @return the string
	 */
	protected abstract String marshallObject(Object element);

	public static String getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

	}
}
