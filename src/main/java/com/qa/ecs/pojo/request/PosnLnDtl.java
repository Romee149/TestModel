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
@JsonPropertyOrder({ "posn_ln", "prodName" })

public class PosnLnDtl {

	@JsonProperty("posn_ln")
	private PosnLn posnLn;
	@JsonProperty("prodName")
	private String prodName;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("posn_ln")
	public PosnLn getPosnLn() {
		return posnLn;
	}

	@JsonProperty("posn_ln")
	public void setPosnLn(PosnLn posnLn) {
		this.posnLn = posnLn;
	}

	@JsonProperty("prodName")
	public String getProdName() {
		return prodName;
	}

	@JsonProperty("prodName")
	public void setProdName(String prodName) {
		this.prodName = prodName;
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