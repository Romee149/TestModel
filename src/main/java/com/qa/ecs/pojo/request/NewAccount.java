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
@JsonPropertyOrder({ "Acct", "AcctPartyRel" })

public class NewAccount {

	@JsonProperty("Acct")
	private Acct acct;
	@JsonProperty("AcctPartyRel")
	private AcctPartyRel acctPartyRel;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("Acct")
	public Acct getAcct() {
		return acct;
	}

	@JsonProperty("Acct")
	public void setAcct(Acct acct) {
		this.acct = acct;
	}

	@JsonProperty("AcctPartyRel")
	public AcctPartyRel getAcctPartyRel() {
		return acctPartyRel;
	}

	@JsonProperty("AcctPartyRel")
	public void setAcctPartyRel(AcctPartyRel acctPartyRel) {
		this.acctPartyRel = acctPartyRel;
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