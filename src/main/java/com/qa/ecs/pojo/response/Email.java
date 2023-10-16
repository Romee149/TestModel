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
@JsonPropertyOrder({ "_Id", "_Ix", "data", "emailType", "isPreferred", "verifyDtm", "_uLog", "_cDtm", "_uDtm", "_vn",
		"_flags", "_schVn", "_cLogRef" })

public class Email {

	@JsonProperty("_Id")
	private String id;
	@JsonProperty("_Ix")
	private Integer ix;
	@JsonProperty("data")
	private String data;
	@JsonProperty("emailType")
	private Integer emailType;
	@JsonProperty("isPreferred")
	private Boolean isPreferred;
	@JsonProperty("verifyDtm")
	private String verifyDtm;
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

	@JsonProperty("_Ix")
	public Integer getIx() {
		return ix;
	}

	@JsonProperty("_Ix")
	public void setIx(Integer ix) {
		this.ix = ix;
	}

	@JsonProperty("data")
	public String getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(String data) {
		this.data = data;
	}

	@JsonProperty("emailType")
	public Integer getEmailType() {
		return emailType;
	}

	@JsonProperty("emailType")
	public void setEmailType(Integer emailType) {
		this.emailType = emailType;
	}

	@JsonProperty("isPreferred")
	public Boolean getIsPreferred() {
		return isPreferred;
	}

	@JsonProperty("isPreferred")
	public void setIsPreferred(Boolean isPreferred) {
		this.isPreferred = isPreferred;
	}

	@JsonProperty("verifyDtm")
	public String getVerifyDtm() {
		return verifyDtm;
	}

	@JsonProperty("verifyDtm")
	public void setVerifyDtm(String verifyDtm) {
		this.verifyDtm = verifyDtm;
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