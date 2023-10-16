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
@JsonPropertyOrder({ "_Id", "acctGroup", "acctNbr", "assetClass", "assetId", "bal", "posnAcctNbr", "posnName",
		"posnNbr", "tmZoneCode", "_uLog", "_uDtm", "_vn", "_flags", "_schVn", "_cLogRef", "_class", "acctgSeg",
		"ccyCode", "fundExpDtm", "glCat", "glSetCode", "isEarlySettleOptOut", "openDtm", "prodName", "subBals",
		"ifxAcctType", "_cDtm", "posn_depFee", "posn_depInt", "posn_depLimit", "posn_depReward", "_attch", "localeData",
		"posn_depTd", "posn_depNsf" })

public class PosnDep {

	@JsonProperty("_Id")
	private String id;
	@JsonProperty("acctGroup")
	private Integer acctGroup;
	@JsonProperty("acctNbr")
	private String acctNbr;
	@JsonProperty("assetClass")
	private Integer assetClass;
	@JsonProperty("assetId")
	private String assetId;
	@JsonProperty("bal")
	private Double bal;
	@JsonProperty("posnAcctNbr")
	private String posnAcctNbr;
	@JsonProperty("posnName")
	private String posnName;
	@JsonProperty("posnNbr")
	private Integer posnNbr;
	@JsonProperty("tmZoneCode")
	private String tmZoneCode;
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
	@JsonProperty("acctgSeg")
	private AcctgSeg acctgSeg;
	@JsonProperty("ccyCode")
	private String ccyCode;
	@JsonProperty("fundExpDtm")
	private String fundExpDtm;
	@JsonProperty("glCat")
	private Integer glCat;
	@JsonProperty("glSetCode")
	private String glSetCode;
	@JsonProperty("isEarlySettleOptOut")
	private Boolean isEarlySettleOptOut;
	@JsonProperty("openDtm")
	private String openDtm;
	@JsonProperty("prodName")
	private String prodName;
	@JsonProperty("subBals")
	private SubBals subBals;
	@JsonProperty("ifxAcctType")
	private String ifxAcctType;
	@JsonProperty("_cDtm")
	private String cDtm;
	@JsonProperty("posn_depFee")
	private PosnDepFee posnDepFee;
	@JsonProperty("posn_depInt")
	private PosnDepInt posnDepInt;
	@JsonProperty("posn_depLimit")
	private PosnDepLimit posnDepLimit;
	@JsonProperty("posn_depReward")
	private PosnDepReward posnDepReward;
	@JsonProperty("_attch")
	private String attch;
	@JsonProperty("localeData")
	private LocaleData__1 localeData;
	@JsonProperty("posn_depTd")
	private PosnDepTd posnDepTd;
	@JsonProperty("posn_depNsf")
	private PosnDepNsf posnDepNsf;
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

	@JsonProperty("bal")
	public Double getBal() {
		return bal;
	}

	@JsonProperty("bal")
	public void setBal(Double bal) {
		this.bal = bal;
	}

	@JsonProperty("posnAcctNbr")
	public String getPosnAcctNbr() {
		return posnAcctNbr;
	}

	@JsonProperty("posnAcctNbr")
	public void setPosnAcctNbr(String posnAcctNbr) {
		this.posnAcctNbr = posnAcctNbr;
	}

	@JsonProperty("posnName")
	public String getPosnName() {
		return posnName;
	}

	@JsonProperty("posnName")
	public void setPosnName(String posnName) {
		this.posnName = posnName;
	}

	@JsonProperty("posnNbr")
	public Integer getPosnNbr() {
		return posnNbr;
	}

	@JsonProperty("posnNbr")
	public void setPosnNbr(Integer posnNbr) {
		this.posnNbr = posnNbr;
	}

	@JsonProperty("tmZoneCode")
	public String getTmZoneCode() {
		return tmZoneCode;
	}

