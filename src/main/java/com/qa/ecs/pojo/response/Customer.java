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
@JsonPropertyOrder({ "customerGroup", "loginId", "customerId", "startDtm", "party_person", "addresses",
		"partyGroupMembers" })

public class Customer {

	@JsonProperty("customerGroup")
	private String customerGroup;
	@JsonProperty("loginId")
	private String loginId;
	@JsonProperty("customerId")
	private String customerId;
	@JsonProperty("startDtm")
	private String startDtm;
	@JsonProperty("party_person")
	private PartyPerson partyPerson;
	@JsonProperty("addresses")
	private List<Address> addresses;
	@JsonProperty("partyGroupMembers")
	private List<PartyGroupMember> partyGroupMembers;
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

	@JsonProperty("customerId")
	public String getCustomerId() {
		return customerId;
	}

	@JsonProperty("customerId")
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@JsonProperty("startDtm")
	public String getStartDtm() {
		return startDtm;
	}

	@JsonProperty("startDtm")
	public void setStartDtm(String startDtm) {
		this.startDtm = startDtm;
	}

	@JsonProperty("party_person")
	public PartyPerson getPartyPerson() {
		return partyPerson;
	}

	@JsonProperty("party_person")
	public void setPartyPerson(PartyPerson partyPerson) {
		this.partyPerson = partyPerson;
	}

	@JsonProperty("addresses")
	public List<Address> getAddresses() {
		return addresses;
	}

	@JsonProperty("addresses")
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@JsonProperty("partyGroupMembers")
	public List<PartyGroupMember> getPartyGroupMembers() {
		return partyGroupMembers;
	}

	@JsonProperty("partyGroupMembers")
	public void setPartyGroupMembers(List<PartyGroupMember> partyGroupMembers) {
		this.partyGroupMembers = partyGroupMembers;
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