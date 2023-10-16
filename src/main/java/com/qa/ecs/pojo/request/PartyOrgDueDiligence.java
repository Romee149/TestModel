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
@JsonPropertyOrder({ "_schVn", "_vn", "acceptRccPmt", "acctPurpose", "amtACHMo", "amtMobileDepMo", "amtRemoteDepMo",
		"amtWiresMo", "chkGrtrThsnd", "cntACHMo", "cntMobileDepMo", "cntRemoteDepMo", "cntWiresMo",
		"estmtdAnnualRevenue", "hdqtrsCntry", "industry", "internetGamblingInc", "intrmySvcs", "isAtmOper", "isCharity",
		"isMarijuanaBusiness", "isThirdPartyBenefit", "mnyOrderGrtrThsnd", "nbrLoc", "nonCashActivities", "operCntry",
		"pctRevenueMnySvcs", "structure", "tfrForCust", "virtualCcy", "yearsOwnBusiness" })

public class PartyOrgDueDiligence {

	@JsonProperty("_schVn")
	private Integer schVn;
	@JsonProperty("_vn")
	private Integer vn;
	@JsonProperty("acceptRccPmt")
	private Boolean acceptRccPmt;
	@JsonProperty("acctPurpose")
	private Integer acctPurpose;
	@JsonProperty("amtACHMo")
	private Integer amtACHMo;
	@JsonProperty("amtMobileDepMo")
	private Integer amtMobileDepMo;
	@JsonProperty("amtRemoteDepMo")
	private Integer amtRemoteDepMo;
	@JsonProperty("amtWiresMo")
	private Integer amtWiresMo;
	@JsonProperty("chkGrtrThsnd")
	private Boolean chkGrtrThsnd;
	@JsonProperty("cntACHMo")
	private Integer cntACHMo;
	@JsonProperty("cntMobileDepMo")
	private Integer cntMobileDepMo;
	@JsonProperty("cntRemoteDepMo")
	private Integer cntRemoteDepMo;
	@JsonProperty("cntWiresMo")
	private Integer cntWiresMo;
	@JsonProperty("estmtdAnnualRevenue")
	private Integer estmtdAnnualRevenue;
	@JsonProperty("hdqtrsCntry")
	private String hdqtrsCntry;
	@JsonProperty("industry")
	private Integer industry;
	@JsonProperty("internetGamblingInc")
	private Boolean internetGamblingInc;
	@JsonProperty("intrmySvcs")
	private List<Object> intrmySvcs;
	@JsonProperty("isAtmOper")
	private Boolean isAtmOper;
	@JsonProperty("isCharity")
	private Boolean isCharity;
	@JsonProperty("isMarijuanaBusiness")
	private Boolean isMarijuanaBusiness;
	@JsonProperty("isThirdPartyBenefit")
	private Boolean isThirdPartyBenefit;
	@JsonProperty("mnyOrderGrtrThsnd")
	private Boolean mnyOrderGrtrThsnd;
	@JsonProperty("nbrLoc")
	private Integer nbrLoc;
	@JsonProperty("nonCashActivities")
	private Boolean nonCashActivities;
	@JsonProperty("operCntry")
	private List<Object> operCntry;
	@JsonProperty("pctRevenueMnySvcs")
	private Integer pctRevenueMnySvcs;
	@JsonProperty("structure")
	private Integer structure;
	@JsonProperty("tfrForCust")
	private Boolean tfrForCust;
	@JsonProperty("virtualCcy")
	private Boolean virtualCcy;
	@JsonProperty("yearsOwnBusiness")
	private Integer yearsOwnBusiness;
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

	@JsonProperty("acceptRccPmt")
	public Boolean getAcceptRccPmt() {
		return acceptRccPmt;
	}

	@JsonProperty("acceptRccPmt")
	public void setAcceptRccPmt(Boolean acceptRccPmt) {
		this.acceptRccPmt = acceptRccPmt;
	}

	@JsonProperty("acctPurpose")
	public Integer getAcctPurpose() {
		return acctPurpose;
	}

	@JsonProperty("acctPurpose")
	public void setAcctPurpose(Integer acctPurpose) {
		this.acctPurpose = acctPurpose;
	}

