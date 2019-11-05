
package com.camundafluent.diagram.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "id",
    "name",
    "forms"
})
public class Flow {

    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("camundaAssignee")
    private String camundaAssignee;
    @JsonProperty("forms")
    private List<Form_> forms = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Flow() {
    }

    /**
     * 
     * @param name
     * @param id
     * @param type
     * @param forms
     */
    public Flow(String type, String id, String name, String camundaAssignee,List<Form_> forms) {
        super();
        this.type = type;
        this.id = id;
        this.name = name;
        this.camundaAssignee=camundaAssignee;
        this.forms = forms;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("forms")
    public List<Form_> getForms() {
        return forms;
    }

    @JsonProperty("forms")
    public void setForms(List<Form_> forms) {
        this.forms = forms;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @JsonProperty("camundaAssignee")
	public String getCamundaAssignee() {
		return camundaAssignee;
	}

    @JsonProperty("camundaAssignee")
	public void setCamundaAssignee(String camundaAssignee) {
		this.camundaAssignee = camundaAssignee;
	}

   
}
