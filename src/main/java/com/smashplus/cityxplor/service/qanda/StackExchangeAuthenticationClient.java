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

/**
 * The Interface StackExchangeAuthenticationClient.
 */
public interface StackExchangeAuthenticationClient extends
		StackExchangeCommunicationClient {

	/**
	 * Sets the application key.
	 * 
	 * @param applicationKey
	 *            the new application key
	 */
	public void setApplicationKey(String applicationKey);

	/**
	 * Gets the application key.
	 * 
	 * @return the application key
	 */
	public String getApplicationKey();

	/**
	 * Sets the access Token.
	 * 
	 * @param accessToken
	 *            the new access Token
	 */
	public void setAccessToken(String accessToken);

	/**
	 * Gets the access Token.
	 * 
	 * @return the access Token
	 */
	public String getAccessToken();
}
