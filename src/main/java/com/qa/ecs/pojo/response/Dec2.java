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
@JsonPropertyOrder({ "avlInt", "chrgOffBal", "depFee", "negBal", "penalty", "recurInc", "reviewableBal", "trnReward",
		"wthFed", "wthNra", "wthState", "deferCost", "deferFee", "lateChrg", "lnAutoRecv", "lnChrgOff", "lnChrgRecv",
		"lnFee", "lnFeeDeferred", "naAccrInt", "naLateChrg", "naLnFee", "pdToPrinAccrInt", "pdToPrinLateChrg",
		"pdToPrinLnFee", "receivableCost", "receivableFee", "sbaReceivable", "unappliedFunds"

})

public class Dec2 {

	@JsonProperty("avlInt")
	private Double avlInt;
	@JsonProperty("chrgOffBal")
	private Double chrgOffBal;
	@JsonProperty("depFee")
	private Double depFee;
	@JsonProperty("negBal")
	private Double negBal;
	@JsonProperty("penalty")
	private Double penalty;
	@JsonProperty("recurInc")
	private Double recurInc;
	@JsonProperty("reviewableBal")
	private Double reviewableBal;
	@JsonProperty("trnReward")
	private Double trnReward;
	@JsonProperty("wthFed")
	private Double wthFed;
	@JsonProperty("wthNra")
	private Double wthNra;
	@JsonProperty("wthState")
	private Double wthState;
	@JsonProperty("deferCost")
	private Double deferCost;
	@JsonProperty("deferFee")
	private Double deferFee;
	@JsonProperty("lateChrg")
	private Double lateChrg;
	@JsonProperty("lnAutoRecv")
	private Double lnAutoRecv;
	@JsonProperty("lnChrgOff")
	private Double lnChrgOff;
	@JsonProperty("lnChrgRecv")
	private Double lnChrgRecv;
	@JsonProperty("lnFee")
	private Double lnFee;
	@JsonProperty("lnFeeDeferred")
	private Double lnFeeDeferred;
	@JsonProperty("naAccrInt")
	private Double naAccrInt;
	@JsonProperty("naLateChrg")
	private Double naLateChrg;
	@JsonProperty("naLnFee")
	private Double naLnFee;
	@JsonProperty("pdToPrinAccrInt")
	private Double pdToPrinAccrInt;
	@JsonProperty("pdToPrinLateChrg")
	private Double pdToPrinLateChrg;
	@JsonProperty("pdToPrinLnFee")
	private Double pdToPrinLnFee;
	@JsonProperty("receivableCost")
	private Double receivableCost;
	@JsonProperty("receivableFee")
	private Double receivableFee;
	@JsonProperty("sbaReceivable")
	private Double sbaReceivable;
	@JsonProperty("unappliedFunds")
	private Double unappliedFunds;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("avlInt")
	public Double getAvlInt() {
		return avlInt;
	}

	@JsonProperty("avlInt")
	public void setAvlInt(Double avlInt) {
		this.avlInt = avlInt;
	}

	@JsonProperty("chrgOffBal")
	public Double getChrgOffBal() {
		return chrgOffBal;
	}

	@JsonProperty("chrgOffBal")
	public void setChrgOffBal(Double chrgOffBal) {
		this.chrgOffBal = chrgOffBal;
	}

	@JsonProperty("depFee")
	public Double getDepFee() {
		return depFee;
	}

	@JsonProperty("depFee")
	public void setDepFee(Double depFee) {
		this.depFee = depFee;
	}

	@JsonProperty("negBal")
	public Double getNegBal() {
		return negBal;
	}

	@JsonProperty("negBal")
	public void setNegBal(Double negBal) {
		this.negBal = negBal;
	}

	@JsonProperty("penalty")
	public Double getPenalty() {
		return penalty;
	}

	@JsonProperty("penalty")
	public void setPenalty(Double penalty) {
		this.penalty = penalty;
	}

	@JsonProperty("recurInc")
	public Double getRecurInc() {
		return recurInc;
	}

	@JsonProperty("recurInc")
	public void setRecurInc(Double recurInc) {
		this.recurInc = recurInc;
	}

	@JsonProperty("reviewableBal")
	public Double getReviewableBal() {
		return reviewableBal;
	}

	@JsonProperty("reviewableBal")
	public void setReviewableBal(Double reviewableBal) {
		this.reviewableBal = reviewableBal;
	}

	@JsonProperty("trnReward")
	public Double getTrnReward() {
		return trnReward;
	}

	@JsonProperty("trnReward")
	public void setTrnReward(Double trnReward) {
		this.trnReward = trnReward;
	}

	@JsonProperty("wthFed")
	public Double getWthFed() {
		return wthFed;
	}

	@JsonProperty("wthFed")
	public void setWthFed(Double wthFed) {
		this.wthFed = wthFed;
	}

	@JsonProperty("wthNra")
	public Double getWthNra() {
		return wthNra;
	}

	@JsonProperty("wthNra")
	public void setWthNra(Double wthNra) {
		this.wthNra = wthNra;
	}

	@JsonProperty("wthState")
	public Double getWthState() {
		return wthState;
	}

