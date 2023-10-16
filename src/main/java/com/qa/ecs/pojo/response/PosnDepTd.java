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
@JsonPropertyOrder({ "_Id", "componentName", "earlyDrPen", "initTerm", "isBumpEnabled", "maturityDtm", "maturityOpt",
		"notice", "noticeDtm", "penMatrix", "penTrnCode", "rollCnt", "rollCrGrace", "rollDrGrace", "rollDrGraceAdj",
		"rollProd", "term", "version", "_uLog", "_cDtm", "_uDtm", "_vn", "_flags", "_schVn", "_cLogRef", "_cLog" })

public class PosnDepTd {

	@JsonProperty("_Id")
	private String id;
	@JsonProperty("componentName")
	private String componentName;
	@JsonProperty("earlyDrPen")
	private Integer earlyDrPen;
	@JsonProperty("initTerm")
	private String initTerm;
	@JsonProperty("isBumpEnabled")
	private Boolean isBumpEnabled;
	@JsonProperty("maturityDtm")
	private String maturityDtm;
	@JsonProperty("maturityOpt")
	private Integer maturityOpt;
	@JsonProperty("notice")
	private String notice;
	@JsonProperty("noticeDtm")
	private String noticeDtm;
	@JsonProperty("penMatrix")
	private String penMatrix;
	@JsonProperty("penTrnCode")
	private String penTrnCode;
	@JsonProperty("rollCnt")
	private Integer rollCnt;
	@JsonProperty("rollCrGrace")
	private String rollCrGrace;
	@JsonProperty("rollDrGrace")
	private String rollDrGrace;
	@JsonProperty("rollDrGraceAdj")
	private Integer rollDrGraceAdj;
	@JsonProperty("rollProd")
	private String rollProd;
	@JsonProperty("term")
	private String term;
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

	@JsonProperty("componentName")
	public String getComponentName() {
		return componentName;
	}

	@JsonProperty("componentName")
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	@JsonProperty("earlyDrPen")
	public Integer getEarlyDrPen() {
		return earlyDrPen;
	}

	@JsonProperty("earlyDrPen")
	public void setEarlyDrPen(Integer earlyDrPen) {
		this.earlyDrPen = earlyDrPen;
	}

	@JsonProperty("initTerm")
	public String getInitTerm() {
		return initTerm;
	}

	@JsonProperty("initTerm")
	public void setInitTerm(String initTerm) {
		this.initTerm = initTerm;
	}

	@JsonProperty("isBumpEnabled")
	public Boolean getIsBumpEnabled() {
		return isBumpEnabled;
	}

	@JsonProperty("isBumpEnabled")
	public void setIsBumpEnabled(Boolean isBumpEnabled) {
		this.isBumpEnabled = isBumpEnabled;
	}

	@JsonProperty("maturityDtm")
	public String getMaturityDtm() {
		return maturityDtm;
	}

	@JsonProperty("maturityDtm")
	public void setMaturityDtm(String maturityDtm) {
		this.maturityDtm = maturityDtm;
	}

	@JsonProperty("maturityOpt")
	public Integer getMaturityOpt() {
		return maturityOpt;
	}

	@JsonProperty("maturityOpt")
	public void setMaturityOpt(Integer maturityOpt) {
		this.maturityOpt = maturityOpt;
	}

	@JsonProperty("notice")
	public String getNotice() {
		return notice;
	}

	@JsonProperty("notice")
	public void setNotice(String notice) {
		this.notice = notice;
	}

	@JsonProperty("noticeDtm")
	public String getNoticeDtm() {
		return noticeDtm;
	}

	@JsonProperty("noticeDtm")
	public void setNoticeDtm(String noticeDtm) {
		this.noticeDtm = noticeDtm;
	}

	@JsonProperty("penMatrix")
	public String getPenMatrix() {
		return penMatrix;
	}

	@JsonProperty("penMatrix")
	public void setPenMatrix(String penMatrix) {
		this.penMatrix = penMatrix;
	}

	@JsonProperty("penTrnCode")
	public String getPenTrnCode() {
		return penTrnCode;
	}

	@JsonProperty("penTrnCode")
	public void setPenTrnCode(String penTrnCode) {
		this.penTrnCode = penTrnCode;
	}

	@JsonProperty("rollCnt")
	public Integer getRollCnt() {
		return rollCnt;
	}

	@JsonProperty("rollCnt")
	public void setRollCnt(Integer rollCnt) {
		this.rollCnt = rollCnt;
	}

	@JsonProperty("rollCrGrace")
	public String getRollCrGrace() {
		return rollCrGrace;
	}

	@JsonProperty("rollCrGrace")
	public void setRollCrGrace(String rollCrGrace) {
		this.rollCrGrace = rollCrGrace;
	}

	@JsonProperty("rollDrGrace")
	public String getRollDrGrace() {
		return rollDrGrace;
	}

	@JsonProperty("rollDrGrace")
	public void setRollDrGrace(String rollDrGrace) {
		this.rollDrGrace = rollDrGrace;
	}

	@JsonProperty("rollDrGraceAdj")
	public Integer getRollDrGraceAdj() {
		return rollDrGraceAdj;
	}

	@JsonProperty("rollDrGraceAdj")
	public void setRollDrGraceAdj(Integer rollDrGraceAdj) {
		this.rollDrGraceAdj = rollDrGraceAdj;
	}

	@JsonProperty("rollProd")
	public String getRollProd() {
		return rollProd;
	}

	@JsonProperty("rollProd")
	public void setRollProd(String rollProd) {
		this.rollProd = rollProd;
	}

	@JsonProperty("term")
	public String getTerm() {
		return term;
	}

	@JsonProperty("term")
	public void setTerm(String term) {
		this.term = term;
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