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
@JsonPropertyOrder({ "_Id", "accrCalcTm", "accrCarryOverOpt", "accrMinBal", "accumToDtm", "acrAccumLog", "balOpt",
		"calcMthd", "componentName", "disbmtOpt", "index", "is1099Exempt", "isCompoundDly", "isWthFed", "isWthNra",
		"isWthState", "nextPostDtm", "nomRate", "origNomRate", "postFreq", "postRoundOpt", "promoDtl", "promoExpDtm",
		"sumIntPd", "version", "_uLog", "intPdYr", "intPdPriorYr", "accrIntBal", "negAccrIntBal", "apy", "nxtAccrDtm",
		"accrPostBal", "apye", "nxtAccrRate", "daysNxtPost", "_cDtm", "_uDtm", "_vn", "_flags", "_schVn", "_cLogRef",
		"_uLogRef", "_cLog" })

public class PosnDepInt {

	@JsonProperty("_Id")
	private String id;
	@JsonProperty("accrCalcTm")
	private String accrCalcTm;
	@JsonProperty("accrCarryOverOpt")
	private Integer accrCarryOverOpt;
	@JsonProperty("accrMinBal")
	private Double accrMinBal;
	@JsonProperty("accumToDtm")
	private String accumToDtm;
	@JsonProperty("acrAccumLog")
	private String acrAccumLog;
	@JsonProperty("balOpt")
	private Integer balOpt;
	@JsonProperty("calcMthd")
	private Integer calcMthd;
	@JsonProperty("componentName")
	private String componentName;
	@JsonProperty("disbmtOpt")
	private Integer disbmtOpt;
	@JsonProperty("index")
	private Index index;
	@JsonProperty("is1099Exempt")
	private Boolean is1099Exempt;
	@JsonProperty("isCompoundDly")
	private Boolean isCompoundDly;
	@JsonProperty("isWthFed")
	private Boolean isWthFed;
	@JsonProperty("isWthNra")
	private Boolean isWthNra;
	@JsonProperty("isWthState")
	private Boolean isWthState;
	@JsonProperty("nextPostDtm")
	private String nextPostDtm;
	@JsonProperty("nomRate")
	private Double nomRate;
	@JsonProperty("origNomRate")
	private Double origNomRate;
	@JsonProperty("postFreq")
	private String postFreq;
	@JsonProperty("postRoundOpt")
	private Integer postRoundOpt;
	@JsonProperty("promoDtl")
	private PromoDtl promoDtl;
	@JsonProperty("promoExpDtm")
	private String promoExpDtm;
	@JsonProperty("sumIntPd")
	private Double sumIntPd;
	@JsonProperty("version")
	private Integer version;
	@JsonProperty("_uLog")
	private String uLog;
	@JsonProperty("intPdYr")
	private Double intPdYr;
	@JsonProperty("intPdPriorYr")
	private Double intPdPriorYr;
	@JsonProperty("accrIntBal")
	private Double accrIntBal;
	@JsonProperty("negAccrIntBal")
	private Double negAccrIntBal;
	@JsonProperty("apy")
	private Double apy;
	@JsonProperty("nxtAccrDtm")
	private String nxtAccrDtm;
	@JsonProperty("accrPostBal")
	private Double accrPostBal;
	@JsonProperty("apye")
	private Double apye;
	@JsonProperty("nxtAccrRate")
	private Double nxtAccrRate;
	@JsonProperty("daysNxtPost")
	private Integer daysNxtPost;
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
	@JsonProperty("_uLogRef")
	private String uLogRef;
	@JsonProperty("_cLog")
	private String cLog;
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

	@JsonProperty("accrCalcTm")
	public String getAccrCalcTm() {
		return accrCalcTm;
	}

	@JsonProperty("accrCalcTm")
	public void setAccrCalcTm(String accrCalcTm) {
		this.accrCalcTm = accrCalcTm;
	}

	@JsonProperty("accrCarryOverOpt")
	public Integer getAccrCarryOverOpt() {
		return accrCarryOverOpt;
	}

