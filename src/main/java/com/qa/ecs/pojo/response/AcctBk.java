package com.qa.ecs.pojo.response;

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
@JsonPropertyOrder({ "acctGroup", "acctNbr", "acctTitle", "desc", "openDtm", "_uLog", "_uDtm", "_vn", "_flags",
		"_schVn", "_cLogRef", "_cLog", "_class", "acctType", "assetClass", "assetId", "baseCcy", "isBrokered",
		"isElectronicStmt", "isPaperStmt", "isWthFed", "isWthNra", "isWthState", "nextStmtDtm", "signedDocs",
		"stmtFreq", "tmZoneCode", "aggBalSDA", "aggBalDDA", "aggBalCDA", "aggBalMMA", "aggBalCMA", "aggBalCCA",
		"aggBalEQU", "aggBalILA", "aggBalCLA", "aggBalLOC", "aggBalAsset", "aggBalLiability", "status", "_cDtm",
		"localeData" })

public class AcctBk {

	@JsonProperty("acctGroup")
	private Integer acctGroup;
	@JsonProperty("acctNbr")
	private String acctNbr;
	@JsonProperty("acctTitle")
	private String acctTitle;
	@JsonProperty("desc")
	private String desc;
	@JsonProperty("openDtm")
	private String openDtm;
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
	@JsonProperty("_cLog")
	private String cLog;
	@JsonProperty("_class")
	private String _class;
	@JsonProperty("acctType")
	private String acctType;
	@JsonProperty("assetClass")
	private Integer assetClass;
	@JsonProperty("assetId")
	private String assetId;
	@JsonProperty("baseCcy")
	private String baseCcy;
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
	@JsonProperty("nextStmtDtm")
	private String nextStmtDtm;
	@JsonProperty("signedDocs")
	private List<Object> signedDocs;
	@JsonProperty("stmtFreq")
	private String stmtFreq;
	@JsonProperty("tmZoneCode")
	private String tmZoneCode;
	@JsonProperty("aggBalSDA")
	private Double aggBalSDA;
	@JsonProperty("aggBalDDA")
	private Double aggBalDDA;
	@JsonProperty("aggBalCDA")
	private Double aggBalCDA;
	@JsonProperty("aggBalMMA")
	private Double aggBalMMA;
	@JsonProperty("aggBalCMA")
	private Double aggBalCMA;
	@JsonProperty("aggBalCCA")
	private Double aggBalCCA;
	@JsonProperty("aggBalEQU")
	private Double aggBalEQU;
	@JsonProperty("aggBalILA")
	private Double aggBalILA;
	@JsonProperty("aggBalCLA")
	private Double aggBalCLA;
	@JsonProperty("aggBalLOC")
	private Double aggBalLOC;
	@JsonProperty("aggBalAsset")
	private Double aggBalAsset;
	@JsonProperty("aggBalLiability")
	private Double aggBalLiability;
	@JsonProperty("status")
	private Integer status;
	@JsonProperty("_cDtm")
	private String cDtm;
	@JsonProperty("localeData")
	private LocaleData localeData;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("acctGroup")
	public Integer getAcctGroup() {
		return acctGroup;
	}

	@JsonProperty("acctGroup")
	public void setAcctGroup(Integer acctGroup) {
		this.acctGroup = acctGroup;
	}

	@JsonProperty("acctNbr")
	public String getAcctNbr() {
		return acctNbr;
	}

	@JsonProperty("acctNbr")
	public void setAcctNbr(String acctNbr) {
		this.acctNbr = acctNbr;
	}

	@JsonProperty("acctTitle")
	public String getAcctTitle() {
		return acctTitle;
	}

	@JsonProperty("acctTitle")
	public void setAcctTitle(String acctTitle) {
		this.acctTitle = acctTitle;
	}

	@JsonProperty("desc")
	public String getDesc() {
		return desc;
	}

	@JsonProperty("desc")
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@JsonProperty("openDtm")
	public String getOpenDtm() {
		return openDtm;
	}

