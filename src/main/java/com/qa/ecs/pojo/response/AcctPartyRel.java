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
@JsonPropertyOrder({ "acctGroup", "acctNbr", "custId", "depRightCapacity", "groupId", "hasAccessRights", "isAuthSigner",
		"isBillSuppressed", "isStmtSuppressed", "isTaxOwner", "partyAcctName", "partyId", "partyPct", "relType",
		"_uLog", "_cDtm", "_uDtm", "_vn", "_flags", "_schVn", "_cLogRef", "_cLog" })

public class AcctPartyRel {

	@JsonProperty("acctGroup")
	private Integer acctGroup;
	@JsonProperty("acctNbr")
	private String acctNbr;
	@JsonProperty("custId")
	private String custId;
	@JsonProperty("depRightCapacity")
	private String depRightCapacity;
	@JsonProperty("groupId")
	private String groupId;
	@JsonProperty("hasAccessRights")
	private Boolean hasAccessRights;
	@JsonProperty("isAuthSigner")
	private Boolean isAuthSigner;
	@JsonProperty("isBillSuppressed")
	private Boolean isBillSuppressed;
	@JsonProperty("isStmtSuppressed")
	private Boolean isStmtSuppressed;
	@JsonProperty("isTaxOwner")
	private Boolean isTaxOwner;
	@JsonProperty("partyAcctName")
	private String partyAcctName;
	@JsonProperty("partyId")
	private String partyId;
	@JsonProperty("partyPct")
	private Double partyPct;
	@JsonProperty("relType")
	private String relType;
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

	@JsonProperty("hasAccessRights")
	public Boolean getHasAccessRights() {
		return hasAccessRights;
	}

	@JsonProperty("hasAccessRights")
	public void setHasAccessRights(Boolean hasAccessRights) {
		this.hasAccessRights = hasAccessRights;
	}

	@JsonProperty("isAuthSigner")
	public Boolean getIsAuthSigner() {
		return isAuthSigner;
	}

	@JsonProperty("isAuthSigner")
	public void setIsAuthSigner(Boolean isAuthSigner) {
		this.isAuthSigner = isAuthSigner;
	}

	@JsonProperty("isBillSuppressed")
	public Boolean getIsBillSuppressed() {
		return isBillSuppressed;
	}

	@JsonProperty("isBillSuppressed")
	public void setIsBillSuppressed(Boolean isBillSuppressed) {
		this.isBillSuppressed = isBillSuppressed;
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

	@JsonProperty("partyAcctName")
	public String getPartyAcctName() {
		return partyAcctName;
	}

	@JsonProperty("partyAcctName")
	public void setPartyAcctName(String partyAcctName) {
		this.partyAcctName = partyAcctName;
	}

	@JsonProperty("partyId")
	public String getPartyId() {
		return partyId;
	}

	@JsonProperty("partyId")
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	@JsonProperty("partyPct")
	public Double getPartyPct() {
		return partyPct;
	}

	@JsonProperty("partyPct")
	public void setPartyPct(Double partyPct) {
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