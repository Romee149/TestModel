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
@JsonPropertyOrder({ "acctGroup", "acctNbr", "entryName", "isDr", "posnAcctNbr", "posnId", "trnAmt", "_Ix", "ccyCode",
		"comment" })

public class Entry {

	@JsonProperty("acctGroup")
	private Integer acctGroup;
	@JsonProperty("acctNbr")
	private String acctNbr;
	@JsonProperty("entryName")
	private String entryName;
	@JsonProperty("isDr")
	private Boolean isDr;
	@JsonProperty("posnAcctNbr")
	private String posnAcctNbr;
	@JsonProperty("posnId")
	private String posnId;
	@JsonProperty("trnAmt")
	private Integer trnAmt;
	@JsonProperty("_Ix")
	private Integer ix;
	@JsonProperty("ccyCode")
	private String ccyCode;
	@JsonProperty("comment")
	private String comment;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("acctGroup")
	public Integer getAcctGroup() {
		return acctGroup;
	}

	@JsonProperty("acctGroup")
	public void setAcctGroup(Integer acctGroup) {
		this.acctGroup = acctGroup;
	}

	@JsonProperty("acctNbr")
	public String getAcctNbr() {
		return acctNbr;
	}

	@JsonProperty("acctNbr")
	public void setAcctNbr(String acctNbr) {
		this.acctNbr = acctNbr;
	}

	@JsonProperty("entryName")
	public String getEntryName() {
		return entryName;
	}

	@JsonProperty("entryName")
	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}

	@JsonProperty("isDr")
	public Boolean getIsDr() {
		return isDr;
	}

	@JsonProperty("isDr")
	public void setIsDr(Boolean isDr) {
		this.isDr = isDr;
	}

	@JsonProperty("posnAcctNbr")
	public String getPosnAcctNbr() {
		return posnAcctNbr;
	}

	@JsonProperty("posnAcctNbr")
	public void setPosnAcctNbr(String posnAcctNbr) {
		this.posnAcctNbr = posnAcctNbr;
	}

	@JsonProperty("posnId")
	public String getPosnId() {
		return posnId;
	}

	@JsonProperty("posnId")
	public void setPosnId(String posnId) {
		this.posnId = posnId;
	}

	@JsonProperty("trnAmt")
	public Integer getTrnAmt() {
		return trnAmt;
	}

	@JsonProperty("trnAmt")
	public void setTrnAmt(Integer trnAmt) {
		this.trnAmt = trnAmt;
	}

	@JsonProperty("_Ix")
	public Integer getIx() {
		return ix;
	}

	@JsonProperty("_Ix")
	public void setIx(Integer ix) {
		this.ix = ix;
	}

	@JsonProperty("ccyCode")
	public String getCcyCode() {
		return ccyCode;
	}

	@JsonProperty("ccyCode")
	public void setCcyCode(String ccyCode) {
		this.ccyCode = ccyCode;
	}

	@JsonProperty("comment")
	public String getComment() {
		return comment;
	}

	@JsonProperty("comment")
	public void setComment(String comment) {
		this.comment = comment;
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