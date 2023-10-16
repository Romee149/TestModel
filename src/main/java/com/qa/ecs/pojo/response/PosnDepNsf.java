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
@JsonPropertyOrder({ "_Id", "componentName", "isAutoAuth", "isNegLimitOptIn", "isOptIn", "negLimit", "negLimitFreq",
		"negLimitMatrix", "negLimitStartOpt", "nextNegLimitChkDtm", "nsfAmt", "nsfCnt", "nsfFeeAmt", "nsfFeeCnt",
		"returnAmt", "returnCnt", "returnFeeAmt", "returnFeeCnt", "trnCodeExcl", "trnCodeIncl", "version", "_uLog",
		"_cDtm", "_uDtm", "_vn", "_flags", "_schVn", "_cLogRef", "_cLog" })

public class PosnDepNsf {

	@JsonProperty("_Id")
	private String id;
	@JsonProperty("componentName")
	private String componentName;
	@JsonProperty("isAutoAuth")
	private Boolean isAutoAuth;
	@JsonProperty("isNegLimitOptIn")
	private Boolean isNegLimitOptIn;
	@JsonProperty("isOptIn")
	private Boolean isOptIn;
	@JsonProperty("negLimit")
	private Double negLimit;
	@JsonProperty("negLimitFreq")
	private String negLimitFreq;
	@JsonProperty("negLimitMatrix")
	private String negLimitMatrix;
	@JsonProperty("negLimitStartOpt")
	private Integer negLimitStartOpt;
	@JsonProperty("nextNegLimitChkDtm")
	private String nextNegLimitChkDtm;
	@JsonProperty("nsfAmt")
	private Double nsfAmt;
	@JsonProperty("nsfCnt")
	private Integer nsfCnt;
	@JsonProperty("nsfFeeAmt")
	private Double nsfFeeAmt;
	@JsonProperty("nsfFeeCnt")
	private Integer nsfFeeCnt;
	@JsonProperty("returnAmt")
	private Double returnAmt;
	@JsonProperty("returnCnt")
	private Integer returnCnt;
	@JsonProperty("returnFeeAmt")
	private Double returnFeeAmt;
	@JsonProperty("returnFeeCnt")
	private Integer returnFeeCnt;
	@JsonProperty("trnCodeExcl")
	private List<Object> trnCodeExcl;
	@JsonProperty("trnCodeIncl")
	private List<Object> trnCodeIncl;
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

	@JsonProperty("isAutoAuth")
	public Boolean getIsAutoAuth() {
		return isAutoAuth;
	}

	@JsonProperty("isAutoAuth")
	public void setIsAutoAuth(Boolean isAutoAuth) {
		this.isAutoAuth = isAutoAuth;
	}

	@JsonProperty("isNegLimitOptIn")
	public Boolean getIsNegLimitOptIn() {
		return isNegLimitOptIn;
	}

	@JsonProperty("isNegLimitOptIn")
	public void setIsNegLimitOptIn(Boolean isNegLimitOptIn) {
		this.isNegLimitOptIn = isNegLimitOptIn;
	}

	@JsonProperty("isOptIn")
	public Boolean getIsOptIn() {
		return isOptIn;
	}

	@JsonProperty("isOptIn")
	public void setIsOptIn(Boolean isOptIn) {
		this.isOptIn = isOptIn;
	}

	@JsonProperty("negLimit")
	public Double getNegLimit() {
		return negLimit;
	}

	@JsonProperty("negLimit")
	public void setNegLimit(Double negLimit) {
		this.negLimit = negLimit;
	}

	@JsonProperty("negLimitFreq")
	public String getNegLimitFreq() {
		return negLimitFreq;
	}

	@JsonProperty("negLimitFreq")
	public void setNegLimitFreq(String negLimitFreq) {
		this.negLimitFreq = negLimitFreq;
	}

