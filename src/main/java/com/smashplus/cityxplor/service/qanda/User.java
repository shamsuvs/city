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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The Class UserImpl.
 */
public class User extends SchemaEntity {

	/**
	 * The Enum SortOrder.
	 */
	public enum SortOrder implements SortEnum {

		/**
		 * The MOS t_ reputed.
		 */
		MOST_REPUTED("reputation", Order.DESCENDING),

		/**
		 * The LEAS t_ reputed.
		 */
		LEAST_REPUTED("reputation", Order.ASCENDING),

		/**
		 * The MOS t_ recentl y_ created.
		 */
		MOST_RECENTLY_CREATED("creation", Order.DESCENDING),

		/**
		 * The LEAS t_ recentl y_ created.
		 */
		LEAST_RECENTLY_CREATED("creation", Order.ASCENDING),

		/**
		 * The NAM e_ ascending.
		 */
		NAME_ASCENDING("name", Order.DESCENDING),

		/**
		 * The NAM e_ descending.
		 */
		NAME_DESCENDING("name", Order.ASCENDING),

		/**
		 * The modified ascending.
		 */
		MODIFIED_ASCENDING("modified", Order.DESCENDING),

		/**
		 * The modified descending.
		 */
		MODIFIED_DESCENDING("modified", Order.ASCENDING);

		/**
		 * The Constant stringToEnum.
		 */
		private static final Map<String, SortOrder> stringToEnum = new HashMap<String, SortOrder>();

		static { // Initialize map from constant name to enum constant
			for (SortOrder op : values()) {
				stringToEnum.put(op.value(), op);
			}
		}

		/**
		 * The value.
		 */
		private final String value;

		/**
		 * The order.
		 */
		private final Order order;

		/**
		 * Instantiates a new sort order.
		 *
		 * @param value the value
		 * @param order the order
		 */
		SortOrder(String value, Order order) {
			this.value = value;
			this.order = order;
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

		/**
		 * From value.
		 *
		 * @param value the value
		 * @return the sort order
		 */
		public static SortOrder fromValue(String value) {
			return stringToEnum.get(value);
		}

		/*
		 * (non-Javadoc)
		 *
		 * @see com.google.code.stackexchange.schema.SortEnum#order()
		 */
		@Override
		public Order order() {
			return order;
		}
	}

	/**
	 * The Enum FavoriteSortOrder.
	 */
	public enum FavoriteSortOrder implements SortEnum {

		/**
		 * The MOS t_ recentl y_ updated.
		 */
		MOST_RECENTLY_UPDATED("activity", Order.DESCENDING),

		/**
		 * The LEAS t_ recentl y_ updated.
		 */
		LEAST_RECENTLY_UPDATED("activity", Order.ASCENDING),

		/**
		 * The MOS t_ viewed.
		 */
		MOST_VIEWED("views", Order.DESCENDING),

		/**
		 * The LEAS t_ viewed.
		 */
		LEAST_VIEWED("views", Order.ASCENDING),

		/**
		 * The MOS t_ recentl y_ created.
		 */
		MOST_RECENTLY_CREATED("creation", Order.DESCENDING),

		/**
		 * The LEAS t_ recentl y_ created.
		 */
		LEAST_RECENTLY_CREATED("creation", Order.ASCENDING),

		/**
		 * The MOS t_ recentl y_ added.
		 */
		MOST_RECENTLY_ADDED("added", Order.DESCENDING),

		/**
		 * The LEAS t_ recentl y_ added.
		 */
		LEAST_RECENTLY_ADDED("added", Order.ASCENDING),

		/**
		 * The MOS t_ voted.
		 */
		MOST_VOTED("votes", Order.DESCENDING),

		/**
		 * The LEAS t_ voted.
		 */
		LEAST_VOTED("votes", Order.ASCENDING);

		/**
		 * The Constant stringToEnum.
		 */
		private static final Map<String, FavoriteSortOrder> stringToEnum = new HashMap<String, FavoriteSortOrder>();

		static { // Initialize map from constant name to enum constant
			for (FavoriteSortOrder op : values()) {
				stringToEnum.put(op.value(), op);
			}
		}

		/**
		 * The value.
		 */
		private final String value;

		/**
		 * The order.
		 */
		private final Order order;

