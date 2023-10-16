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
@JsonPropertyOrder({ "_schVn", "_vn", "acctStatus", "acctType", "compCondCode", "idNbr", "specialComment" })

public class PosnLnUSBankInfo {

	@JsonProperty("_schVn")
	private Integer schVn;
	@JsonProperty("_vn")
	private Integer vn;
	@JsonProperty("acctStatus")
	private Integer acctStatus;
	@JsonProperty("acctType")
	private Integer acctType;
	@JsonProperty("compCondCode")
	private Integer compCondCode;
	@JsonProperty("idNbr")
	private String idNbr;
	@JsonProperty("specialComment")
	private Integer specialComment;
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

	@JsonProperty("acctStatus")
	public Integer getAcctStatus() {
		return acctStatus;
	}

	@JsonProperty("acctStatus")
	public void setAcctStatus(Integer acctStatus) {
		this.acctStatus = acctStatus;
	}

	@JsonProperty("acctType")
	public Integer getAcctType() {
		return acctType;
	}

	@JsonProperty("acctType")
	public void setAcctType(Integer acctType) {
		this.acctType = acctType;
	}

	@JsonProperty("compCondCode")
	public Integer getCompCondCode() {
		return compCondCode;
	}

	@JsonProperty("compCondCode")
	public void setCompCondCode(Integer compCondCode) {
		this.compCondCode = compCondCode;
	}

	@JsonProperty("idNbr")
	public String getIdNbr() {
		return idNbr;
	}

	@JsonProperty("idNbr")
	public void setIdNbr(String idNbr) {
		this.idNbr = idNbr;
	}

	@JsonProperty("specialComment")
	public Integer getSpecialComment() {
		return specialComment;
	}

	@JsonProperty("specialComment")
	public void setSpecialComment(Integer specialComment) {
		this.specialComment = specialComment;
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