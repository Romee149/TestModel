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
@JsonPropertyOrder({ "_Id", "amortizeDur", "billCapInt", "componentName", "dueDate", "firstDueDate", "fixPmtAmt",
		"gracePeriod", "intMthd", "isFixAmortize", "isMaturityAutoPmt", "isRevolving", "isRtReceivable",
		"isUnapplFunds", "minPmt", "nextReceivableDtm", "pastDue", "payoffVarianceAmt", "pmtApplAdvance", "pmtApplMthd",
		"pmtDur", "pmtFreq", "pmtOffset", "prePmtMinAmt", "prinBalBase", "prinMthd", "startDtm", "toleranceAmt",
		"version", "_uLog", "_cDtm", "_uDtm", "_vn", "_flags", "_schVn", "_cLogRef", "_uLogRef", "_cLog" })

public class PosnLnRepay {

	@JsonProperty("_Id")
	private String id;
	@JsonProperty("amortizeDur")
	private String amortizeDur;
	@JsonProperty("billCapInt")
	private Boolean billCapInt;
	@JsonProperty("componentName")
	private String componentName;
	@JsonProperty("dueDate")
	private String dueDate;
	@JsonProperty("firstDueDate")
	private String firstDueDate;
	@JsonProperty("fixPmtAmt")
	private Double fixPmtAmt;
	@JsonProperty("gracePeriod")
	private String gracePeriod;
	@JsonProperty("intMthd")
	private Integer intMthd;
	@JsonProperty("isFixAmortize")
	private Boolean isFixAmortize;
	@JsonProperty("isMaturityAutoPmt")
	private Boolean isMaturityAutoPmt;
	@JsonProperty("isRevolving")
	private Boolean isRevolving;
	@JsonProperty("isRtReceivable")
	private Boolean isRtReceivable;
	@JsonProperty("isUnapplFunds")
	private Boolean isUnapplFunds;
	@JsonProperty("minPmt")
	private Integer minPmt;
	@JsonProperty("nextReceivableDtm")
	private String nextReceivableDtm;
	@JsonProperty("pastDue")
	private List<PastDue> pastDue;
	@JsonProperty("payoffVarianceAmt")
	private Double payoffVarianceAmt;
	@JsonProperty("pmtApplAdvance")
	private Integer pmtApplAdvance;
	@JsonProperty("pmtApplMthd")
	private PmtApplMthd pmtApplMthd;
	@JsonProperty("pmtDur")
	private String pmtDur;
	@JsonProperty("pmtFreq")
	private String pmtFreq;
	@JsonProperty("pmtOffset")
	private String pmtOffset;
	@JsonProperty("prePmtMinAmt")
	private Double prePmtMinAmt;
	@JsonProperty("prinBalBase")
	private Integer prinBalBase;
	@JsonProperty("prinMthd")
	private Integer prinMthd;
	@JsonProperty("startDtm")
	private String startDtm;
	@JsonProperty("toleranceAmt")
	private Double toleranceAmt;
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

	@JsonProperty("amortizeDur")
	public String getAmortizeDur() {
		return amortizeDur;
	}

	@JsonProperty("amortizeDur")
	public void setAmortizeDur(String amortizeDur) {
		this.amortizeDur = amortizeDur;
	}

	@JsonProperty("billCapInt")
	public Boolean getBillCapInt() {
		return billCapInt;
	}

	@JsonProperty("billCapInt")
	public void setBillCapInt(Boolean billCapInt) {
		this.billCapInt = billCapInt;
	}

	@JsonProperty("componentName")
	public String getComponentName() {
		return componentName;
	}

	@JsonProperty("componentName")
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	@JsonProperty("dueDate")
	public String getDueDate() {
		return dueDate;
	}

	@JsonProperty("dueDate")
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	@JsonProperty("firstDueDate")
	public String getFirstDueDate() {
		return firstDueDate;
	}

	@JsonProperty("firstDueDate")
	public void setFirstDueDate(String firstDueDate) {
		this.firstDueDate = firstDueDate;
	}

	@JsonProperty("fixPmtAmt")
	public Double getFixPmtAmt() {
		return fixPmtAmt;
	}

	@JsonProperty("fixPmtAmt")
	public void setFixPmtAmt(Double fixPmtAmt) {
		this.fixPmtAmt = fixPmtAmt;
	}

	@JsonProperty("gracePeriod")
	public String getGracePeriod() {
		return gracePeriod;
	}

	@JsonProperty("gracePeriod")
	public void setGracePeriod(String gracePeriod) {
		this.gracePeriod = gracePeriod;
	}

	@JsonProperty("intMthd")
	public Integer getIntMthd() {
		return intMthd;
	}

	@JsonProperty("intMthd")
	public void setIntMthd(Integer intMthd) {
		this.intMthd = intMthd;
	}

	@JsonProperty("isFixAmortize")
	public Boolean getIsFixAmortize() {
		return isFixAmortize;
	}

	@JsonProperty("isFixAmortize")
	public void setIsFixAmortize(Boolean isFixAmortize) {
		this.isFixAmortize = isFixAmortize;
	}

