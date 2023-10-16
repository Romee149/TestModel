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
@JsonPropertyOrder({ "_schVn", "_vn", "addrType", "city", "cntry", "postCode", "region", "street", "validFromDtm",
		"yrsAddr", "adrTypeEntry", "_Ix", "addrId", "verifyDtm", "isInvalidAddr" })
public class Address {

	@JsonProperty("_schVn")
	private Integer schVn;
	@JsonProperty("_vn")
	private Integer vn;
	@JsonProperty("addrType")
	private String addrType;
	@JsonProperty("city")
	private String city;
	@JsonProperty("cntry")
	private String cntry;
	@JsonProperty("postCode")
	private String postCode;
	@JsonProperty("region")
	private String region;
	@JsonProperty("street")
	private String street;
	@JsonProperty("validFromDtm")
	private String validFromDtm;
	@JsonProperty("yrsAddr")
	private String yrsAddr;
	@JsonProperty("adrTypeEntry")
	private String adrTypeEntry;
	@JsonProperty("_Ix")
	private Integer ix;
	@JsonProperty("addrId")
	private String addrId;
	@JsonProperty("verifyDtm")
	private String verifyDtm;
	@JsonProperty("isInvalidAddr")
	private Boolean isInvalidAddr;
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

	@JsonProperty("addrType")
	public String getAddrType() {
		return addrType;
	}

	@JsonProperty("addrType")
	public void setAddrType(String addrType) {
		this.addrType = addrType;
	}

	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

	@JsonProperty("cntry")
	public String getCntry() {
		return cntry;
	}

	@JsonProperty("cntry")
	public void setCntry(String cntry) {
		this.cntry = cntry;
	}

	@JsonProperty("postCode")
	public String getPostCode() {
		return postCode;
	}

	@JsonProperty("postCode")
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@JsonProperty("region")
	public String getRegion() {
		return region;
	}

	@JsonProperty("region")
	public void setRegion(String region) {
		this.region = region;
	}

	@JsonProperty("street")
	public String getStreet() {
		return street;
	}

	@JsonProperty("street")
	public void setStreet(String street) {
		this.street = street;
	}

	@JsonProperty("validFromDtm")
	public String getValidFromDtm() {
		return validFromDtm;
	}

	@JsonProperty("validFromDtm")
	public void setValidFromDtm(String validFromDtm) {
		this.validFromDtm = validFromDtm;
	}

	@JsonProperty("yrsAddr")
	public String getYrsAddr() {
		return yrsAddr;
	}

	@JsonProperty("yrsAddr")
	public void setYrsAddr(String yrsAddr) {
		this.yrsAddr = yrsAddr;
	}

	@JsonProperty("adrTypeEntry")
	public String getAdrTypeEntry() {
		return adrTypeEntry;
	}

	@JsonProperty("adrTypeEntry")
	public void setAdrTypeEntry(String adrTypeEntry) {
		this.adrTypeEntry = adrTypeEntry;
	}

	@JsonProperty("_Ix")
	public Integer getIx() {
		return ix;
	}

	@JsonProperty("_Ix")
	public void setIx(Integer ix) {
		this.ix = ix;
	}

	@JsonProperty("addrId")
	public String getAddrId() {
		return addrId;
	}

	@JsonProperty("addrId")
	public void setAddrId(String addrId) {
		this.addrId = addrId;
	}

	@JsonProperty("verifyDtm")
	public String getVerifyDtm() {
		return verifyDtm;
	}

	@JsonProperty("verifyDtm")
	public void setVerifyDtm(String verifyDtm) {
		this.verifyDtm = verifyDtm;
	}

	@JsonProperty("isInvalidAddr")
	public Boolean getIsInvalidAddr() {
		return isInvalidAddr;
	}

	@JsonProperty("isInvalidAddr")
	public void setIsInvalidAddr(Boolean isInvalidAddr) {
		this.isInvalidAddr = isInvalidAddr;
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