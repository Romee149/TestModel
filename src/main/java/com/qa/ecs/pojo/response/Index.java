package com.qa.ecs.pojo.response;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "indexBaseRate", "indexName", "isReviewDly", "nextReviewDtm", "reviewFreq" })

public class Index {

	@JsonProperty("indexBaseRate")
	private Double indexBaseRate;
	@JsonProperty("indexName")
	private String indexName;
	@JsonProperty("isReviewDly")
	private Boolean isReviewDly;
	@JsonProperty("nextReviewDtm")
	private String nextReviewDtm;
	@JsonProperty("reviewFreq")
	private String reviewFreq;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("indexBaseRate")
	public Double getIndexBaseRate() {
		return indexBaseRate;
	}

	@JsonProperty("indexBaseRate")
	public void setIndexBaseRate(Double indexBaseRate) {
		this.indexBaseRate = indexBaseRate;
	}

	@JsonProperty("indexName")
	public String getIndexName() {
		return indexName;
	}

	@JsonProperty("indexName")
	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	@JsonProperty("isReviewDly")
	public Boolean getIsReviewDly() {
		return isReviewDly;
	}

	@JsonProperty("isReviewDly")
	public void setIsReviewDly(Boolean isReviewDly) {
		this.isReviewDly = isReviewDly;
	}

	@JsonProperty("nextReviewDtm")
	public String getNextReviewDtm() {
		return nextReviewDtm;
	}

	@JsonProperty("nextReviewDtm")
	public void setNextReviewDtm(String nextReviewDtm) {
		this.nextReviewDtm = nextReviewDtm;
	}

	@JsonProperty("reviewFreq")
	public String getReviewFreq() {
		return reviewFreq;
	}

	@JsonProperty("reviewFreq")
	public void setReviewFreq(String reviewFreq) {
		this.reviewFreq = reviewFreq;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}