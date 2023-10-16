package com.qa.ecs.pojo.response;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "_Id", "addrs", "cntry", "emails", "isDataShare", "lstContactDate", "name", "phones", "tin",
		"tinType", "_uLog", "_uDtm", "_vn", "_flags", "_schVn", "_cLogRef", "_class", "desc", "estDate", "region",
		"_cDtm", "party_orgDueDiligence", "_attch" })
@Generated("jsonschema2pojo")
public class PartyOrg {

	@JsonProperty("_Id")
	private String id;
	@JsonProperty("addrs")
	private List<Addr> addrs;
	@JsonProperty("cntry")
	private String cntry;
	@JsonProperty("emails")
	private List<Email> emails;
	@JsonProperty("isDataShare")
	private Boolean isDataShare;
	@JsonProperty("lstContactDate")
	private String lstContactDate;
	@JsonProperty("name")
	private String name;
	@JsonProperty("phones")
	private List<Phone> phones;
	@JsonProperty("tin")
	private String tin;
	@JsonProperty("tinType")
	private Integer tinType;
	@JsonProperty("_uLog")
	private String uLog;
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
	@JsonProperty("_class")
	private String _class;
	@JsonProperty("desc")
	private String desc;
	@JsonProperty("estDate")
	private String estDate;
	@JsonProperty("region")
	private String region;
	@JsonProperty("_cDtm")
	private String cDtm;
	@JsonProperty("party_orgDueDiligence")
	private PartyOrgDueDiligence partyOrgDueDiligence;
	@JsonProperty("_attch")
	private String attch;
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

	@JsonProperty("addrs")
	public List<Addr> getAddrs() {
		return addrs;
	}

	@JsonProperty("addrs")
	public void setAddrs(List<Addr> addrs) {
		this.addrs = addrs;
	}

	@JsonProperty("cntry")
	public String getCntry() {
		return cntry;
	}

	@JsonProperty("cntry")
	public void setCntry(String cntry) {
		this.cntry = cntry;
	}

	@JsonProperty("emails")
	public List<Email> getEmails() {
		return emails;
	}

	@JsonProperty("emails")
	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	@JsonProperty("isDataShare")
	public Boolean getIsDataShare() {
		return isDataShare;
	}

	@JsonProperty("isDataShare")
	public void setIsDataShare(Boolean isDataShare) {
		this.isDataShare = isDataShare;
	}

	@JsonProperty("lstContactDate")
	public String getLstContactDate() {
		return lstContactDate;
	}

	@JsonProperty("lstContactDate")
	public void setLstContactDate(String lstContactDate) {
		this.lstContactDate = lstContactDate;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("phones")
	public List<Phone> getPhones() {
		return phones;
	}

	@JsonProperty("phones")
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
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

	@JsonProperty("_uLog")
	public String getULog() {
		return uLog;
	}

	@JsonProperty("_uLog")
	public void setULog(String uLog) {
		this.uLog = uLog;
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

	@JsonProperty("_class")
	public String getClass_() {
		return _class;
	}

	@JsonProperty("_class")
	public void setClass_(String _class) {
		this._class = _class;
	}

	@JsonProperty("desc")
	public String getDesc() {
		return desc;
	}

	@JsonProperty("desc")
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@JsonProperty("estDate")
	public String getEstDate() {
		return estDate;
	}

	@JsonProperty("estDate")
	public void setEstDate(String estDate) {
		this.estDate = estDate;
	}

	@JsonProperty("region")
	public String getRegion() {
		return region;
	}

	@JsonProperty("region")
	public void setRegion(String region) {
		this.region = region;
	}

	@JsonProperty("_cDtm")
	public String getCDtm() {
		return cDtm;
	}

	@JsonProperty("_cDtm")
	public void setCDtm(String cDtm) {
		this.cDtm = cDtm;
	}

	@JsonProperty("party_orgDueDiligence")
	public PartyOrgDueDiligence getPartyOrgDueDiligence() {
		return partyOrgDueDiligence;
	}

	@JsonProperty("party_orgDueDiligence")
	public void setPartyOrgDueDiligence(PartyOrgDueDiligence partyOrgDueDiligence) {
		this.partyOrgDueDiligence = partyOrgDueDiligence;
	}

	@JsonProperty("_attch")
	public String getAttch() {
		return attch;
	}

	@JsonProperty("_attch")
	public void setAttch(String attch) {
		this.attch = attch;
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