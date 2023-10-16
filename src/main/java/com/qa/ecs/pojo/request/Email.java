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
@JsonPropertyOrder({ "_schVn", "_vn", "data", "emailType", "isPreferred", "verifyDtm" })

public class Email {

	@JsonProperty("_schVn")
	private Integer schVn;
	@JsonProperty("_vn")
	private Integer vn;
	@JsonProperty("data")
	private String data;
	@JsonProperty("emailType")
	private Integer emailType;
	@JsonProperty("isPreferred")
	private Boolean isPreferred;
	@JsonProperty("verifyDtm")
	private String verifyDtm;
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

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
