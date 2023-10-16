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
@JsonPropertyOrder({ "nextAssessDtm" })
public class MonthlyFee {

	@JsonProperty("nextAssessDtm")
	private String nextAssessDtm;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("nextAssessDtm")
	public String getNextAssessDtm() {
		return nextAssessDtm;
	}

	@JsonProperty("nextAssessDtm")
	public void setNextAssessDtm(String nextAssessDtm) {
		this.nextAssessDtm = nextAssessDtm;
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