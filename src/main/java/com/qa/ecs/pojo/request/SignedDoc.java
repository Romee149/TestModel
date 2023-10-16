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
@JsonPropertyOrder({ "docSubType", "docType", "signedBy", "signedDtm", "version" })

public class SignedDoc {

	@JsonProperty("docSubType")
	private String docSubType;
	@JsonProperty("docType")
	private Integer docType;
	@JsonProperty("signedBy")
	private SignedBy signedBy;
	@JsonProperty("signedDtm")
	private String signedDtm;
	@JsonProperty("version")
	private String version;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("docSubType")
	public String getDocSubType() {
		return docSubType;
	}

	@JsonProperty("docSubType")
	public void setDocSubType(String docSubType) {
		this.docSubType = docSubType;
	}

	@JsonProperty("docType")
	public Integer getDocType() {
		return docType;
	}

	@JsonProperty("docType")
	public void setDocType(Integer docType) {
		this.docType = docType;
	}

	@JsonProperty("signedBy")
	public SignedBy getSignedBy() {
		return signedBy;
	}

	@JsonProperty("signedBy")
	public void setSignedBy(SignedBy signedBy) {
		this.signedBy = signedBy;
	}

	@JsonProperty("signedDtm")
	public String getSignedDtm() {
		return signedDtm;
	}

	@JsonProperty("signedDtm")
	public void setSignedDtm(String signedDtm) {
		this.signedDtm = signedDtm;
	}

	@JsonProperty("version")
	public String getVersion() {
		return version;
	}

	@JsonProperty("version")
	public void setVersion(String version) {
		this.version = version;
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
