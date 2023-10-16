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
@JsonPropertyOrder({ "trnId", "posnId", "acctGroup", "acctNbr", "afterAuthAvailBal", "afterAvailBal", "afterLedgerBal",
		"afterReviewableBal", "batchId", "beforeAuthAvailBal", "beforeAvailBal", "beforeLedgerBal",
		"beforeReviewableBal", "createDtm", "glJrnlDate", "mode", "posnAcctNbr",

		"afterCollectedBal", "beforeCollectedBal",

})

public class Datum {

	@JsonProperty("trnId")
	private String trnId;
	@JsonProperty("posnId")
	private String posnId;
	@JsonProperty("acctGroup")
	private Integer acctGroup;
	@JsonProperty("acctNbr")
	private String acctNbr;
	@JsonProperty("afterAuthAvailBal")
	private Double afterAuthAvailBal;
	@JsonProperty("afterAvailBal")
	private Double afterAvailBal;
	@JsonProperty("afterLedgerBal")
	private Double afterLedgerBal;
	@JsonProperty("afterReviewableBal")
	private Double afterReviewableBal;
	@JsonProperty("batchId")
	private String batchId;
	@JsonProperty("beforeAuthAvailBal")
	private Double beforeAuthAvailBal;
	@JsonProperty("beforeAvailBal")
	private Double beforeAvailBal;
	@JsonProperty("beforeLedgerBal")
	private Double beforeLedgerBal;
	@JsonProperty("beforeReviewableBal")
	private Double beforeReviewableBal;
	@JsonProperty("createDtm")
	private String createDtm;
	@JsonProperty("glJrnlDate")
	private String glJrnlDate;
	@JsonProperty("mode")
	private Integer mode;
	@JsonProperty("posnAcctNbr")
	private String posnAcctNbr;
	@JsonProperty("afterCollectedBal")
	private Double afterCollectedBal;
	@JsonProperty("beforeCollectedBal")
	private Double beforeCollectedBal;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("trnId")
	public String getTrnId() {
		return trnId;
	}

	@JsonProperty("trnId")
	public void setTrnId(String trnId) {
		this.trnId = trnId;
	}

	@JsonProperty("posnId")
	public String getPosnId() {
		return posnId;
	}

	@JsonProperty("posnId")
	public void setPosnId(String posnId) {
		this.posnId = posnId;
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

	@JsonProperty("afterAuthAvailBal")
	public Double getAfterAuthAvailBal() {
		return afterAuthAvailBal;
	}

	@JsonProperty("afterAuthAvailBal")
	public void setAfterAuthAvailBal(Double afterAuthAvailBal) {
		this.afterAuthAvailBal = afterAuthAvailBal;
	}

	@JsonProperty("afterAvailBal")
	public Double getAfterAvailBal() {
		return afterAvailBal;
	}

	@JsonProperty("afterAvailBal")
	public void setAfterAvailBal(Double afterAvailBal) {
		this.afterAvailBal = afterAvailBal;
	}

	@JsonProperty("afterLedgerBal")
	public Double getAfterLedgerBal() {
		return afterLedgerBal;
	}

	@JsonProperty("afterLedgerBal")
	public void setAfterLedgerBal(Double afterLedgerBal) {
		this.afterLedgerBal = afterLedgerBal;
	}

	@JsonProperty("afterReviewableBal")
	public Double getAfterReviewableBal() {
		return afterReviewableBal;
	}

	@JsonProperty("afterReviewableBal")
	public void setAfterReviewableBal(Double afterReviewableBal) {
		this.afterReviewableBal = afterReviewableBal;
	}

	@JsonProperty("batchId")
	public String getBatchId() {
		return batchId;
	}

	@JsonProperty("batchId")
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	@JsonProperty("beforeAuthAvailBal")
	public Double getBeforeAuthAvailBal() {
		return beforeAuthAvailBal;
	}

	@JsonProperty("beforeAuthAvailBal")
	public void setBeforeAuthAvailBal(Double beforeAuthAvailBal) {
		this.beforeAuthAvailBal = beforeAuthAvailBal;
	}

	@JsonProperty("beforeAvailBal")
	public Double getBeforeAvailBal() {
		return beforeAvailBal;
	}

	@JsonProperty("beforeAvailBal")
	public void setBeforeAvailBal(Double beforeAvailBal) {
		this.beforeAvailBal = beforeAvailBal;
	}

	@JsonProperty("beforeLedgerBal")
	public Double getBeforeLedgerBal() {
		return beforeLedgerBal;
	}

	@JsonProperty("beforeLedgerBal")
	public void setBeforeLedgerBal(Double beforeLedgerBal) {
		this.beforeLedgerBal = beforeLedgerBal;
	}

	@JsonProperty("beforeReviewableBal")
	public Double getBeforeReviewableBal() {
		return beforeReviewableBal;
	}

	@JsonProperty("beforeReviewableBal")
	public void setBeforeReviewableBal(Double beforeReviewableBal) {
		this.beforeReviewableBal = beforeReviewableBal;
	}

	@JsonProperty("createDtm")
	public String getCreateDtm() {
		return createDtm;
	}

	@JsonProperty("createDtm")
	public void setCreateDtm(String createDtm) {
		this.createDtm = createDtm;
	}

	@JsonProperty("glJrnlDate")
	public String getGlJrnlDate() {
		return glJrnlDate;
	}

	@JsonProperty("glJrnlDate")
	public void setGlJrnlDate(String glJrnlDate) {
		this.glJrnlDate = glJrnlDate;
	}

	@JsonProperty("mode")
	public Integer getMode() {
		return mode;
	}

	@JsonProperty("mode")
	public void setMode(Integer mode) {
		this.mode = mode;
	}

	@JsonProperty("posnAcctNbr")
	public String getPosnAcctNbr() {
		return posnAcctNbr;
	}

	@JsonProperty("posnAcctNbr")
	public void setPosnAcctNbr(String posnAcctNbr) {
		this.posnAcctNbr = posnAcctNbr;
	}

	@JsonProperty("afterCollectedBal")
	public Double getAfterCollectedBal() {
		return afterCollectedBal;
	}

	@JsonProperty("afterCollectedBal")
	public void setAfterCollectedBal(Double afterCollectedBal) {
		this.afterCollectedBal = afterCollectedBal;
	}

	@JsonProperty("beforeCollectedBal")
	public Double getBeforeCollectedBal() {
		return beforeCollectedBal;
	}

	@JsonProperty("beforeCollectedBal")
	public void setBeforeCollectedBal(Double beforeCollectedBal) {
		this.beforeCollectedBal = beforeCollectedBal;
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