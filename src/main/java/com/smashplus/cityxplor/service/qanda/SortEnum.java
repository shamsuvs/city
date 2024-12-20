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
 * The Interface SortEnum.
 */
public interface SortEnum extends ValueEnum {

	/**
	 * The Enum Order.
	 */
	public enum Order implements ValueEnum {

		/** The ASCENDING. */
		DESCENDING("desc"),

		/** The DESCENDING. */
		ASCENDING("asc");

		/** The value. */
		private final String value;

		/**
		 * Instantiates a new order.
		 * 
		 * @param value
		 *            the value
		 */
		Order(String value) {
			this.value = value;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.google.code.stackexchange.schema.ValueEnum#value()
		 */
		@Override
		public String value() {
			return value;
		}
	}

	/**
	 * Order.
	 * 
	 * @return the order
	 */
	public Order order();
}
