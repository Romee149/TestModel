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
@JsonPropertyOrder({ "_schVn", "_vn", "acctGroup", "acctTitle", "acctType", "desc", "isBrokered", "isElectronicStmt",
		"isPaperStmt", "isWthFed", "isWthNra", "isWthState", "signedDocs", "stmtFreq", "tmZoneCode", "acctNbr",
		"localeData", "baseCcy", "openDtm" })

public class AcctBk {

	@JsonProperty("_schVn")
	private Integer schVn;
	@JsonProperty("_vn")
	private Integer vn;
	@JsonProperty("acctGroup")
	private Integer acctGroup;
	@JsonProperty("acctTitle")
	private String acctTitle;
	@JsonProperty("acctType")
	private String acctType;
	@JsonProperty("desc")
	private String desc;
	@JsonProperty("isBrokered")
	private Boolean isBrokered;
	@JsonProperty("isElectronicStmt")
	private Boolean isElectronicStmt;
	@JsonProperty("isPaperStmt")
	private Boolean isPaperStmt;
	@JsonProperty("isWthFed")
	private Boolean isWthFed;
	@JsonProperty("isWthNra")
	private Boolean isWthNra;
	@JsonProperty("isWthState")
	private Boolean isWthState;
	@JsonProperty("signedDocs")
	private List<Object> signedDocs;
	@JsonProperty("stmtFreq")
	private String stmtFreq;
	@JsonProperty("tmZoneCode")
	private String tmZoneCode;
	@JsonProperty("acctNbr")
	private String acctNbr;
	@JsonProperty("localeData")
	private LocaleData localeData;
	@JsonProperty("baseCcy")
	private String baseCcy;
	@JsonProperty("openDtm")
	private String openDtm;
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

	@JsonProperty("acctGroup")
	public Integer getAcctGroup() {
		return acctGroup;
	}

	@JsonProperty("acctGroup")
	public void setAcctGroup(Integer acctGroup) {
		this.acctGroup = acctGroup;
	}

	@JsonProperty("acctTitle")
	public String getAcctTitle() {
		return acctTitle;
	}

	@JsonProperty("acctTitle")
	public void setAcctTitle(String acctTitle) {
		this.acctTitle = acctTitle;
	}

	@JsonProperty("acctType")
	public String getAcctType() {
		return acctType;
	}

	@JsonProperty("acctType")
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	@JsonProperty("desc")
	public String getDesc() {
		return desc;
	}

	@JsonProperty("desc")
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@JsonProperty("isBrokered")
	public Boolean getIsBrokered() {
		return isBrokered;
	}

	@JsonProperty("isBrokered")
	public void setIsBrokered(Boolean isBrokered) {
		this.isBrokered = isBrokered;
	}

	@JsonProperty("isElectronicStmt")
	public Boolean getIsElectronicStmt() {
		return isElectronicStmt;
	}

	@JsonProperty("isElectronicStmt")
	public void setIsElectronicStmt(Boolean isElectronicStmt) {
		this.isElectronicStmt = isElectronicStmt;
	}

	@JsonProperty("isPaperStmt")
	public Boolean getIsPaperStmt() {
		return isPaperStmt;
	}

	@JsonProperty("isPaperStmt")
	public void setIsPaperStmt(Boolean isPaperStmt) {
		this.isPaperStmt = isPaperStmt;
	}

	@JsonProperty("isWthFed")
	public Boolean getIsWthFed() {
		return isWthFed;
	}

	@JsonProperty("isWthFed")
	public void setIsWthFed(Boolean isWthFed) {
		this.isWthFed = isWthFed;
	}

	@JsonProperty("isWthNra")
	public Boolean getIsWthNra() {
		return isWthNra;
	}

	@JsonProperty("isWthNra")
	public void setIsWthNra(Boolean isWthNra) {
		this.isWthNra = isWthNra;
	}

	@JsonProperty("isWthState")
	public Boolean getIsWthState() {
		return isWthState;
	}

	@JsonProperty("isWthState")
	public void setIsWthState(Boolean isWthState) {
		this.isWthState = isWthState;
	}

	@JsonProperty("signedDocs")
	public List<Object> getSignedDocs() {
		return signedDocs;
	}

	@JsonProperty("signedDocs")
	public void setSignedDocs(List<Object> signedDocs) {
		this.signedDocs = signedDocs;
	}

	@JsonProperty("stmtFreq")
	public String getStmtFreq() {
		return stmtFreq;
	}

	@JsonProperty("stmtFreq")
	public void setStmtFreq(String stmtFreq) {
		this.stmtFreq = stmtFreq;
	}

	@JsonProperty("tmZoneCode")
	public String getTmZoneCode() {
		return tmZoneCode;
	}

	@JsonProperty("tmZoneCode")
	public void setTmZoneCode(String tmZoneCode) {
		this.tmZoneCode = tmZoneCode;
	}

	@JsonProperty("acctNbr")
	public String getAcctNbr() {
		return acctNbr;
	}

	@JsonProperty("acctNbr")
	public void setAcctNbr(String acctNbr) {
		this.acctNbr = acctNbr;
	}

	@JsonProperty("localeData")
	public LocaleData getLocaleData() {
		return localeData;
	}

	@JsonProperty("localeData")
	public void setLocaleData(LocaleData localeData) {
		this.localeData = localeData;
	}

	@JsonProperty("baseCcy")
	public String getBaseCcy() {
		return baseCcy;
	}

	@JsonProperty("baseCcy")
	public void setBaseCcy(String baseCcy) {
		this.baseCcy = baseCcy;
	}

	@JsonProperty("openDtm")
	public String getOpenDtm() {
		return openDtm;
	}

	@JsonProperty("openDtm")
	public void setOpenDtm(String openDtm) {
		this.openDtm = openDtm;
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