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
@JsonPropertyOrder({ "entries", "mode", "trnCode" })

public class AddFundToAccount {

	@JsonProperty("entries")
	private List<Entry> entries;
	@JsonProperty("mode")
	private Integer mode;
	@JsonProperty("trnCode")
	private String trnCode;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("entries")
	public List<Entry> getEntries() {
		return entries;
	}

	@JsonProperty("entries")
	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}

	@JsonProperty("mode")
	public Integer getMode() {
		return mode;
	}

	@JsonProperty("mode")
	public void setMode(Integer mode) {
		this.mode = mode;
	}

	@JsonProperty("trnCode")
	public String getTrnCode() {
		return trnCode;
	}

	@JsonProperty("trnCode")
	public void setTrnCode(String trnCode) {
		this.trnCode = trnCode;
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
