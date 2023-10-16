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
@JsonPropertyOrder({ "_schVn", "_vn", "data", "isPreferred", "phoneType", "verifyDtm" })

public class Phone {

	@JsonProperty("_schVn")
	private Integer schVn;
	@JsonProperty("_vn")
	private Integer vn;
	@JsonProperty("data")
	private String data;
	@JsonProperty("isPreferred")
	private Boolean isPreferred;
	@JsonProperty("phoneType")
	private Integer phoneType;
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

	@JsonProperty("isPreferred")
	public Boolean getIsPreferred() {
		return isPreferred;
	}

	@JsonProperty("isPreferred")
	public void setIsPreferred(Boolean isPreferred) {
		this.isPreferred = isPreferred;
	}

	@JsonProperty("phoneType")
	public Integer getPhoneType() {
		return phoneType;
	}

	@JsonProperty("phoneType")
	public void setPhoneType(Integer phoneType) {
		this.phoneType = phoneType;
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