	@JsonProperty("openDtm")
	public void setOpenDtm(String openDtm) {
		this.openDtm = openDtm;
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

	@JsonProperty("_cLog")
	public String getCLog() {
		return cLog;
	}

	@JsonProperty("_cLog")
	public void setCLog(String cLog) {
		this.cLog = cLog;
	}

	@JsonProperty("_class")
	public String getClass_() {
		return _class;
	}

	@JsonProperty("_class")
	public void setClass_(String _class) {
		this._class = _class;
	}

	@JsonProperty("acctType")
	public String getAcctType() {
		return acctType;
	}

	@JsonProperty("acctType")
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	@JsonProperty("assetClass")
	public Integer getAssetClass() {
		return assetClass;
	}

	@JsonProperty("assetClass")
	public void setAssetClass(Integer assetClass) {
		this.assetClass = assetClass;
	}

	@JsonProperty("assetId")
	public String getAssetId() {
		return assetId;
	}

	@JsonProperty("assetId")
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	@JsonProperty("baseCcy")
	public String getBaseCcy() {
		return baseCcy;
	}

	@JsonProperty("baseCcy")
	public void setBaseCcy(String baseCcy) {
		this.baseCcy = baseCcy;
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

	@JsonProperty("nextStmtDtm")
	public String getNextStmtDtm() {
		return nextStmtDtm;
	}

	@JsonProperty("nextStmtDtm")
	public void setNextStmtDtm(String nextStmtDtm) {
		this.nextStmtDtm = nextStmtDtm;
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

	@JsonProperty("aggBalSDA")
	public Double getAggBalSDA() {
		return aggBalSDA;
	}

	@JsonProperty("aggBalSDA")
	public void setAggBalSDA(Double aggBalSDA) {
		this.aggBalSDA = aggBalSDA;
	}

	@JsonProperty("aggBalDDA")
	public Double getAggBalDDA() {
		return aggBalDDA;
	}

	@JsonProperty("aggBalDDA")
	public void setAggBalDDA(Double aggBalDDA) {
		this.aggBalDDA = aggBalDDA;
	}

	@JsonProperty("aggBalCDA")
	public Double getAggBalCDA() {
		return aggBalCDA;
	}

	@JsonProperty("aggBalCDA")
	public void setAggBalCDA(Double aggBalCDA) {
		this.aggBalCDA = aggBalCDA;
	}

	@JsonProperty("aggBalMMA")
	public Double getAggBalMMA() {
		return aggBalMMA;
	}

	@JsonProperty("aggBalMMA")
	public void setAggBalMMA(Double aggBalMMA) {
		this.aggBalMMA = aggBalMMA;
	}

	@JsonProperty("aggBalCMA")
	public Double getAggBalCMA() {
		return aggBalCMA;
	}

	@JsonProperty("aggBalCMA")
	public void setAggBalCMA(Double aggBalCMA) {
		this.aggBalCMA = aggBalCMA;
	}

	@JsonProperty("aggBalCCA")
	public Double getAggBalCCA() {
		return aggBalCCA;
	}

	@JsonProperty("aggBalCCA")
	public void setAggBalCCA(Double aggBalCCA) {
		this.aggBalCCA = aggBalCCA;
	}

	@JsonProperty("aggBalEQU")
	public Double getAggBalEQU() {
		return aggBalEQU;
	}

	@JsonProperty("aggBalEQU")
	public void setAggBalEQU(Double aggBalEQU) {
		this.aggBalEQU = aggBalEQU;
	}

	@JsonProperty("aggBalILA")
	public Double getAggBalILA() {
		return aggBalILA;
	}

	@JsonProperty("aggBalILA")
	public void setAggBalILA(Double aggBalILA) {
		this.aggBalILA = aggBalILA;
	}

	@JsonProperty("aggBalCLA")
	public Double getAggBalCLA() {
		return aggBalCLA;
	}

	@JsonProperty("aggBalCLA")
	public void setAggBalCLA(Double aggBalCLA) {
		this.aggBalCLA = aggBalCLA;
	}

	@JsonProperty("aggBalLOC")
	public Double getAggBalLOC() {
		return aggBalLOC;
	}

	@JsonProperty("aggBalLOC")
	public void setAggBalLOC(Double aggBalLOC) {
		this.aggBalLOC = aggBalLOC;
	}

	@JsonProperty("aggBalAsset")
	public Double getAggBalAsset() {
		return aggBalAsset;
	}

	@JsonProperty("aggBalAsset")
	public void setAggBalAsset(Double aggBalAsset) {
		this.aggBalAsset = aggBalAsset;
	}

	@JsonProperty("aggBalLiability")
	public Double getAggBalLiability() {
		return aggBalLiability;
	}

	@JsonProperty("aggBalLiability")
	public void setAggBalLiability(Double aggBalLiability) {
		this.aggBalLiability = aggBalLiability;
	}

	@JsonProperty("status")
	public Integer getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(Integer status) {
		this.status = status;
	}

	@JsonProperty("_cDtm")
	public String getCDtm() {
		return cDtm;
	}

	@JsonProperty("_cDtm")
	public void setCDtm(String cDtm) {
		this.cDtm = cDtm;
	}

	@JsonProperty("localeData")
	public LocaleData getLocaleData() {
		return localeData;
	}

	@JsonProperty("localeData")
	public void setLocaleData(LocaleData localeData) {
		this.localeData = localeData;
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