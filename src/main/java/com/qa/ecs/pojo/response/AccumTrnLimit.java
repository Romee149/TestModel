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
@JsonPropertyOrder({ "_Id", "definedBy", "drCnt", "name", "statGroup", "violationAct", "_cDtm", "_vn", "_schVn",
		"_cLog", "crAmt" })

public class AccumTrnLimit {

	@JsonProperty("_Id")
	private String id;
	@JsonProperty("definedBy")
	private Integer definedBy;
	@JsonProperty("drCnt")
	private Integer drCnt;
	@JsonProperty("name")
	private String name;
	@JsonProperty("statGroup")
	private String statGroup;
	@JsonProperty("violationAct")
	private Integer violationAct;
	@JsonProperty("_cDtm")
	private String cDtm;
	@JsonProperty("_vn")
	private Integer vn;
	@JsonProperty("_schVn")
	private Integer schVn;
	@JsonProperty("_cLog")
	private String cLog;
	@JsonProperty("crAmt")
	private Double crAmt;
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

	@JsonProperty("definedBy")
	public Integer getDefinedBy() {
		return definedBy;
	}

	@JsonProperty("definedBy")
	public void setDefinedBy(Integer definedBy) {
		this.definedBy = definedBy;
	}

	@JsonProperty("drCnt")
	public Integer getDrCnt() {
		return drCnt;
	}

	@JsonProperty("drCnt")
	public void setDrCnt(Integer drCnt) {
		this.drCnt = drCnt;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("statGroup")
	public String getStatGroup() {
		return statGroup;
	}

	@JsonProperty("statGroup")
	public void setStatGroup(String statGroup) {
		this.statGroup = statGroup;
	}

	@JsonProperty("violationAct")
	public Integer getViolationAct() {
		return violationAct;
	}

	@JsonProperty("violationAct")
	public void setViolationAct(Integer violationAct) {
		this.violationAct = violationAct;
	}

	@JsonProperty("_cDtm")
	public String getCDtm() {
		return cDtm;
	}

	@JsonProperty("_cDtm")
	public void setCDtm(String cDtm) {
		this.cDtm = cDtm;
	}

	@JsonProperty("_vn")
	public Integer getVn() {
		return vn;
	}

	@JsonProperty("_vn")
	public void setVn(Integer vn) {
		this.vn = vn;
	}

	@JsonProperty("_schVn")
	public Integer getSchVn() {
		return schVn;
	}

	@JsonProperty("_schVn")
	public void setSchVn(Integer schVn) {
		this.schVn = schVn;
	}

	@JsonProperty("_cLog")
	public String getCLog() {
		return cLog;
	}

	@JsonProperty("_cLog")
	public void setCLog(String cLog) {
		this.cLog = cLog;
	}

	@JsonProperty("crAmt")
	public Double getCrAmt() {
		return crAmt;
	}

	@JsonProperty("crAmt")
	public void setCrAmt(Double crAmt) {
		this.crAmt = crAmt;
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