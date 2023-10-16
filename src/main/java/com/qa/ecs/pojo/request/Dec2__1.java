package com.qa.ecs.pojo.request;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "accrInt", "avlInt", "fee", "ledger", "negAccr", "penalty", "wthFed", "wthState", "capInt",
		"depFee", "negBal", "chrgOffBal", "lateChrg", "lnFee", "deferFee", "deferCost", "receivableFee",
		"receivableCost", "recurInc", "wthNra", "deferCost2", "receivableCost2", "waiveInt" })

public class Dec2__1 {

	@JsonProperty("accrInt")
	private Integer accrInt;
	@JsonProperty("avlInt")
	private Integer avlInt;
	@JsonProperty("fee")
	private Integer fee;
	@JsonProperty("ledger")
	private Integer ledger;
	@JsonProperty("negAccr")
	private Integer negAccr;
	@JsonProperty("penalty")
	private Integer penalty;
	@JsonProperty("wthFed")
	private Integer wthFed;
	@JsonProperty("wthState")
	private Integer wthState;
	@JsonProperty("capInt")
	private Integer capInt;
	@JsonProperty("depFee")
	private Integer depFee;
	@JsonProperty("negBal")
	private Integer negBal;
	@JsonProperty("chrgOffBal")
	private Integer chrgOffBal;
	@JsonProperty("lateChrg")
	private Integer lateChrg;
	@JsonProperty("lnFee")
	private Integer lnFee;
	@JsonProperty("deferFee")
	private Integer deferFee;
	@JsonProperty("deferCost")
	private Integer deferCost;
	@JsonProperty("receivableFee")
	private Integer receivableFee;
	@JsonProperty("receivableCost")
	private Integer receivableCost;
	@JsonProperty("recurInc")
	private Integer recurInc;
	@JsonProperty("wthNra")
	private Integer wthNra;
	@JsonProperty("deferCost2")
	private Integer deferCost2;
	@JsonProperty("receivableCost2")
	private Integer receivableCost2;
	@JsonProperty("waiveInt")
	private Integer waiveInt;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("accrInt")
	public Integer getAccrInt() {
		return accrInt;
	}

	@JsonProperty("accrInt")
	public void setAccrInt(Integer accrInt) {
		this.accrInt = accrInt;
	}

	@JsonProperty("avlInt")
	public Integer getAvlInt() {
		return avlInt;
	}

	@JsonProperty("avlInt")
	public void setAvlInt(Integer avlInt) {
		this.avlInt = avlInt;
	}

	@JsonProperty("fee")
	public Integer getFee() {
		return fee;
	}

	@JsonProperty("fee")
	public void setFee(Integer fee) {
		this.fee = fee;
	}

	@JsonProperty("ledger")
	public Integer getLedger() {
		return ledger;
	}

	@JsonProperty("ledger")
	public void setLedger(Integer ledger) {
		this.ledger = ledger;
	}

	@JsonProperty("negAccr")
	public Integer getNegAccr() {
		return negAccr;
	}

	@JsonProperty("negAccr")
	public void setNegAccr(Integer negAccr) {
		this.negAccr = negAccr;
	}

	@JsonProperty("penalty")
	public Integer getPenalty() {
		return penalty;
	}

	@JsonProperty("penalty")
	public void setPenalty(Integer penalty) {
		this.penalty = penalty;
	}

	@JsonProperty("wthFed")
	public Integer getWthFed() {
		return wthFed;
	}

	@JsonProperty("wthFed")
	public void setWthFed(Integer wthFed) {
		this.wthFed = wthFed;
	}

	@JsonProperty("wthState")
	public Integer getWthState() {
		return wthState;
	}

	@JsonProperty("wthState")
	public void setWthState(Integer wthState) {
		this.wthState = wthState;
	}

	@JsonProperty("capInt")
	public Integer getCapInt() {
		return capInt;
	}

	@JsonProperty("capInt")
	public void setCapInt(Integer capInt) {
		this.capInt = capInt;
	}

	@JsonProperty("depFee")
	public Integer getDepFee() {
		return depFee;
	}

	@JsonProperty("depFee")
	public void setDepFee(Integer depFee) {
		this.depFee = depFee;
	}

	@JsonProperty("negBal")
	public Integer getNegBal() {
		return negBal;
	}

	@JsonProperty("negBal")
	public void setNegBal(Integer negBal) {
		this.negBal = negBal;
	}

	@JsonProperty("chrgOffBal")
	public Integer getChrgOffBal() {
		return chrgOffBal;
	}

	@JsonProperty("chrgOffBal")
	public void setChrgOffBal(Integer chrgOffBal) {
		this.chrgOffBal = chrgOffBal;
	}

	@JsonProperty("lateChrg")
	public Integer getLateChrg() {
		return lateChrg;
	}

	@JsonProperty("lateChrg")
	public void setLateChrg(Integer lateChrg) {
		this.lateChrg = lateChrg;
	}

	@JsonProperty("lnFee")
	public Integer getLnFee() {
		return lnFee;
	}

	@JsonProperty("lnFee")
	public void setLnFee(Integer lnFee) {
		this.lnFee = lnFee;
	}

	@JsonProperty("deferFee")
	public Integer getDeferFee() {
		return deferFee;
	}

	@JsonProperty("deferFee")
	public void setDeferFee(Integer deferFee) {
		this.deferFee = deferFee;
	}

	@JsonProperty("deferCost")
	public Integer getDeferCost() {
		return deferCost;
	}

	@JsonProperty("deferCost")
	public void setDeferCost(Integer deferCost) {
		this.deferCost = deferCost;
	}

	@JsonProperty("receivableFee")
	public Integer getReceivableFee() {
		return receivableFee;
	}

	@JsonProperty("receivableFee")
	public void setReceivableFee(Integer receivableFee) {
		this.receivableFee = receivableFee;
	}

	@JsonProperty("receivableCost")
	public Integer getReceivableCost() {
		return receivableCost;
	}

	@JsonProperty("receivableCost")
	public void setReceivableCost(Integer receivableCost) {
		this.receivableCost = receivableCost;
	}

	@JsonProperty("recurInc")
	public Integer getRecurInc() {
		return recurInc;
	}

	@JsonProperty("recurInc")
	public void setRecurInc(Integer recurInc) {
		this.recurInc = recurInc;
	}

	@JsonProperty("wthNra")
	public Integer getWthNra() {
		return wthNra;
	}

	@JsonProperty("wthNra")
	public void setWthNra(Integer wthNra) {
		this.wthNra = wthNra;
	}

	@JsonProperty("deferCost2")
	public Integer getDeferCost2() {
		return deferCost2;
	}

	@JsonProperty("deferCost2")
	public void setDeferCost2(Integer deferCost2) {
		this.deferCost2 = deferCost2;
	}

	@JsonProperty("receivableCost2")
	public Integer getReceivableCost2() {
		return receivableCost2;
	}

	@JsonProperty("receivableCost2")
	public void setReceivableCost2(Integer receivableCost2) {
		this.receivableCost2 = receivableCost2;
	}

	@JsonProperty("waiveInt")
	public Integer getWaiveInt() {
		return waiveInt;
	}

	@JsonProperty("waiveInt")
	public void setWaiveInt(Integer waiveInt) {
		this.waiveInt = waiveInt;
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