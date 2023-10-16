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
@JsonPropertyOrder({ "addresses", "customer", "party_org" })

public class CreateOrganization {

	@JsonProperty("addresses")
	private List<Address> addresses;
	@JsonProperty("customer")
	private Customer customer;
	@JsonProperty("party_org")
	private PartyOrg partyOrg;
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

	@JsonProperty("party_org")
	public PartyOrg getPartyOrg() {
		return partyOrg;
	}

	@JsonProperty("party_org")
	public void setPartyOrg(PartyOrg partyOrg) {
		this.partyOrg = partyOrg;
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
