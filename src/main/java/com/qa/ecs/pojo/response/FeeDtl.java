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
@JsonPropertyOrder({ "MonthlyFee", "late_charge" })
public class FeeDtl {

	@JsonProperty("MonthlyFee")
	private MonthlyFee monthlyFee;
	@JsonProperty("late_charge")
	private LateCharge lateCharge;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("MonthlyFee")
	public MonthlyFee getMonthlyFee() {
		return monthlyFee;
	}

	@JsonProperty("MonthlyFee")
	public void setMonthlyFee(MonthlyFee monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	@JsonProperty("late_charge")
	public LateCharge getLateCharge() {
		return lateCharge;
	}

	@JsonProperty("late_charge")
	public void setLateCharge(LateCharge lateCharge) {
		this.lateCharge = lateCharge;
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