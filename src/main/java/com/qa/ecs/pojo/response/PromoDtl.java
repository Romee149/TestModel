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
@JsonPropertyOrder({ "indexName", "promoTerm" })

public class PromoDtl {

	@JsonProperty("indexName")
	private String indexName;
	@JsonProperty("promoTerm")
	private String promoTerm;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("indexName")
	public String getIndexName() {
		return indexName;
	}

	@JsonProperty("indexName")
	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	@JsonProperty("promoTerm")
	public String getPromoTerm() {
		return promoTerm;
	}

	@JsonProperty("promoTerm")
	public void setPromoTerm(String promoTerm) {
		this.promoTerm = promoTerm;
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