	@JsonProperty("negLimitMatrix")
	public String getNegLimitMatrix() {
		return negLimitMatrix;
	}

	@JsonProperty("negLimitMatrix")
	public void setNegLimitMatrix(String negLimitMatrix) {
		this.negLimitMatrix = negLimitMatrix;
	}

	@JsonProperty("negLimitStartOpt")
	public Integer getNegLimitStartOpt() {
		return negLimitStartOpt;
	}

	@JsonProperty("negLimitStartOpt")
	public void setNegLimitStartOpt(Integer negLimitStartOpt) {
		this.negLimitStartOpt = negLimitStartOpt;
	}

	@JsonProperty("nextNegLimitChkDtm")
	public String getNextNegLimitChkDtm() {
		return nextNegLimitChkDtm;
	}

	@JsonProperty("nextNegLimitChkDtm")
	public void setNextNegLimitChkDtm(String nextNegLimitChkDtm) {
		this.nextNegLimitChkDtm = nextNegLimitChkDtm;
	}

	@JsonProperty("nsfAmt")
	public Double getNsfAmt() {
		return nsfAmt;
	}

	@JsonProperty("nsfAmt")
	public void setNsfAmt(Double nsfAmt) {
		this.nsfAmt = nsfAmt;
	}

	@JsonProperty("nsfCnt")
	public Integer getNsfCnt() {
		return nsfCnt;
	}

	@JsonProperty("nsfCnt")
	public void setNsfCnt(Integer nsfCnt) {
		this.nsfCnt = nsfCnt;
	}

	@JsonProperty("nsfFeeAmt")
	public Double getNsfFeeAmt() {
		return nsfFeeAmt;
	}

	@JsonProperty("nsfFeeAmt")
	public void setNsfFeeAmt(Double nsfFeeAmt) {
		this.nsfFeeAmt = nsfFeeAmt;
	}

	@JsonProperty("nsfFeeCnt")
	public Integer getNsfFeeCnt() {
		return nsfFeeCnt;
	}

	@JsonProperty("nsfFeeCnt")
	public void setNsfFeeCnt(Integer nsfFeeCnt) {
		this.nsfFeeCnt = nsfFeeCnt;
	}

	@JsonProperty("returnAmt")
	public Double getReturnAmt() {
		return returnAmt;
	}

	@JsonProperty("returnAmt")
	public void setReturnAmt(Double returnAmt) {
		this.returnAmt = returnAmt;
	}

	@JsonProperty("returnCnt")
	public Integer getReturnCnt() {
		return returnCnt;
	}

	@JsonProperty("returnCnt")
	public void setReturnCnt(Integer returnCnt) {
		this.returnCnt = returnCnt;
	}

	@JsonProperty("returnFeeAmt")
	public Double getReturnFeeAmt() {
		return returnFeeAmt;
	}

	@JsonProperty("returnFeeAmt")
	public void setReturnFeeAmt(Double returnFeeAmt) {
		this.returnFeeAmt = returnFeeAmt;
	}

	@JsonProperty("returnFeeCnt")
	public Integer getReturnFeeCnt() {
		return returnFeeCnt;
	}

	@JsonProperty("returnFeeCnt")
	public void setReturnFeeCnt(Integer returnFeeCnt) {
		this.returnFeeCnt = returnFeeCnt;
	}

	@JsonProperty("trnCodeExcl")
	public List<Object> getTrnCodeExcl() {
		return trnCodeExcl;
	}

	@JsonProperty("trnCodeExcl")
	public void setTrnCodeExcl(List<Object> trnCodeExcl) {
		this.trnCodeExcl = trnCodeExcl;
	}

	@JsonProperty("trnCodeIncl")
	public List<Object> getTrnCodeIncl() {
		return trnCodeIncl;
	}

	@JsonProperty("trnCodeIncl")
	public void setTrnCodeIncl(List<Object> trnCodeIncl) {
		this.trnCodeIncl = trnCodeIncl;
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