	@JsonProperty("accrCarryOverOpt")
	public void setAccrCarryOverOpt(Integer accrCarryOverOpt) {
		this.accrCarryOverOpt = accrCarryOverOpt;
	}

	@JsonProperty("accrMinBal")
	public Double getAccrMinBal() {
		return accrMinBal;
	}

	@JsonProperty("accrMinBal")
	public void setAccrMinBal(Double accrMinBal) {
		this.accrMinBal = accrMinBal;
	}

	@JsonProperty("accumToDtm")
	public String getAccumToDtm() {
		return accumToDtm;
	}

	@JsonProperty("accumToDtm")
	public void setAccumToDtm(String accumToDtm) {
		this.accumToDtm = accumToDtm;
	}

	@JsonProperty("acrAccumLog")
	public String getAcrAccumLog() {
		return acrAccumLog;
	}

	@JsonProperty("acrAccumLog")
	public void setAcrAccumLog(String acrAccumLog) {
		this.acrAccumLog = acrAccumLog;
	}

	@JsonProperty("balOpt")
	public Integer getBalOpt() {
		return balOpt;
	}

	@JsonProperty("balOpt")
	public void setBalOpt(Integer balOpt) {
		this.balOpt = balOpt;
	}

	@JsonProperty("calcMthd")
	public Integer getCalcMthd() {
		return calcMthd;
	}

	@JsonProperty("calcMthd")
	public void setCalcMthd(Integer calcMthd) {
		this.calcMthd = calcMthd;
	}

	@JsonProperty("componentName")
	public String getComponentName() {
		return componentName;
	}

	@JsonProperty("componentName")
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	@JsonProperty("disbmtOpt")
	public Integer getDisbmtOpt() {
		return disbmtOpt;
	}

	@JsonProperty("disbmtOpt")
	public void setDisbmtOpt(Integer disbmtOpt) {
		this.disbmtOpt = disbmtOpt;
	}

	@JsonProperty("index")
	public Index getIndex() {
		return index;
	}

	@JsonProperty("index")
	public void setIndex(Index index) {
		this.index = index;
	}

	@JsonProperty("is1099Exempt")
	public Boolean getIs1099Exempt() {
		return is1099Exempt;
	}

	@JsonProperty("is1099Exempt")
	public void setIs1099Exempt(Boolean is1099Exempt) {
		this.is1099Exempt = is1099Exempt;
	}

	@JsonProperty("isCompoundDly")
	public Boolean getIsCompoundDly() {
		return isCompoundDly;
	}

