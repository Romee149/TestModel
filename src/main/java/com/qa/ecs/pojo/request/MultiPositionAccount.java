package com.qa.ecs.pojo.request;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "customer", "newAccounts" })

public class MultiPositionAccount {

	@JsonProperty("customer")
	private Customer customer;
	@JsonProperty("newAccounts")
	private List<NewAccount> newAccounts;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("customer")
	public Customer getCustomer() {
		return customer;
	}

	@JsonProperty("customer")
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@JsonProperty("newAccounts")
	public List<NewAccount> getNewAccounts() {
		return newAccounts;
	}

	@JsonProperty("newAccounts")
	public void setNewAccounts(List<NewAccount> newAccounts) {
		this.newAccounts = newAccounts;
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
