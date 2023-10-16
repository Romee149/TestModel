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
@JsonPropertyOrder({ "payoutFreq", "payoutTrnCode" })

public class TrnRewardProgram {

	@JsonProperty("payoutFreq")
	private String payoutFreq;
	@JsonProperty("payoutTrnCode")
	private String payoutTrnCode;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("payoutFreq")
	public String getPayoutFreq() {
		return payoutFreq;
	}

	@JsonProperty("payoutFreq")
	public void setPayoutFreq(String payoutFreq) {
		this.payoutFreq = payoutFreq;
	}

	@JsonProperty("payoutTrnCode")
	public String getPayoutTrnCode() {
		return payoutTrnCode;
	}

	@JsonProperty("payoutTrnCode")
	public void setPayoutTrnCode(String payoutTrnCode) {
		this.payoutTrnCode = payoutTrnCode;
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