package com.qa.ecs.pojo.response;

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
@JsonPropertyOrder({ "direction", "dueItemOrder" })

public class Past {

	@JsonProperty("direction")
	private String direction;
	@JsonProperty("dueItemOrder")
	private List<String> dueItemOrder;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("direction")
	public String getDirection() {
		return direction;
	}

	@JsonProperty("direction")
	public void setDirection(String direction) {
		this.direction = direction;
	}

	@JsonProperty("dueItemOrder")
	public List<String> getDueItemOrder() {
		return dueItemOrder;
	}

	@JsonProperty("dueItemOrder")
	public void setDueItemOrder(List<String> dueItemOrder) {
		this.dueItemOrder = dueItemOrder;
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