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
@JsonPropertyOrder({ "_vn", "assocFrgnSrPolFig", "cntry", "frgnSrPolFig" })

public class PartyPersonDueDiligence {

	@JsonProperty("_vn")
	private Integer vn;
	@JsonProperty("assocFrgnSrPolFig")
	private Integer assocFrgnSrPolFig;
	@JsonProperty("cntry")
	private String cntry;
	@JsonProperty("frgnSrPolFig")
	private Boolean frgnSrPolFig;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("_vn")
	public Integer getVn() {
		return vn;
	}

	@JsonProperty("_vn")
	public void setVn(Integer vn) {
		this.vn = vn;
	}

	@JsonProperty("assocFrgnSrPolFig")
	public Integer getAssocFrgnSrPolFig() {
		return assocFrgnSrPolFig;
	}

	@JsonProperty("assocFrgnSrPolFig")
	public void setAssocFrgnSrPolFig(Integer assocFrgnSrPolFig) {
		this.assocFrgnSrPolFig = assocFrgnSrPolFig;
	}

	@JsonProperty("cntry")
	public String getCntry() {
		return cntry;
	}

	@JsonProperty("cntry")
	public void setCntry(String cntry) {
		this.cntry = cntry;
	}

	@JsonProperty("frgnSrPolFig")
	public Boolean getFrgnSrPolFig() {
		return frgnSrPolFig;
	}

	@JsonProperty("frgnSrPolFig")
	public void setFrgnSrPolFig(Boolean frgnSrPolFig) {
		this.frgnSrPolFig = frgnSrPolFig;
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