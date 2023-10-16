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
@JsonPropertyOrder({ "customerGroup", "loginId", "startDtm", "customerId" })

public class Customer {

	@JsonProperty("customerGroup")
	private String customerGroup;
	@JsonProperty("loginId")
	private String loginId;
	@JsonProperty("startDtm")
	private String startDtm;
	@JsonProperty("customerId")
	private String customerId;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("customerGroup")
	public String getCustomerGroup() {
		return customerGroup;
	}

	@JsonProperty("customerGroup")
	public void setCustomerGroup(String customerGroup) {
		this.customerGroup = customerGroup;
	}

	@JsonProperty("loginId")
	public String getLoginId() {
		return loginId;
	}

	@JsonProperty("loginId")
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	@JsonProperty("startDtm")
	public String getStartDtm() {
		return startDtm;
	}

	@JsonProperty("startDtm")
	public void setStartDtm(String startDtm) {
		this.startDtm = startDtm;
	}

	@JsonProperty("customerId")
	public String getCustomerId() {
		return customerId;
	}

	@JsonProperty("customerId")
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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