	@JsonProperty("tmZoneCode")
	public void setTmZoneCode(String tmZoneCode) {
		this.tmZoneCode = tmZoneCode;
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

	@JsonProperty("acctgSeg")
	public AcctgSeg getAcctgSeg() {
		return acctgSeg;
	}

	@JsonProperty("acctgSeg")
	public void setAcctgSeg(AcctgSeg acctgSeg) {
		this.acctgSeg = acctgSeg;
	}

	@JsonProperty("ccyCode")
	public String getCcyCode() {
		return ccyCode;
	}

	@JsonProperty("ccyCode")
	public void setCcyCode(String ccyCode) {
		this.ccyCode = ccyCode;
	}

	@JsonProperty("fundExpDtm")
	public String getFundExpDtm() {
		return fundExpDtm;
	}

	@JsonProperty("fundExpDtm")
	public void setFundExpDtm(String fundExpDtm) {
		this.fundExpDtm = fundExpDtm;
	}

	@JsonProperty("glCat")
	public Integer getGlCat() {
		return glCat;
	}

	@JsonProperty("glCat")
	public void setGlCat(Integer glCat) {
		this.glCat = glCat;
	}

	@JsonProperty("glSetCode")
	public String getGlSetCode() {
		return glSetCode;
	}

	@JsonProperty("glSetCode")
	public void setGlSetCode(String glSetCode) {
		this.glSetCode = glSetCode;
	}

	@JsonProperty("isEarlySettleOptOut")
	public Boolean getIsEarlySettleOptOut() {
		return isEarlySettleOptOut;
	}

	@JsonProperty("isEarlySettleOptOut")
	public void setIsEarlySettleOptOut(Boolean isEarlySettleOptOut) {
		this.isEarlySettleOptOut = isEarlySettleOptOut;
	}

	@JsonProperty("openDtm")
	public String getOpenDtm() {
		return openDtm;
	}

	@JsonProperty("openDtm")
	public void setOpenDtm(String openDtm) {
		this.openDtm = openDtm;
	}

	@JsonProperty("prodName")
	public String getProdName() {
		return prodName;
	}

	@JsonProperty("prodName")
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	@JsonProperty("subBals")
	public SubBals getSubBals() {
		return subBals;
	}

	@JsonProperty("subBals")
	public void setSubBals(SubBals subBals) {
		this.subBals = subBals;
	}

	@JsonProperty("ifxAcctType")
	public String getIfxAcctType() {
		return ifxAcctType;
	}

	@JsonProperty("ifxAcctType")
	public void setIfxAcctType(String ifxAcctType) {
		this.ifxAcctType = ifxAcctType;
	}

	@JsonProperty("_cDtm")
	public String getCDtm() {
		return cDtm;
	}

	@JsonProperty("_cDtm")
	public void setCDtm(String cDtm) {
		this.cDtm = cDtm;
	}

	@JsonProperty("posn_depFee")
	public PosnDepFee getPosnDepFee() {
		return posnDepFee;
	}

	@JsonProperty("posn_depFee")
	public void setPosnDepFee(PosnDepFee posnDepFee) {
		this.posnDepFee = posnDepFee;
	}

	@JsonProperty("posn_depInt")
	public PosnDepInt getPosnDepInt() {
		return posnDepInt;
	}

	@JsonProperty("posn_depInt")
	public void setPosnDepInt(PosnDepInt posnDepInt) {
		this.posnDepInt = posnDepInt;
	}

	@JsonProperty("posn_depLimit")
	public PosnDepLimit getPosnDepLimit() {
		return posnDepLimit;
	}

	@JsonProperty("posn_depLimit")
	public void setPosnDepLimit(PosnDepLimit posnDepLimit) {
		this.posnDepLimit = posnDepLimit;
	}

	@JsonProperty("posn_depReward")
	public PosnDepReward getPosnDepReward() {
		return posnDepReward;
	}

	@JsonProperty("posn_depReward")
	public void setPosnDepReward(PosnDepReward posnDepReward) {
		this.posnDepReward = posnDepReward;
	}

	@JsonProperty("_attch")
	public String getAttch() {
		return attch;
	}

	@JsonProperty("_attch")
	public void setAttch(String attch) {
		this.attch = attch;
	}

	@JsonProperty("localeData")
	public LocaleData__1 getLocaleData() {
		return localeData;
	}

	@JsonProperty("localeData")
	public void setLocaleData(LocaleData__1 localeData) {
		this.localeData = localeData;
	}

	@JsonProperty("posn_depTd")
	public PosnDepTd getPosnDepTd() {
		return posnDepTd;
	}

	@JsonProperty("posn_depTd")
	public void setPosnDepTd(PosnDepTd posnDepTd) {
		this.posnDepTd = posnDepTd;
	}

	@JsonProperty("posn_depNsf")
	public PosnDepNsf getPosnDepNsf() {
		return posnDepNsf;
	}

	@JsonProperty("posn_depNsf")
	public void setPosnDepNsf(PosnDepNsf posnDepNsf) {
		this.posnDepNsf = posnDepNsf;
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