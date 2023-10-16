package com.qa.ecs.pojo.request;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "dec0", "dec2", "dec5" })

public class SubBalAmts {

	@JsonProperty("dec0")
	private Dec0__1 dec0;
	@JsonProperty("dec2")
	private Dec2__1 dec2;
	@JsonProperty("dec5")
	private Dec5__1 dec5;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("dec0")
	public Dec0__1 getDec0() {
		return dec0;
	}

	@JsonProperty("dec0")
	public void setDec0(Dec0__1 dec0) {
		this.dec0 = dec0;
	}

	@JsonProperty("dec2")
	public Dec2__1 getDec2() {
		return dec2;
	}

	@JsonProperty("dec2")
	public void setDec2(Dec2__1 dec2) {
		this.dec2 = dec2;
	}

	@JsonProperty("dec5")
	public Dec5__1 getDec5() {
		return dec5;
	}

	@JsonProperty("dec5")
	public void setDec5(Dec5__1 dec5) {
		this.dec5 = dec5;
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