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
@JsonPropertyOrder({ "_schVn", "_vn", "acctgSeg", "availBal", "bal", "ccyCode", "crLimit", "posnName", "prodName",
		"subBals", "tmZoneCode", "subBalAmts", "purposeCode", "posn_lnUSBankInfo" })

public class PosnLn {

	@JsonProperty("_schVn")
	private Integer schVn;
	@JsonProperty("_vn")
	private Integer vn;
	@JsonProperty("acctgSeg")
	private AcctgSeg acctgSeg;
	@JsonProperty("availBal")
	private Integer availBal;
	@JsonProperty("bal")
	private Integer bal;
	@JsonProperty("ccyCode")
	private String ccyCode;
	@JsonProperty("crLimit")
	private Integer crLimit;
	@JsonProperty("posnName")
	private String posnName;
	@JsonProperty("prodName")
	private String prodName;
	@JsonProperty("subBals")
	private SubBals subBals;
	@JsonProperty("tmZoneCode")
	private String tmZoneCode;
	@JsonProperty("subBalAmts")
	private SubBalAmts subBalAmts;
	@JsonProperty("purposeCode")
	private String purposeCode;
	@JsonProperty("posn_lnUSBankInfo")
	private PosnLnUSBankInfo posnLnUSBankInfo;
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

	@JsonProperty("availBal")
	public Integer getAvailBal() {
		return availBal;
	}

	@JsonProperty("availBal")
	public void setAvailBal(Integer availBal) {
		this.availBal = availBal;
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

	@JsonProperty("crLimit")
	public Integer getCrLimit() {
		return crLimit;
	}

	@JsonProperty("crLimit")
	public void setCrLimit(Integer crLimit) {
		this.crLimit = crLimit;
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

	@JsonProperty("subBals")
	public SubBals getSubBals() {
		return subBals;
	}

	@JsonProperty("subBals")
	public void setSubBals(SubBals subBals) {
		this.subBals = subBals;
	}

	@JsonProperty("tmZoneCode")
	public String getTmZoneCode() {
		return tmZoneCode;
	}

	@JsonProperty("tmZoneCode")
	public void setTmZoneCode(String tmZoneCode) {
		this.tmZoneCode = tmZoneCode;
	}

	@JsonProperty("subBalAmts")
	public SubBalAmts getSubBalAmts() {
		return subBalAmts;
	}

	@JsonProperty("subBalAmts")
	public void setSubBalAmts(SubBalAmts subBalAmts) {
		this.subBalAmts = subBalAmts;
	}

	@JsonProperty("purposeCode")
	public String getPurposeCode() {
		return purposeCode;
	}

	@JsonProperty("purposeCode")
	public void setPurposeCode(String purposeCode) {
		this.purposeCode = purposeCode;
	}

	@JsonProperty("posn_lnUSBankInfo")
	public PosnLnUSBankInfo getPosnLnUSBankInfo() {
		return posnLnUSBankInfo;
	}

	@JsonProperty("posn_lnUSBankInfo")
	public void setPosnLnUSBankInfo(PosnLnUSBankInfo posnLnUSBankInfo) {
		this.posnLnUSBankInfo = posnLnUSBankInfo;
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