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
@JsonPropertyOrder({ "prodName", "posn_dep" })

public class PosnDepDtl {

	@JsonProperty("prodName")
	private String prodName;
	@JsonProperty("posn_dep")
	private PosnDep posnDep;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("prodName")
	public String getProdName() {
		return prodName;
	}

	@JsonProperty("prodName")
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	@JsonProperty("posn_dep")
	public PosnDep getPosnDep() {
		return posnDep;
	}

	@JsonProperty("posn_dep")
	public void setPosnDep(PosnDep posnDep) {
		this.posnDep = posnDep;
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