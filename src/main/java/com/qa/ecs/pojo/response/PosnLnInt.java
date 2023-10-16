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
@JsonPropertyOrder({ "_Id", "accrCalcTm", "accrCarryOverOpt", "accumToDtm", "acrAccumLog", "apr", "balOpt", "calcMthd",
		"componentName", "disbmtOpt", "index", "isCompoundDly", "nextPostDtm", "nomRate", "postFreq", "postRoundOpt",
		"sumIntPd", "version", "_uLog", "_cDtm", "_uDtm", "_vn", "_flags", "_schVn", "_cLogRef", "_uLogRef", "_cLog" })

public class PosnLnInt {

	@JsonProperty("_Id")
	private String id;
	@JsonProperty("accrCalcTm")
	private String accrCalcTm;
	@JsonProperty("accrCarryOverOpt")
	private Integer accrCarryOverOpt;
	@JsonProperty("accumToDtm")
	private String accumToDtm;
	@JsonProperty("acrAccumLog")
	private String acrAccumLog;
	@JsonProperty("apr")
	private Double apr;
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
	@JsonProperty("isCompoundDly")
	private Boolean isCompoundDly;
	@JsonProperty("nextPostDtm")
	private String nextPostDtm;
	@JsonProperty("nomRate")
	private Double nomRate;
	@JsonProperty("postFreq")
	private String postFreq;
	@JsonProperty("postRoundOpt")
	private Integer postRoundOpt;
	@JsonProperty("sumIntPd")
	private Double sumIntPd;
	@JsonProperty("version")
	private Integer version;
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

	@JsonProperty("apr")
	public Double getApr() {
		return apr;
	}

	@JsonProperty("apr")
	public void setApr(Double apr) {
		this.apr = apr;
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

	@JsonProperty("isCompoundDly")
	public Boolean getIsCompoundDly() {
		return isCompoundDly;
	}

	@JsonProperty("isCompoundDly")
	public void setIsCompoundDly(Boolean isCompoundDly) {
		this.isCompoundDly = isCompoundDly;
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
