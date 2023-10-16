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
@JsonPropertyOrder({ "_schVn", "_vn", "acctgSeg", "bal", "ccyCode", "posnName", "prodName", "tmZoneCode", "subBals" })

public class PosnDep {

	@JsonProperty("_schVn")
	private Integer schVn;
	@JsonProperty("_vn")
	private Integer vn;
	@JsonProperty("acctgSeg")
	private AcctgSeg acctgSeg;
	@JsonProperty("bal")
	private Integer bal;
	@JsonProperty("ccyCode")
	private String ccyCode;
	@JsonProperty("posnName")
	private String posnName;
	@JsonProperty("prodName")
	private String prodName;
	@JsonProperty("tmZoneCode")
	private String tmZoneCode;
	@JsonProperty("subBals")
	private SubBals subBals;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("_schVn")
	public Integer getSchVn() {
		return schVn;
	}

	@JsonProperty("_schVn")
	public void setSchVn(Integer schVn) {
		this.schVn = schVn;
	}

	@JsonProperty("_vn")
	public Integer getVn() {
		return vn;
	}

	@JsonProperty("_vn")
	public void setVn(Integer vn) {
		this.vn = vn;
	}

	@JsonProperty("acctgSeg")
	public AcctgSeg getAcctgSeg() {
		return acctgSeg;
	}

	@JsonProperty("acctgSeg")
	public void setAcctgSeg(AcctgSeg acctgSeg) {
		this.acctgSeg = acctgSeg;
	}

	@JsonProperty("bal")
	public Integer getBal() {
		return bal;
	}

	@JsonProperty("bal")
	public void setBal(Integer bal) {
		this.bal = bal;
	}

	@JsonProperty("ccyCode")
	public String getCcyCode() {
		return ccyCode;
	}

	@JsonProperty("ccyCode")
	public void setCcyCode(String ccyCode) {
		this.ccyCode = ccyCode;
	}

	@JsonProperty("posnName")
	public String getPosnName() {
		return posnName;
	}

	@JsonProperty("posnName")
	public void setPosnName(String posnName) {
		this.posnName = posnName;
	}

	@JsonProperty("prodName")
	public String getProdName() {
		return prodName;
	}

	@JsonProperty("prodName")
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	@JsonProperty("tmZoneCode")
	public String getTmZoneCode() {
		return tmZoneCode;
	}

	@JsonProperty("tmZoneCode")
	public void setTmZoneCode(String tmZoneCode) {
		this.tmZoneCode = tmZoneCode;
	}

	@JsonProperty("subBals")
	public SubBals getSubBals() {
		return subBals;
	}

	@JsonProperty("subBals")
	public void setSubBals(SubBals subBals) {
		this.subBals = subBals;
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