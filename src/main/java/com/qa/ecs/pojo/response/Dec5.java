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
@JsonPropertyOrder({ "accrInt", "negAccr", "capInt", "forgiveInt", "waiveInt" })
public class Dec5 {

	@JsonProperty("accrInt")
	private Double accrInt;
	@JsonProperty("negAccr")
	private Double negAccr;
	@JsonProperty("capInt")
	private Double capInt;
	@JsonProperty("forgiveInt")
	private Double forgiveInt;
	@JsonProperty("waiveInt")
	private Double waiveInt;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("accrInt")
	public Double getAccrInt() {
		return accrInt;
	}

	@JsonProperty("accrInt")
	public void setAccrInt(Double accrInt) {
		this.accrInt = accrInt;
	}

	@JsonProperty("negAccr")
	public Double getNegAccr() {
		return negAccr;
	}

	@JsonProperty("negAccr")
	public void setNegAccr(Double negAccr) {
		this.negAccr = negAccr;
	}

	@JsonProperty("capInt")
	public Double getCapInt() {
		return capInt;
	}

	@JsonProperty("capInt")
	public void setCapInt(Double capInt) {
		this.capInt = capInt;
	}

	@JsonProperty("forgiveInt")
	public Double getForgiveInt() {
		return forgiveInt;
	}

	@JsonProperty("forgiveInt")
	public void setForgiveInt(Double forgiveInt) {
		this.forgiveInt = forgiveInt;
	}

	@JsonProperty("waiveInt")
	public Double getWaiveInt() {
		return waiveInt;
	}

	@JsonProperty("waiveInt")
	public void setWaiveInt(Double waiveInt) {
		this.waiveInt = waiveInt;
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