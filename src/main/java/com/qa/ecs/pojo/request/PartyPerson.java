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
@JsonPropertyOrder({ "_schVn", "ageBracket", "birthDate", "cntry", "contactPref", "education", "emails",
		"employmentStatus", "ethnicity", "familiarName", "firstName", "gender", "incBracket", "lastName",
		"maritalStatus", "middleName", "moGrossInc", "mothersMaidenName", "nbrInHhold", "occupation",
		"party_personDueDiligence", "party_personUSSvcMember", "phones", "preferredLanguage", "prefix",
		"residencyStatus", "spouse", "studentType", "suffix", "tin", "tinType", "webAddr" })

public class PartyPerson {

	@JsonProperty("_schVn")
	private Integer schVn;
	@JsonProperty("ageBracket")
	private Integer ageBracket;
	@JsonProperty("birthDate")
	private String birthDate;
	@JsonProperty("cntry")
	private String cntry;
	@JsonProperty("contactPref")
	private Integer contactPref;
	@JsonProperty("education")
	private Integer education;
	@JsonProperty("emails")
	private List<Email> emails;
	@JsonProperty("employmentStatus")
	private Integer employmentStatus;
	@JsonProperty("ethnicity")
	private Integer ethnicity;
	@JsonProperty("familiarName")
	private String familiarName;
	@JsonProperty("firstName")
	private String firstName;
	@JsonProperty("gender")
	private Integer gender;
	@JsonProperty("incBracket")
	private Integer incBracket;
	@JsonProperty("lastName")
	private String lastName;
	@JsonProperty("maritalStatus")
	private Integer maritalStatus;
	@JsonProperty("middleName")
	private String middleName;
	@JsonProperty("moGrossInc")
	private Integer moGrossInc;
	@JsonProperty("mothersMaidenName")
	private String mothersMaidenName;
	@JsonProperty("nbrInHhold")
	private Integer nbrInHhold;
	@JsonProperty("occupation")
	private Integer occupation;
	@JsonProperty("party_personDueDiligence")
	private PartyPersonDueDiligence partyPersonDueDiligence;
	@JsonProperty("party_personUSSvcMember")
	private PartyPersonUSSvcMember partyPersonUSSvcMember;
	@JsonProperty("phones")
	private List<Phone> phones;
	@JsonProperty("preferredLanguage")
	private String preferredLanguage;
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
	@JsonProperty("tin")
	private String tin;
	@JsonProperty("tinType")
	private Integer tinType;
	@JsonProperty("webAddr")
	private String webAddr;
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

	@JsonProperty("ageBracket")
	public Integer getAgeBracket() {
		return ageBracket;
	}

	@JsonProperty("ageBracket")
	public void setAgeBracket(Integer ageBracket) {
		this.ageBracket = ageBracket;
	}

	@JsonProperty("birthDate")
	public String getBirthDate() {
		return birthDate;
	}

	@JsonProperty("birthDate")
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@JsonProperty("cntry")
	public String getCntry() {
		return cntry;
	}

	@JsonProperty("cntry")
	public void setCntry(String cntry) {
		this.cntry = cntry;
	}

	@JsonProperty("contactPref")
	public Integer getContactPref() {
		return contactPref;
	}

	@JsonProperty("contactPref")
	public void setContactPref(Integer contactPref) {
		this.contactPref = contactPref;
	}

	@JsonProperty("education")
	public Integer getEducation() {
		return education;
	}

	@JsonProperty("education")
	public void setEducation(Integer education) {
		this.education = education;
	}

	@JsonProperty("emails")
	public List<Email> getEmails() {
		return emails;
	}

	@JsonProperty("emails")
	public void setEmails(List<Email> emails) {
		this.emails = emails;
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

	@JsonProperty("firstName")
	public String getFirstName() {
		return firstName;
	}

	@JsonProperty("firstName")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	@JsonProperty("lastName")
	public String getLastName() {
		return lastName;
	}

	@JsonProperty("lastName")
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public Integer getMoGrossInc() {
		return moGrossInc;
	}

	@JsonProperty("moGrossInc")
	public void setMoGrossInc(Integer moGrossInc) {
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

	@JsonProperty("party_personDueDiligence")
	public PartyPersonDueDiligence getPartyPersonDueDiligence() {
		return partyPersonDueDiligence;
	}

	@JsonProperty("party_personDueDiligence")
	public void setPartyPersonDueDiligence(PartyPersonDueDiligence partyPersonDueDiligence) {
		this.partyPersonDueDiligence = partyPersonDueDiligence;
	}

	@JsonProperty("party_personUSSvcMember")
	public PartyPersonUSSvcMember getPartyPersonUSSvcMember() {
		return partyPersonUSSvcMember;
	}

	@JsonProperty("party_personUSSvcMember")
	public void setPartyPersonUSSvcMember(PartyPersonUSSvcMember partyPersonUSSvcMember) {
		this.partyPersonUSSvcMember = partyPersonUSSvcMember;
	}

	@JsonProperty("phones")
	public List<Phone> getPhones() {
		return phones;
	}

	@JsonProperty("phones")
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	@JsonProperty("preferredLanguage")
	public String getPreferredLanguage() {
		return preferredLanguage;
	}

	@JsonProperty("preferredLanguage")
	public void setPreferredLanguage(String preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
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

	@JsonProperty("tin")
	public String getTin() {
		return tin;
	}

	@JsonProperty("tin")
	public void setTin(String tin) {
		this.tin = tin;
	}

	@JsonProperty("tinType")
	public Integer getTinType() {
		return tinType;
	}

	@JsonProperty("tinType")
	public void setTinType(Integer tinType) {
		this.tinType = tinType;
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
