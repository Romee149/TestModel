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
@JsonPropertyOrder({ "dfltChannels", "groupId", "isNoSolicit", "memberId", "partyId", "smsOptInStatus" })

public class NotificationPreference {

	@JsonProperty("dfltChannels")
	private List<DfltChannel> dfltChannels;
	@JsonProperty("groupId")
	private String groupId;
	@JsonProperty("isNoSolicit")
	private Boolean isNoSolicit;
	@JsonProperty("memberId")
	private String memberId;
	@JsonProperty("partyId")
	private String partyId;
	@JsonProperty("smsOptInStatus")
	private Integer smsOptInStatus;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("dfltChannels")
	public List<DfltChannel> getDfltChannels() {
		return dfltChannels;
	}

	@JsonProperty("dfltChannels")
	public void setDfltChannels(List<DfltChannel> dfltChannels) {
		this.dfltChannels = dfltChannels;
	}

	@JsonProperty("groupId")
	public String getGroupId() {
		return groupId;
	}

	@JsonProperty("groupId")
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	@JsonProperty("isNoSolicit")
	public Boolean getIsNoSolicit() {
		return isNoSolicit;
	}

	@JsonProperty("isNoSolicit")
	public void setIsNoSolicit(Boolean isNoSolicit) {
		this.isNoSolicit = isNoSolicit;
	}

	@JsonProperty("memberId")
	public String getMemberId() {
		return memberId;
	}

	@JsonProperty("memberId")
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@JsonProperty("partyId")
	public String getPartyId() {
		return partyId;
	}

	@JsonProperty("partyId")
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	@JsonProperty("smsOptInStatus")
	public Integer getSmsOptInStatus() {
		return smsOptInStatus;
	}

	@JsonProperty("smsOptInStatus")
	public void setSmsOptInStatus(Integer smsOptInStatus) {
		this.smsOptInStatus = smsOptInStatus;
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
