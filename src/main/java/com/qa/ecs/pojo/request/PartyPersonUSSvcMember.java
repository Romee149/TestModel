package com.qa.ecs.pojo.request;

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
@JsonPropertyOrder({ "activeDutyDts", "payGrade", "rank", "status", "svcBranch" })

public class PartyPersonUSSvcMember {

	@JsonProperty("activeDutyDts")
	private List<ActiveDutyDt> activeDutyDts;
	@JsonProperty("payGrade")
	private Integer payGrade;
	@JsonProperty("rank")
	private Integer rank;
	@JsonProperty("status")
	private Integer status;
	@JsonProperty("svcBranch")
	private Integer svcBranch;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("activeDutyDts")
	public List<ActiveDutyDt> getActiveDutyDts() {
		return activeDutyDts;
	}

	@JsonProperty("activeDutyDts")
	public void setActiveDutyDts(List<ActiveDutyDt> activeDutyDts) {
		this.activeDutyDts = activeDutyDts;
	}

	@JsonProperty("payGrade")
	public Integer getPayGrade() {
		return payGrade;
	}

	@JsonProperty("payGrade")
	public void setPayGrade(Integer payGrade) {
		this.payGrade = payGrade;
	}

	@JsonProperty("rank")
	public Integer getRank() {
		return rank;
	}

	@JsonProperty("rank")
	public void setRank(Integer rank) {
		this.rank = rank;
	}

	@JsonProperty("status")
	public Integer getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(Integer status) {
		this.status = status;
	}

	@JsonProperty("svcBranch")
	public Integer getSvcBranch() {
		return svcBranch;
	}

	@JsonProperty("svcBranch")
	public void setSvcBranch(Integer svcBranch) {
		this.svcBranch = svcBranch;
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