	@JsonProperty("amtACHMo")
	public Integer getAmtACHMo() {
		return amtACHMo;
	}

	@JsonProperty("amtACHMo")
	public void setAmtACHMo(Integer amtACHMo) {
		this.amtACHMo = amtACHMo;
	}

	@JsonProperty("amtMobileDepMo")
	public Integer getAmtMobileDepMo() {
		return amtMobileDepMo;
	}

	@JsonProperty("amtMobileDepMo")
	public void setAmtMobileDepMo(Integer amtMobileDepMo) {
		this.amtMobileDepMo = amtMobileDepMo;
	}

	@JsonProperty("amtRemoteDepMo")
	public Integer getAmtRemoteDepMo() {
		return amtRemoteDepMo;
	}

	@JsonProperty("amtRemoteDepMo")
	public void setAmtRemoteDepMo(Integer amtRemoteDepMo) {
		this.amtRemoteDepMo = amtRemoteDepMo;
	}

	@JsonProperty("amtWiresMo")
	public Integer getAmtWiresMo() {
		return amtWiresMo;
	}

	@JsonProperty("amtWiresMo")
	public void setAmtWiresMo(Integer amtWiresMo) {
		this.amtWiresMo = amtWiresMo;
	}

	@JsonProperty("chkGrtrThsnd")
	public Boolean getChkGrtrThsnd() {
		return chkGrtrThsnd;
	}

	@JsonProperty("chkGrtrThsnd")
	public void setChkGrtrThsnd(Boolean chkGrtrThsnd) {
		this.chkGrtrThsnd = chkGrtrThsnd;
	}

	@JsonProperty("cntACHMo")
	public Integer getCntACHMo() {
		return cntACHMo;
	}

	@JsonProperty("cntACHMo")
	public void setCntACHMo(Integer cntACHMo) {
		this.cntACHMo = cntACHMo;
	}

	@JsonProperty("cntMobileDepMo")
	public Integer getCntMobileDepMo() {
		return cntMobileDepMo;
	}

	@JsonProperty("cntMobileDepMo")
	public void setCntMobileDepMo(Integer cntMobileDepMo) {
		this.cntMobileDepMo = cntMobileDepMo;
	}

	@JsonProperty("cntRemoteDepMo")
	public Integer getCntRemoteDepMo() {
		return cntRemoteDepMo;
	}

	@JsonProperty("cntRemoteDepMo")
	public void setCntRemoteDepMo(Integer cntRemoteDepMo) {
		this.cntRemoteDepMo = cntRemoteDepMo;
	}

	@JsonProperty("cntWiresMo")
	public Integer getCntWiresMo() {
		return cntWiresMo;
	}

	@JsonProperty("cntWiresMo")
	public void setCntWiresMo(Integer cntWiresMo) {
		this.cntWiresMo = cntWiresMo;
	}

	@JsonProperty("estmtdAnnualRevenue")
	public Integer getEstmtdAnnualRevenue() {
		return estmtdAnnualRevenue;
	}

	@JsonProperty("estmtdAnnualRevenue")
	public void setEstmtdAnnualRevenue(Integer estmtdAnnualRevenue) {
		this.estmtdAnnualRevenue = estmtdAnnualRevenue;
	}

	@JsonProperty("hdqtrsCntry")
	public String getHdqtrsCntry() {
		return hdqtrsCntry;
	}

	@JsonProperty("hdqtrsCntry")
	public void setHdqtrsCntry(String hdqtrsCntry) {
		this.hdqtrsCntry = hdqtrsCntry;
	}

	@JsonProperty("industry")
	public Integer getIndustry() {
		return industry;
	}

	@JsonProperty("industry")
	public void setIndustry(Integer industry) {
		this.industry = industry;
	}

	@JsonProperty("internetGamblingInc")
	public Boolean getInternetGamblingInc() {
		return internetGamblingInc;
	}

	@JsonProperty("internetGamblingInc")
	public void setInternetGamblingInc(Boolean internetGamblingInc) {
		this.internetGamblingInc = internetGamblingInc;
	}

	@JsonProperty("intrmySvcs")
	public List<Object> getIntrmySvcs() {
		return intrmySvcs;
	}

