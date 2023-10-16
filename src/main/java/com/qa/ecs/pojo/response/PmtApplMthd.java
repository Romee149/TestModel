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
@JsonPropertyOrder({ "Current", "Past", "Priority" })
public class PmtApplMthd {

	@JsonProperty("Current")
	private Current current;
	@JsonProperty("Past")
	private Past past;
	@JsonProperty("Priority")
	private Priority priority;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("Current")
	public Current getCurrent() {
		return current;
	}

	@JsonProperty("Current")
	public void setCurrent(Current current) {
		this.current = current;
	}

	@JsonProperty("Past")
	public Past getPast() {
		return past;
	}

	@JsonProperty("Past")
	public void setPast(Past past) {
		this.past = past;
	}

	@JsonProperty("Priority")
	public Priority getPriority() {
		return priority;
	}

	@JsonProperty("Priority")
	public void setPriority(Priority priority) {
		this.priority = priority;
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