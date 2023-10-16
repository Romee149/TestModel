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
@JsonPropertyOrder({ "contactPref", "name", "tinType", "_schVn", "ageBracket", "education", "employmentStatus",
		"ethnicity", "familiarName", "gender", "incBracket", "maidenName", "maritalStatus", "middleName", "moGrossInc",
		"mothersMaidenName", "nbrInHhold", "occupation", "prefix", "residencyStatus", "spouse", "studentType", "suffix",
		"webAddr" })

public class SignedBy {

	@JsonProperty("contactPref")
	private Integer contactPref;
	@JsonProperty("name")
	private String name;
	@JsonProperty("tinType")
	private Integer tinType;
	@JsonProperty("_schVn")
	private Integer schVn;
	@JsonProperty("ageBracket")
	private Integer ageBracket;
	@JsonProperty("education")
	private Integer education;
	@JsonProperty("employmentStatus")
	private Integer employmentStatus;
	@JsonProperty("ethnicity")
	private Integer ethnicity;
	@JsonProperty("familiarName")
	private String familiarName;
	@JsonProperty("gender")
	private Integer gender;
	@JsonProperty("incBracket")
	private Integer incBracket;
	@JsonProperty("maidenName")
	private String maidenName;
	@JsonProperty("maritalStatus")
	private Integer maritalStatus;
	@JsonProperty("middleName")
	private String middleName;
	@JsonProperty("moGrossInc")
	private Double moGrossInc;
	@JsonProperty("mothersMaidenName")
	private String mothersMaidenName;
	@JsonProperty("nbrInHhold")
	private Integer nbrInHhold;
	@JsonProperty("occupation")
	private Integer occupation;
	@JsonProperty("prefix")
	private String prefix;
	@JsonProperty("residencyStatus")
	private Integer residencyStatus;
	@JsonProperty("spouse")
	private String spouse;
	@JsonProperty("studentType")
	private Integer studentType;
	@JsonProperty("suffix")
	private String suffix;
	@JsonProperty("webAddr")
	private String webAddr;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("contactPref")
	public Integer getContactPref() {
		return contactPref;
	}

	@JsonProperty("contactPref")
	public void setContactPref(Integer contactPref) {
		this.contactPref = contactPref;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("tinType")
	public Integer getTinType() {
		return tinType;
	}

	@JsonProperty("tinType")
	public void setTinType(Integer tinType) {
		this.tinType = tinType;
	}

	@JsonProperty("_schVn")
	public Integer getSchVn() {
		return schVn;
	}

	@JsonProperty("_schVn")
	public void setSchVn(Integer schVn) {
		this.schVn = schVn;
	}

	@JsonProperty("ageBracket")
	public Integer getAgeBracket() {
		return ageBracket;
	}

	@JsonProperty("ageBracket")
	public void setAgeBracket(Integer ageBracket) {
		this.ageBracket = ageBracket;
	}

	@JsonProperty("education")
	public Integer getEducation() {
		return education;
	}

	@JsonProperty("education")
	public void setEducation(Integer education) {
		this.education = education;
	}

	@JsonProperty("employmentStatus")
	public Integer getEmploymentStatus() {
		return employmentStatus;
	}

	@JsonProperty("employmentStatus")
	public void setEmploymentStatus(Integer employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	@JsonProperty("ethnicity")
	public Integer getEthnicity() {
		return ethnicity;
	}

	@JsonProperty("ethnicity")
	public void setEthnicity(Integer ethnicity) {
		this.ethnicity = ethnicity;
	}

	@JsonProperty("familiarName")
	public String getFamiliarName() {
		return familiarName;
	}

	@JsonProperty("familiarName")
	public void setFamiliarName(String familiarName) {
		this.familiarName = familiarName;
	}

	@JsonProperty("gender")
	public Integer getGender() {
		return gender;
	}

	@JsonProperty("gender")
	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@JsonProperty("incBracket")
	public Integer getIncBracket() {
		return incBracket;
	}

	@JsonProperty("incBracket")
	public void setIncBracket(Integer incBracket) {
		this.incBracket = incBracket;
	}

	@JsonProperty("maidenName")
	public String getMaidenName() {
		return maidenName;
	}

	@JsonProperty("maidenName")
	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}

	@JsonProperty("maritalStatus")
	public Integer getMaritalStatus() {
		return maritalStatus;
	}

	@JsonProperty("maritalStatus")
	public void setMaritalStatus(Integer maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	@JsonProperty("middleName")
	public String getMiddleName() {
		return middleName;
	}

	@JsonProperty("middleName")
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@JsonProperty("moGrossInc")
	public Double getMoGrossInc() {
		return moGrossInc;
	}

	@JsonProperty("moGrossInc")
	public void setMoGrossInc(Double moGrossInc) {
		this.moGrossInc = moGrossInc;
	}

	@JsonProperty("mothersMaidenName")
	public String getMothersMaidenName() {
		return mothersMaidenName;
	}

	@JsonProperty("mothersMaidenName")
	public void setMothersMaidenName(String mothersMaidenName) {
		this.mothersMaidenName = mothersMaidenName;
	}

	@JsonProperty("nbrInHhold")
	public Integer getNbrInHhold() {
		return nbrInHhold;
	}

	@JsonProperty("nbrInHhold")
	public void setNbrInHhold(Integer nbrInHhold) {
		this.nbrInHhold = nbrInHhold;
	}

	@JsonProperty("occupation")
	public Integer getOccupation() {
		return occupation;
	}

	@JsonProperty("occupation")
	public void setOccupation(Integer occupation) {
		this.occupation = occupation;
	}

	@JsonProperty("prefix")
	public String getPrefix() {
		return prefix;
	}

	@JsonProperty("prefix")
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	@JsonProperty("residencyStatus")
	public Integer getResidencyStatus() {
		return residencyStatus;
	}

	@JsonProperty("residencyStatus")
	public void setResidencyStatus(Integer residencyStatus) {
		this.residencyStatus = residencyStatus;
	}

	@JsonProperty("spouse")
	public String getSpouse() {
		return spouse;
	}

	@JsonProperty("spouse")
	public void setSpouse(String spouse) {
		this.spouse = spouse;
	}

	@JsonProperty("studentType")
	public Integer getStudentType() {
		return studentType;
	}

	@JsonProperty("studentType")
	public void setStudentType(Integer studentType) {
		this.studentType = studentType;
	}

	@JsonProperty("suffix")
	public String getSuffix() {
		return suffix;
	}

	@JsonProperty("suffix")
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@JsonProperty("webAddr")
	public String getWebAddr() {
		return webAddr;
	}

	@JsonProperty("webAddr")
	public void setWebAddr(String webAddr) {
		this.webAddr = webAddr;
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