	@JsonProperty("wthState")
	public void setWthState(Double wthState) {
		this.wthState = wthState;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonProperty("deferCost")
	public Double getDeferCost() {
		return deferCost;
	}

	@JsonProperty("deferCost")
	public void setDeferCost(Double deferCost) {
		this.deferCost = deferCost;
	}

	@JsonProperty("deferFee")
	public Double getDeferFee() {
		return deferFee;
	}

	@JsonProperty("deferFee")
	public void setDeferFee(Double deferFee) {
		this.deferFee = deferFee;
	}

	@JsonProperty("lateChrg")
	public Double getLateChrg() {
		return lateChrg;
	}

	@JsonProperty("lateChrg")
	public void setLateChrg(Double lateChrg) {
		this.lateChrg = lateChrg;
	}

	@JsonProperty("lnAutoRecv")
	public Double getLnAutoRecv() {
		return lnAutoRecv;
	}

	@JsonProperty("lnAutoRecv")
	public void setLnAutoRecv(Double lnAutoRecv) {
		this.lnAutoRecv = lnAutoRecv;
	}

	@JsonProperty("lnChrgOff")
	public Double getLnChrgOff() {
		return lnChrgOff;
	}

	@JsonProperty("lnChrgOff")
	public void setLnChrgOff(Double lnChrgOff) {
		this.lnChrgOff = lnChrgOff;
	}

	@JsonProperty("lnChrgRecv")
	public Double getLnChrgRecv() {
		return lnChrgRecv;
	}

	@JsonProperty("lnChrgRecv")
	public void setLnChrgRecv(Double lnChrgRecv) {
		this.lnChrgRecv = lnChrgRecv;
	}

	@JsonProperty("lnFee")
	public Double getLnFee() {
		return lnFee;
	}

	@JsonProperty("lnFee")
	public void setLnFee(Double lnFee) {
		this.lnFee = lnFee;
	}

	@JsonProperty("lnFeeDeferred")
	public Double getLnFeeDeferred() {
		return lnFeeDeferred;
	}

	@JsonProperty("lnFeeDeferred")
	public void setLnFeeDeferred(Double lnFeeDeferred) {
		this.lnFeeDeferred = lnFeeDeferred;
	}

	@JsonProperty("naAccrInt")
	public Double getNaAccrInt() {
		return naAccrInt;
	}

	@JsonProperty("naAccrInt")
	public void setNaAccrInt(Double naAccrInt) {
		this.naAccrInt = naAccrInt;
	}

	@JsonProperty("naLateChrg")
	public Double getNaLateChrg() {
		return naLateChrg;
	}

	@JsonProperty("naLateChrg")
	public void setNaLateChrg(Double naLateChrg) {
		this.naLateChrg = naLateChrg;
	}

	@JsonProperty("naLnFee")
	public Double getNaLnFee() {
		return naLnFee;
	}

	@JsonProperty("naLnFee")
	public void setNaLnFee(Double naLnFee) {
		this.naLnFee = naLnFee;
	}

	@JsonProperty("pdToPrinAccrInt")
	public Double getPdToPrinAccrInt() {
		return pdToPrinAccrInt;
	}

	@JsonProperty("pdToPrinAccrInt")
	public void setPdToPrinAccrInt(Double pdToPrinAccrInt) {
		this.pdToPrinAccrInt = pdToPrinAccrInt;
	}

	@JsonProperty("pdToPrinLateChrg")
	public Double getPdToPrinLateChrg() {
		return pdToPrinLateChrg;
	}

	@JsonProperty("pdToPrinLateChrg")
	public void setPdToPrinLateChrg(Double pdToPrinLateChrg) {
		this.pdToPrinLateChrg = pdToPrinLateChrg;
	}

	@JsonProperty("pdToPrinLnFee")
	public Double getPdToPrinLnFee() {
		return pdToPrinLnFee;
	}

	@JsonProperty("pdToPrinLnFee")
	public void setPdToPrinLnFee(Double pdToPrinLnFee) {
		this.pdToPrinLnFee = pdToPrinLnFee;
	}

	@JsonProperty("receivableCost")
	public Double getReceivableCost() {
		return receivableCost;
	}

	@JsonProperty("receivableCost")
	public void setReceivableCost(Double receivableCost) {
		this.receivableCost = receivableCost;
	}

	@JsonProperty("receivableFee")
	public Double getReceivableFee() {
		return receivableFee;
	}

	@JsonProperty("receivableFee")
	public void setReceivableFee(Double receivableFee) {
		this.receivableFee = receivableFee;
	}

	@JsonProperty("sbaReceivable")
	public Double getSbaReceivable() {
		return sbaReceivable;
	}

	@JsonProperty("sbaReceivable")
	public void setSbaReceivable(Double sbaReceivable) {
		this.sbaReceivable = sbaReceivable;
	}

	@JsonProperty("unappliedFunds")
	public Double getUnappliedFunds() {
		return unappliedFunds;
	}

	@JsonProperty("unappliedFunds")
	public void setUnappliedFunds(Double unappliedFunds) {
		this.unappliedFunds = unappliedFunds;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
