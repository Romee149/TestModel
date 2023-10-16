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
@JsonPropertyOrder({ "acctPartyRels", "createdAccounts" })

public class AddDDAAccount {

	@JsonProperty("acctPartyRels")
	private List<AcctPartyRel> acctPartyRels;
	@JsonProperty("createdAccounts")
	private List<CreatedAccount> createdAccounts;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("acctPartyRels")
	public List<AcctPartyRel> getAcctPartyRels() {
		return acctPartyRels;
	}

	@JsonProperty("acctPartyRels")
	public void setAcctPartyRels(List<AcctPartyRel> acctPartyRels) {
		this.acctPartyRels = acctPartyRels;
	}

	@JsonProperty("createdAccounts")
	public List<CreatedAccount> getCreatedAccounts() {
		return createdAccounts;
	}

	@JsonProperty("createdAccounts")
	public void setCreatedAccounts(List<CreatedAccount> createdAccounts) {
		this.createdAccounts = createdAccounts;
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