		/**
		 * Instantiates a new favorite sort order.
		 *
		 * @param value the value
		 * @param order the order
		 */
		FavoriteSortOrder(String value, Order order) {
			this.value = value;
			this.order = order;
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

		/**
		 * From value.
		 *
		 * @param value the value
		 * @return the favorite sort order
		 */
		public static FavoriteSortOrder fromValue(String value) {
			return stringToEnum.get(value);
		}

		/*
		 * (non-Javadoc)
		 *
		 * @see com.google.code.stackexchange.schema.SortEnum#order()
		 */
		@Override
		public Order order() {
			return order;
		}
	}

	/**
	 * The Enum QuestionSortOrder.
	 */
	public enum QuestionSortOrder implements SortEnum {

		/**
		 * The MOS t_ recentl y_ updated.
		 */
		MOST_RECENTLY_UPDATED("activity", Order.DESCENDING),

		/**
		 * The LEAS t_ recentl y_ updated.
		 */
		LEAST_RECENTLY_UPDATED("activity", Order.ASCENDING),

		/**
		 * The MOST relevant .
		 */
		MOST_RELEVANT("relevance", Order.DESCENDING),

		/**
		 * The LEAST relevant.
		 */
		LEAST_RELEVANT("relevance", Order.ASCENDING),

		/**
		 * The MOS t_ viewed.
		 */
		MOST_VIEWED("views", Order.DESCENDING),

		/**
		 * The LEAS t_ viewed.
		 */
		LEAST_VIEWED("views", Order.ASCENDING),

		/**
		 * The MOS t_ recentl y_ created.
		 */
		MOST_RECENTLY_CREATED("creation", Order.DESCENDING),

		/**
		 * The LEAS t_ recentl y_ created.
		 */
		LEAST_RECENTLY_CREATED("creation", Order.ASCENDING),

		/**
		 * The MOS t_ voted.
		 */
		MOST_VOTED("votes", Order.DESCENDING),

		/**
		 * The LEAS t_ voted.
		 */
		LEAST_VOTED("votes", Order.ASCENDING);

		/**
		 * The Constant stringToEnum.
		 */
		private static final Map<String, QuestionSortOrder> stringToEnum = new HashMap<String, QuestionSortOrder>();

		static { // Initialize map from constant name to enum constant
			for (QuestionSortOrder op : values()) {
				stringToEnum.put(op.value(), op);
			}
		}

		/**
		 * The value.
		 */
		private final String value;

		/**
		 * The order.
		 */
		private final Order order;

		/**
		 * Instantiates a new question sort order.
		 *
		 * @param value the value
		 * @param order the order
		 */
		QuestionSortOrder(String value, Order order) {
			this.value = value;
			this.order = order;
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

		/**
		 * From value.
		 *
		 * @param value the value
		 * @return the question sort order
		 */
		public static QuestionSortOrder fromValue(String value) {
			return stringToEnum.get(value);
		}

		/*
		 * (non-Javadoc)
		 *
		 * @see com.google.code.stackexchange.schema.SortEnum#order()
		 */
		@Override
		public Order order() {
			return order;
		}
	}

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = -5517600617397335450L;

	/**
	 * The user id.
	 */
	private long userId;



	/**
	 * The creation date.
	 */
	private Date creationDate;

	/**
	 * The display name.
	 */
	private String displayName;

	/**
	 * The reputation.
	 */
	private long reputation;

	/**
	 * The email hash.
	 */
	private String emailHash;

	/**
	 * The age.
	 */
	private long age;

	/**
	 * The last access date.
	 */
	private Date lastAccessDate;

	/**
	 * The website url.
	 */
	private String websiteUrl;

	/**
	 * The location.
	 */
	private String location;

	/**
	 * The about me.
	 */
	private String aboutMe;

	/**
	 * The question count.
	 */
	private long questionCount;

	/**
	 * The answer count.
	 */
	private long answerCount;

	/**
	 * The view count.
	 */
	private long viewCount;

	/**
	 * The up vote count.
	 */
	private long upVoteCount;

	/**
	 * The down vote count.
	 */
	private long downVoteCount;

	/**
	 * The accept rate.
	 */
	private double acceptRate;

	/**
	 * The user questions url.
	 */
	private String userQuestionsUrl;

