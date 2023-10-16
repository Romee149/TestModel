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
@JsonPropertyOrder({ "prodName", "acct_bk", "posn_depDtl", "posn_lnDtl" })

public class CreatedAccount {

	@JsonProperty("prodName")
	private String prodName;
	@JsonProperty("acct_bk")
	private AcctBk acctBk;
	@JsonProperty("posn_depDtl")
	private List<PosnDepDtl> posnDepDtl;
	@JsonProperty("posn_lnDtl")
	private List<PosnLnDtl> posnLnDtl;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("prodName")
	public String getProdName() {
		return prodName;
	}

	@JsonProperty("prodName")
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	@JsonProperty("acct_bk")
	public AcctBk getAcctBk() {
		return acctBk;
	}

	@JsonProperty("acct_bk")
	public void setAcctBk(AcctBk acctBk) {
		this.acctBk = acctBk;
	}

	@JsonProperty("posn_depDtl")
	public List<PosnDepDtl> getPosnDepDtl() {
		return posnDepDtl;
	}

	@JsonProperty("posn_depDtl")
	public void setPosnDepDtl(List<PosnDepDtl> posnDepDtl) {
		this.posnDepDtl = posnDepDtl;
	}

	@JsonProperty("posn_lnDtl")
	public List<PosnLnDtl> getPosnLnDtl() {
		return posnLnDtl;
	}

	@JsonProperty("posn_lnDtl")
	public void setPosnLnDtl(List<PosnLnDtl> posnLnDtl) {
		this.posnLnDtl = posnLnDtl;
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