	@JsonProperty("isCompoundDly")
	public void setIsCompoundDly(Boolean isCompoundDly) {
		this.isCompoundDly = isCompoundDly;
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

	@JsonProperty("nextPostDtm")
	public String getNextPostDtm() {
		return nextPostDtm;
	}

	@JsonProperty("nextPostDtm")
	public void setNextPostDtm(String nextPostDtm) {
		this.nextPostDtm = nextPostDtm;
	}

	@JsonProperty("nomRate")
	public Double getNomRate() {
		return nomRate;
	}

	@JsonProperty("nomRate")
	public void setNomRate(Double nomRate) {
		this.nomRate = nomRate;
	}

	@JsonProperty("origNomRate")
	public Double getOrigNomRate() {
		return origNomRate;
	}

	@JsonProperty("origNomRate")
	public void setOrigNomRate(Double origNomRate) {
		this.origNomRate = origNomRate;
	}

	@JsonProperty("postFreq")
	public String getPostFreq() {
		return postFreq;
	}

	@JsonProperty("postFreq")
	public void setPostFreq(String postFreq) {
		this.postFreq = postFreq;
	}

	@JsonProperty("postRoundOpt")
	public Integer getPostRoundOpt() {
		return postRoundOpt;
	}

	@JsonProperty("postRoundOpt")
	public void setPostRoundOpt(Integer postRoundOpt) {
		this.postRoundOpt = postRoundOpt;
	}

	@JsonProperty("promoDtl")
	public PromoDtl getPromoDtl() {
		return promoDtl;
	}

	@JsonProperty("promoDtl")
	public void setPromoDtl(PromoDtl promoDtl) {
		this.promoDtl = promoDtl;
	}

	@JsonProperty("promoExpDtm")
	public String getPromoExpDtm() {
		return promoExpDtm;
	}

	@JsonProperty("promoExpDtm")
	public void setPromoExpDtm(String promoExpDtm) {
		this.promoExpDtm = promoExpDtm;
	}

	@JsonProperty("sumIntPd")
	public Double getSumIntPd() {
		return sumIntPd;
	}

	@JsonProperty("sumIntPd")
	public void setSumIntPd(Double sumIntPd) {
		this.sumIntPd = sumIntPd;
	}

	@JsonProperty("version")
	public Integer getVersion() {
		return version;
	}

	@JsonProperty("version")
	public void setVersion(Integer version) {
		this.version = version;
	}

	@JsonProperty("_uLog")
	public String getULog() {
		return uLog;
	}

	@JsonProperty("_uLog")
	public void setULog(String uLog) {
		this.uLog = uLog;
	}

	@JsonProperty("intPdYr")
	public Double getIntPdYr() {
		return intPdYr;
	}

	@JsonProperty("intPdYr")
	public void setIntPdYr(Double intPdYr) {
		this.intPdYr = intPdYr;
	}

	@JsonProperty("intPdPriorYr")
	public Double getIntPdPriorYr() {
		return intPdPriorYr;
	}

	@JsonProperty("intPdPriorYr")
	public void setIntPdPriorYr(Double intPdPriorYr) {
		this.intPdPriorYr = intPdPriorYr;
	}

	@JsonProperty("accrIntBal")
	public Double getAccrIntBal() {
		return accrIntBal;
	}

	@JsonProperty("accrIntBal")
	public void setAccrIntBal(Double accrIntBal) {
		this.accrIntBal = accrIntBal;
	}

	@JsonProperty("negAccrIntBal")
	public Double getNegAccrIntBal() {
		return negAccrIntBal;
	}

	@JsonProperty("negAccrIntBal")
	public void setNegAccrIntBal(Double negAccrIntBal) {
		this.negAccrIntBal = negAccrIntBal;
	}

	@JsonProperty("apy")
	public Double getApy() {
		return apy;
	}

	@JsonProperty("apy")
	public void setApy(Double apy) {
		this.apy = apy;
	}

	@JsonProperty("nxtAccrDtm")
	public String getNxtAccrDtm() {
		return nxtAccrDtm;
	}

	@JsonProperty("nxtAccrDtm")
	public void setNxtAccrDtm(String nxtAccrDtm) {
		this.nxtAccrDtm = nxtAccrDtm;
	}

	@JsonProperty("accrPostBal")
	public Double getAccrPostBal() {
		return accrPostBal;
	}

	@JsonProperty("accrPostBal")
	public void setAccrPostBal(Double accrPostBal) {
		this.accrPostBal = accrPostBal;
	}

	@JsonProperty("apye")
	public Double getApye() {
		return apye;
	}

	@JsonProperty("apye")
	public void setApye(Double apye) {
		this.apye = apye;
	}

	@JsonProperty("nxtAccrRate")
	public Double getNxtAccrRate() {
		return nxtAccrRate;
	}

	@JsonProperty("nxtAccrRate")
	public void setNxtAccrRate(Double nxtAccrRate) {
		this.nxtAccrRate = nxtAccrRate;
	}

	@JsonProperty("daysNxtPost")
	public Integer getDaysNxtPost() {
		return daysNxtPost;
	}

	@JsonProperty("daysNxtPost")
	public void setDaysNxtPost(Integer daysNxtPost) {
		this.daysNxtPost = daysNxtPost;
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

	@JsonProperty("_uLogRef")
	public String getULogRef() {
		return uLogRef;
	}

	@JsonProperty("_uLogRef")
	public void setULogRef(String uLogRef) {
		this.uLogRef = uLogRef;
	}

	@JsonProperty("_cLog")
	public String getCLog() {
		return cLog;
	}

	@JsonProperty("_cLog")
	public void setCLog(String cLog) {
		this.cLog = cLog;
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
