package com.qa.ecs.pojo.request;

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
@JsonPropertyOrder({ "_schVn", "_vn", "cntry", "desc", "emails", "estDate", "name", "party_orgDueDiligence", "phones",
		"region", "tin", "tinType" })

public class PartyOrg {

	@JsonProperty("_schVn")
	private Integer schVn;
	@JsonProperty("_vn")
	private Integer vn;
	@JsonProperty("cntry")
	private String cntry;
	@JsonProperty("desc")
	private String desc;
	@JsonProperty("emails")
	private List<Email> emails;
	@JsonProperty("estDate")
	private String estDate;
	@JsonProperty("name")
	private String name;
	@JsonProperty("party_orgDueDiligence")
	private PartyOrgDueDiligence partyOrgDueDiligence;
	@JsonProperty("phones")
	private List<Phone> phones;
	@JsonProperty("region")
	private String region;
	@JsonProperty("tin")
	private String tin;
	@JsonProperty("tinType")
	private Integer tinType;
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

	@JsonProperty("cntry")
	public String getCntry() {
		return cntry;
	}

	@JsonProperty("cntry")
	public void setCntry(String cntry) {
		this.cntry = cntry;
	}

	@JsonProperty("desc")
	public String getDesc() {
		return desc;
	}

	@JsonProperty("desc")
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@JsonProperty("emails")
	public List<Email> getEmails() {
		return emails;
	}

	@JsonProperty("emails")
	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	@JsonProperty("estDate")
	public String getEstDate() {
		return estDate;
	}

	@JsonProperty("estDate")
	public void setEstDate(String estDate) {
		this.estDate = estDate;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("party_orgDueDiligence")
	public PartyOrgDueDiligence getPartyOrgDueDiligence() {
		return partyOrgDueDiligence;
	}

	@JsonProperty("party_orgDueDiligence")
	public void setPartyOrgDueDiligence(PartyOrgDueDiligence partyOrgDueDiligence) {
		this.partyOrgDueDiligence = partyOrgDueDiligence;
	}

	@JsonProperty("phones")
	public List<Phone> getPhones() {
		return phones;
	}

	@JsonProperty("phones")
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	@JsonProperty("region")
	public String getRegion() {
		return region;
	}

	@JsonProperty("region")
	public void setRegion(String region) {
		this.region = region;
	}

	@JsonProperty("tin")
	public String getTin() {
		return tin;
	}

	@JsonProperty("tin")
	public void setTin(String tin) {
		this.tin = tin;
	}

	@JsonProperty("tinType")
	public Integer getTinType() {
		return tinType;
	}

	@JsonProperty("tinType")
	public void setTinType(Integer tinType) {
		this.tinType = tinType;
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