	/**
	 * The user answers url.
	 */
	private String userAnswersUrl;

	/**
	 * The user favorites url.
	 */
	private String userFavoritesUrl;

	/**
	 * The user tags url.
	 */
	private String userTagsUrl;

	/**
	 * The user badges url.
	 */
	private String userBadgesUrl;

	/**
	 * The user timeline url.
	 */
	private String userTimelineUrl;

	/**
	 * The user mentioned url.
	 */
	private String userMentionedUrl;

	/**
	 * The user comments url.
	 */
	private String userCommentsUrl;

	/**
	 * The user reputation url.
	 */
	private String userReputationUrl;

	private Date timedPenaltyDate;

	private String associationId;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public long getReputation() {
		return reputation;
	}

	public void setReputation(long reputation) {
		this.reputation = reputation;
	}

	public String getEmailHash() {
		return emailHash;
	}

	public void setEmailHash(String emailHash) {
		this.emailHash = emailHash;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public Date getLastAccessDate() {
		return lastAccessDate;
	}

	public void setLastAccessDate(Date lastAccessDate) {
		this.lastAccessDate = lastAccessDate;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public long getQuestionCount() {
		return questionCount;
	}

	public void setQuestionCount(long questionCount) {
		this.questionCount = questionCount;
	}

	public long getAnswerCount() {
		return answerCount;
	}

	public void setAnswerCount(long answerCount) {
		this.answerCount = answerCount;
	}

	public long getViewCount() {
		return viewCount;
	}

	public void setViewCount(long viewCount) {
		this.viewCount = viewCount;
	}

	public long getUpVoteCount() {
		return upVoteCount;
	}

	public void setUpVoteCount(long upVoteCount) {
		this.upVoteCount = upVoteCount;
	}

	public long getDownVoteCount() {
		return downVoteCount;
	}

	public void setDownVoteCount(long downVoteCount) {
		this.downVoteCount = downVoteCount;
	}

	public double getAcceptRate() {
		return acceptRate;
	}

	public void setAcceptRate(double acceptRate) {
		this.acceptRate = acceptRate;
	}

	public String getUserQuestionsUrl() {
		return userQuestionsUrl;
	}

	public void setUserQuestionsUrl(String userQuestionsUrl) {
		this.userQuestionsUrl = userQuestionsUrl;
	}

	public String getUserAnswersUrl() {
		return userAnswersUrl;
	}

	public void setUserAnswersUrl(String userAnswersUrl) {
		this.userAnswersUrl = userAnswersUrl;
	}

	public String getUserFavoritesUrl() {
		return userFavoritesUrl;
	}

	public void setUserFavoritesUrl(String userFavoritesUrl) {
		this.userFavoritesUrl = userFavoritesUrl;
	}

	public String getUserTagsUrl() {
		return userTagsUrl;
	}

	public void setUserTagsUrl(String userTagsUrl) {
		this.userTagsUrl = userTagsUrl;
	}

	public String getUserBadgesUrl() {
		return userBadgesUrl;
	}

	public void setUserBadgesUrl(String userBadgesUrl) {
		this.userBadgesUrl = userBadgesUrl;
	}

	public String getUserTimelineUrl() {
		return userTimelineUrl;
	}

	public void setUserTimelineUrl(String userTimelineUrl) {
		this.userTimelineUrl = userTimelineUrl;
	}

	public String getUserMentionedUrl() {
		return userMentionedUrl;
	}

	public void setUserMentionedUrl(String userMentionedUrl) {
		this.userMentionedUrl = userMentionedUrl;
	}

	public String getUserCommentsUrl() {
		return userCommentsUrl;
	}

	public void setUserCommentsUrl(String userCommentsUrl) {
		this.userCommentsUrl = userCommentsUrl;
	}

	public String getUserReputationUrl() {
		return userReputationUrl;
	}

	public void setUserReputationUrl(String userReputationUrl) {
		this.userReputationUrl = userReputationUrl;
	}

	public Date getTimedPenaltyDate() {
		return timedPenaltyDate;
	}

	public void setTimedPenaltyDate(Date timedPenaltyDate) {
		this.timedPenaltyDate = timedPenaltyDate;
	}

	public String getAssociationId() {
		return associationId;
	}

	public void setAssociationId(String associationId) {
		this.associationId = associationId;
	}
}
