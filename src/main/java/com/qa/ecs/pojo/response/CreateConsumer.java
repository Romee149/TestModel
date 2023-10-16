package com.qa.ecs.pojo.response;

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
@JsonPropertyOrder({ "party_person", "customer", "addresses" })

public class CreateConsumer {

	@JsonProperty("party_person")
	private PartyPerson partyPerson;
	@JsonProperty("customer")
	private Customer customer;
	@JsonProperty("addresses")
	private List<Address> addresses;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("party_person")
	public PartyPerson getPartyPerson() {
		return partyPerson;
	}

	@JsonProperty("party_person")
	public void setPartyPerson(PartyPerson partyPerson) {
		this.partyPerson = partyPerson;
	}

	@JsonProperty("customer")
	public Customer getCustomer() {
		return customer;
	}

	@JsonProperty("customer")
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@JsonProperty("addresses")
	public List<Address> getAddresses() {
		return addresses;
	}

	@JsonProperty("addresses")
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
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
