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
@JsonPropertyOrder({ "_schVn", "_vn", "partyAcctName", "partyPct", "relType", "hasAccessRights", "custId",
		"depRightCapacity", "groupId", "isStmtSuppressed", "isTaxOwner", "partyId", "isBillSuppressed",
		"isAuthSigner" })

public class AcctPartyRel {

	@JsonProperty("_schVn")
	private Integer schVn;
	@JsonProperty("_vn")
	private Integer vn;
	@JsonProperty("partyAcctName")
	private String partyAcctName;
	@JsonProperty("partyPct")
	private Integer partyPct;
	@JsonProperty("relType")
	private String relType;
	@JsonProperty("hasAccessRights")
	private Boolean hasAccessRights;
	@JsonProperty("custId")
	private String custId;
	@JsonProperty("depRightCapacity")
	private String depRightCapacity;
	@JsonProperty("groupId")
	private String groupId;
	@JsonProperty("isStmtSuppressed")
	private Boolean isStmtSuppressed;
	@JsonProperty("isTaxOwner")
	private Boolean isTaxOwner;
	@JsonProperty("partyId")
	private String partyId;
	@JsonProperty("isBillSuppressed")
	private Boolean isBillSuppressed;
	@JsonProperty("isAuthSigner")
	private Boolean isAuthSigner;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("_schVn")
	public Integer getSchVn() {
		return schVn;
	}

	@JsonProperty("_schVn")
	public void setSchVn(Integer schVn) {
		this.schVn = schVn;
	}

	@JsonProperty("_vn")
	public Integer getVn() {
		return vn;
	}

	@JsonProperty("_vn")
	public void setVn(Integer vn) {
		this.vn = vn;
	}

	@JsonProperty("partyAcctName")
	public String getPartyAcctName() {
		return partyAcctName;
	}

	@JsonProperty("partyAcctName")
	public void setPartyAcctName(String partyAcctName) {
		this.partyAcctName = partyAcctName;
	}

	@JsonProperty("partyPct")
	public Integer getPartyPct() {
		return partyPct;
	}

	@JsonProperty("partyPct")
	public void setPartyPct(Integer partyPct) {
		this.partyPct = partyPct;
	}

	@JsonProperty("relType")
	public String getRelType() {
		return relType;
	}

	@JsonProperty("relType")
	public void setRelType(String relType) {
		this.relType = relType;
	}

	@JsonProperty("hasAccessRights")
	public Boolean getHasAccessRights() {
		return hasAccessRights;
	}

	@JsonProperty("hasAccessRights")
	public void setHasAccessRights(Boolean hasAccessRights) {
		this.hasAccessRights = hasAccessRights;
	}

	@JsonProperty("custId")
	public String getCustId() {
		return custId;
	}

	@JsonProperty("custId")
	public void setCustId(String custId) {
		this.custId = custId;
	}

	@JsonProperty("depRightCapacity")
	public String getDepRightCapacity() {
		return depRightCapacity;
	}

	@JsonProperty("depRightCapacity")
	public void setDepRightCapacity(String depRightCapacity) {
		this.depRightCapacity = depRightCapacity;
	}

	@JsonProperty("groupId")
	public String getGroupId() {
		return groupId;
	}

	@JsonProperty("groupId")
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	@JsonProperty("isStmtSuppressed")
	public Boolean getIsStmtSuppressed() {
		return isStmtSuppressed;
	}

	@JsonProperty("isStmtSuppressed")
	public void setIsStmtSuppressed(Boolean isStmtSuppressed) {
		this.isStmtSuppressed = isStmtSuppressed;
	}

	@JsonProperty("isTaxOwner")
	public Boolean getIsTaxOwner() {
		return isTaxOwner;
	}

	@JsonProperty("isTaxOwner")
	public void setIsTaxOwner(Boolean isTaxOwner) {
		this.isTaxOwner = isTaxOwner;
	}

	@JsonProperty("partyId")
	public String getPartyId() {
		return partyId;
	}

	@JsonProperty("partyId")
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	@JsonProperty("isBillSuppressed")
	public Boolean getIsBillSuppressed() {
		return isBillSuppressed;
	}

	@JsonProperty("isBillSuppressed")
	public void setIsBillSuppressed(Boolean isBillSuppressed) {
		this.isBillSuppressed = isBillSuppressed;
	}

	@JsonProperty("isAuthSigner")
	public Boolean getIsAuthSigner() {
		return isAuthSigner;
	}

	@JsonProperty("isAuthSigner")
	public void setIsAuthSigner(Boolean isAuthSigner) {
		this.isAuthSigner = isAuthSigner;
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