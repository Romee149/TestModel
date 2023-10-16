package com.qa.ecs.pojo.response;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "_Id", "acctStatus", "acctType", "compCondCode", "idNbr", "specialComment", "_uLog", "_cDtm",
		"_uDtm", "_vn", "_flags", "_schVn", "_cLogRef" })

public class PosnLnUSBankInfo {

	@JsonProperty("_Id")
	private String id;
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
	@JsonProperty("_uLog")
	private String uLog;
	@JsonProperty("_cDtm")
	private String cDtm;
	@JsonProperty("_uDtm")
	private String uDtm;
	@JsonProperty("_vn")
	private Integer vn;
	@JsonProperty("_flags")
	private Integer flags;
	@JsonProperty("_schVn")
	private Integer schVn;
	@JsonProperty("_cLogRef")
	private String cLogRef;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("_Id")
	public String getId() {
		return id;
	}

	@JsonProperty("_Id")
	public void setId(String id) {
		this.id = id;
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

	@JsonProperty("_uLog")
	public String getULog() {
		return uLog;
	}

	@JsonProperty("_uLog")
	public void setULog(String uLog) {
		this.uLog = uLog;
	}

	@JsonProperty("_cDtm")
	public String getCDtm() {
		return cDtm;
	}

	@JsonProperty("_cDtm")
	public void setCDtm(String cDtm) {
		this.cDtm = cDtm;
	}

	@JsonProperty("_uDtm")
	public String getUDtm() {
		return uDtm;
	}

	@JsonProperty("_uDtm")
	public void setUDtm(String uDtm) {
		this.uDtm = uDtm;
	}

	@JsonProperty("_vn")
	public Integer getVn() {
		return vn;
	}

	@JsonProperty("_vn")
	public void setVn(Integer vn) {
		this.vn = vn;
	}

	@JsonProperty("_flags")
	public Integer getFlags() {
		return flags;
	}

	@JsonProperty("_flags")
	public void setFlags(Integer flags) {
		this.flags = flags;
	}

	@JsonProperty("_schVn")
	public Integer getSchVn() {
		return schVn;
	}

	@JsonProperty("_schVn")
	public void setSchVn(Integer schVn) {
		this.schVn = schVn;
	}

	@JsonProperty("_cLogRef")
	public String getCLogRef() {
		return cLogRef;
	}

	@JsonProperty("_cLogRef")
	public void setCLogRef(String cLogRef) {
		this.cLogRef = cLogRef;
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