	@JsonProperty("intrmySvcs")
	public void setIntrmySvcs(List<Object> intrmySvcs) {
		this.intrmySvcs = intrmySvcs;
	}

	@JsonProperty("isAtmOper")
	public Boolean getIsAtmOper() {
		return isAtmOper;
	}

	@JsonProperty("isAtmOper")
	public void setIsAtmOper(Boolean isAtmOper) {
		this.isAtmOper = isAtmOper;
	}

	@JsonProperty("isCharity")
	public Boolean getIsCharity() {
		return isCharity;
	}

	@JsonProperty("isCharity")
	public void setIsCharity(Boolean isCharity) {
		this.isCharity = isCharity;
	}

	@JsonProperty("isMarijuanaBusiness")
	public Boolean getIsMarijuanaBusiness() {
		return isMarijuanaBusiness;
	}

	@JsonProperty("isMarijuanaBusiness")
	public void setIsMarijuanaBusiness(Boolean isMarijuanaBusiness) {
		this.isMarijuanaBusiness = isMarijuanaBusiness;
	}

	@JsonProperty("isThirdPartyBenefit")
	public Boolean getIsThirdPartyBenefit() {
		return isThirdPartyBenefit;
	}

	@JsonProperty("isThirdPartyBenefit")
	public void setIsThirdPartyBenefit(Boolean isThirdPartyBenefit) {
		this.isThirdPartyBenefit = isThirdPartyBenefit;
	}

	@JsonProperty("mnyOrderGrtrThsnd")
	public Boolean getMnyOrderGrtrThsnd() {
		return mnyOrderGrtrThsnd;
	}

	@JsonProperty("mnyOrderGrtrThsnd")
	public void setMnyOrderGrtrThsnd(Boolean mnyOrderGrtrThsnd) {
		this.mnyOrderGrtrThsnd = mnyOrderGrtrThsnd;
	}

	@JsonProperty("nbrLoc")
	public Integer getNbrLoc() {
		return nbrLoc;
	}

	@JsonProperty("nbrLoc")
	public void setNbrLoc(Integer nbrLoc) {
		this.nbrLoc = nbrLoc;
	}

	@JsonProperty("nonCashActivities")
	public Boolean getNonCashActivities() {
		return nonCashActivities;
	}

	@JsonProperty("nonCashActivities")
	public void setNonCashActivities(Boolean nonCashActivities) {
		this.nonCashActivities = nonCashActivities;
	}

	@JsonProperty("operCntry")
	public List<Object> getOperCntry() {
		return operCntry;
	}

	@JsonProperty("operCntry")
	public void setOperCntry(List<Object> operCntry) {
		this.operCntry = operCntry;
	}

	@JsonProperty("pctRevenueMnySvcs")
	public Integer getPctRevenueMnySvcs() {
		return pctRevenueMnySvcs;
	}

	@JsonProperty("pctRevenueMnySvcs")
	public void setPctRevenueMnySvcs(Integer pctRevenueMnySvcs) {
		this.pctRevenueMnySvcs = pctRevenueMnySvcs;
	}

	@JsonProperty("structure")
	public Integer getStructure() {
		return structure;
	}

	@JsonProperty("structure")
	public void setStructure(Integer structure) {
		this.structure = structure;
	}

	@JsonProperty("tfrForCust")
	public Boolean getTfrForCust() {
		return tfrForCust;
	}

	@JsonProperty("tfrForCust")
	public void setTfrForCust(Boolean tfrForCust) {
		this.tfrForCust = tfrForCust;
	}

	@JsonProperty("virtualCcy")
	public Boolean getVirtualCcy() {
		return virtualCcy;
	}

	@JsonProperty("virtualCcy")
	public void setVirtualCcy(Boolean virtualCcy) {
		this.virtualCcy = virtualCcy;
	}

	@JsonProperty("yearsOwnBusiness")
	public Integer getYearsOwnBusiness() {
		return yearsOwnBusiness;
	}

	@JsonProperty("yearsOwnBusiness")
	public void setYearsOwnBusiness(Integer yearsOwnBusiness) {
		this.yearsOwnBusiness = yearsOwnBusiness;
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