	@JsonProperty("isMaturityAutoPmt")
	public Boolean getIsMaturityAutoPmt() {
		return isMaturityAutoPmt;
	}

	@JsonProperty("isMaturityAutoPmt")
	public void setIsMaturityAutoPmt(Boolean isMaturityAutoPmt) {
		this.isMaturityAutoPmt = isMaturityAutoPmt;
	}

	@JsonProperty("isRevolving")
	public Boolean getIsRevolving() {
		return isRevolving;
	}

	@JsonProperty("isRevolving")
	public void setIsRevolving(Boolean isRevolving) {
		this.isRevolving = isRevolving;
	}

	@JsonProperty("isRtReceivable")
	public Boolean getIsRtReceivable() {
		return isRtReceivable;
	}

	@JsonProperty("isRtReceivable")
	public void setIsRtReceivable(Boolean isRtReceivable) {
		this.isRtReceivable = isRtReceivable;
	}

	@JsonProperty("isUnapplFunds")
	public Boolean getIsUnapplFunds() {
		return isUnapplFunds;
	}

	@JsonProperty("isUnapplFunds")
	public void setIsUnapplFunds(Boolean isUnapplFunds) {
		this.isUnapplFunds = isUnapplFunds;
	}

	@JsonProperty("minPmt")
	public Integer getMinPmt() {
		return minPmt;
	}

	@JsonProperty("minPmt")
	public void setMinPmt(Integer minPmt) {
		this.minPmt = minPmt;
	}

	@JsonProperty("nextReceivableDtm")
	public String getNextReceivableDtm() {
		return nextReceivableDtm;
	}

	@JsonProperty("nextReceivableDtm")
	public void setNextReceivableDtm(String nextReceivableDtm) {
		this.nextReceivableDtm = nextReceivableDtm;
	}

	@JsonProperty("pastDue")
	public List<PastDue> getPastDue() {
		return pastDue;
	}

	@JsonProperty("pastDue")
	public void setPastDue(List<PastDue> pastDue) {
		this.pastDue = pastDue;
	}

	@JsonProperty("payoffVarianceAmt")
	public Double getPayoffVarianceAmt() {
		return payoffVarianceAmt;
	}

	@JsonProperty("payoffVarianceAmt")
	public void setPayoffVarianceAmt(Double payoffVarianceAmt) {
		this.payoffVarianceAmt = payoffVarianceAmt;
	}

	@JsonProperty("pmtApplAdvance")
	public Integer getPmtApplAdvance() {
		return pmtApplAdvance;
	}

	@JsonProperty("pmtApplAdvance")
	public void setPmtApplAdvance(Integer pmtApplAdvance) {
		this.pmtApplAdvance = pmtApplAdvance;
	}

	@JsonProperty("pmtApplMthd")
	public PmtApplMthd getPmtApplMthd() {
		return pmtApplMthd;
	}

	@JsonProperty("pmtApplMthd")
	public void setPmtApplMthd(PmtApplMthd pmtApplMthd) {
		this.pmtApplMthd = pmtApplMthd;
	}

	@JsonProperty("pmtDur")
	public String getPmtDur() {
		return pmtDur;
	}

	@JsonProperty("pmtDur")
	public void setPmtDur(String pmtDur) {
		this.pmtDur = pmtDur;
	}

	@JsonProperty("pmtFreq")
	public String getPmtFreq() {
		return pmtFreq;
	}

	@JsonProperty("pmtFreq")
	public void setPmtFreq(String pmtFreq) {
		this.pmtFreq = pmtFreq;
	}

	@JsonProperty("pmtOffset")
	public String getPmtOffset() {
		return pmtOffset;
	}

	@JsonProperty("pmtOffset")
	public void setPmtOffset(String pmtOffset) {
		this.pmtOffset = pmtOffset;
	}

	@JsonProperty("prePmtMinAmt")
	public Double getPrePmtMinAmt() {
		return prePmtMinAmt;
	}

	@JsonProperty("prePmtMinAmt")
	public void setPrePmtMinAmt(Double prePmtMinAmt) {
		this.prePmtMinAmt = prePmtMinAmt;
	}

	@JsonProperty("prinBalBase")
	public Integer getPrinBalBase() {
		return prinBalBase;
	}

	@JsonProperty("prinBalBase")
	public void setPrinBalBase(Integer prinBalBase) {
		this.prinBalBase = prinBalBase;
	}

	@JsonProperty("prinMthd")
	public Integer getPrinMthd() {
		return prinMthd;
	}

	@JsonProperty("prinMthd")
	public void setPrinMthd(Integer prinMthd) {
		this.prinMthd = prinMthd;
	}

	@JsonProperty("startDtm")
	public String getStartDtm() {
		return startDtm;
	}

	@JsonProperty("startDtm")
	public void setStartDtm(String startDtm) {
		this.startDtm = startDtm;
	}

	@JsonProperty("toleranceAmt")
	public Double getToleranceAmt() {
		return toleranceAmt;
	}

	@JsonProperty("toleranceAmt")
	public void setToleranceAmt(Double toleranceAmt) {
		this.toleranceAmt = toleranceAmt;
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