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
@JsonPropertyOrder({ "addresses", "customer", "party_person" })

public class CreateConsumer {

	@JsonProperty("addresses")
	private List<Address> addresses;
	@JsonProperty("customer")
	private Customer customer;
	@JsonProperty("party_person")
	private PartyPerson partyPerson;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("addresses")
	public List<Address> getAddresses() {
		return addresses;
	}

	@JsonProperty("addresses")
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@JsonProperty("customer")
	public Customer getCustomer() {
		return customer;
	}

	@JsonProperty("customer")
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@JsonProperty("party_person")
	public PartyPerson getPartyPerson() {
		return partyPerson;
	}

	@JsonProperty("party_person")
	public void setPartyPerson(PartyPerson partyPerson) {
		this.partyPerson = partyPerson;
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