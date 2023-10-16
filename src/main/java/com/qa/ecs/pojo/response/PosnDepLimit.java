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
@JsonPropertyOrder({ "_Id", "accumTrnLimits", "componentName", "perTrnLimits", "restrictCr", "restrictCrFundExp",
		"restrictDr", "version", "_uLog", "_cDtm", "_uDtm", "_vn", "_flags", "_schVn", "_cLogRef", "_cLog",
		"minToOpen" })

public class PosnDepLimit {

	@JsonProperty("_Id")
	private String id;
	@JsonProperty("accumTrnLimits")
	private List<AccumTrnLimit> accumTrnLimits;
	@JsonProperty("componentName")
	private String componentName;
	@JsonProperty("perTrnLimits")
	private List<PerTrnLimit> perTrnLimits;
	@JsonProperty("restrictCr")
	private Boolean restrictCr;
	@JsonProperty("restrictCrFundExp")
	private Boolean restrictCrFundExp;
	@JsonProperty("restrictDr")
	private Boolean restrictDr;
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
	@JsonProperty("minToOpen")
	private Double minToOpen;
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

	@JsonProperty("accumTrnLimits")
	public List<AccumTrnLimit> getAccumTrnLimits() {
		return accumTrnLimits;
	}

	@JsonProperty("accumTrnLimits")
	public void setAccumTrnLimits(List<AccumTrnLimit> accumTrnLimits) {
		this.accumTrnLimits = accumTrnLimits;
	}

	@JsonProperty("componentName")
	public String getComponentName() {
		return componentName;
	}

	@JsonProperty("componentName")
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	@JsonProperty("perTrnLimits")
	public List<PerTrnLimit> getPerTrnLimits() {
		return perTrnLimits;
	}

	@JsonProperty("perTrnLimits")
	public void setPerTrnLimits(List<PerTrnLimit> perTrnLimits) {
		this.perTrnLimits = perTrnLimits;
	}

	@JsonProperty("restrictCr")
	public Boolean getRestrictCr() {
		return restrictCr;
	}

	@JsonProperty("restrictCr")
	public void setRestrictCr(Boolean restrictCr) {
		this.restrictCr = restrictCr;
	}

	@JsonProperty("restrictCrFundExp")
	public Boolean getRestrictCrFundExp() {
		return restrictCrFundExp;
	}

	@JsonProperty("restrictCrFundExp")
	public void setRestrictCrFundExp(Boolean restrictCrFundExp) {
		this.restrictCrFundExp = restrictCrFundExp;
	}

	@JsonProperty("restrictDr")
	public Boolean getRestrictDr() {
		return restrictDr;
	}

	@JsonProperty("restrictDr")
	public void setRestrictDr(Boolean restrictDr) {
		this.restrictDr = restrictDr;
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

	@JsonProperty("minToOpen")
	public Double getMinToOpen() {
		return minToOpen;
	}

	@JsonProperty("minToOpen")
	public void setMinToOpen(Double minToOpen) {
		this.minToOpen = minToOpen;
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