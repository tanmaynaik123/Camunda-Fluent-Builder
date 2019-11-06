
package com.camundafluent.diagram.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "id",
    "name",
    "assigneTaskToAssignee",
    "userTaskFormKey",
    "forms",
    "incoming",
    "outgoing"
})
public class Task {

    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("assigneTaskToAssignee")
    private String assigneTaskToAssignee;
    @JsonProperty("userTaskFormKey")
    private String userTaskFormKey;
    @JsonProperty("forms")
    private List<Form_> forms = null;
    @JsonProperty("incoming")
    private List<String> incoming = null;
    @JsonProperty("outgoing")
    private List<String> outgoing = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Task() {
    }

    /**
     * 
     * @param incoming
     * @param outgoing
     * @param assigneTaskToAssignee
     * @param name
     * @param id
     * @param type
     * @param userTaskFormKey
     * @param forms
     */
    public Task(String type, String id, String name, String assigneTaskToAssignee, String userTaskFormKey, List<Form_> forms, List<String> incoming, List<String> outgoing) {
        super();
        this.type = type;
        this.id = id;
        this.name = name;
        this.assigneTaskToAssignee = assigneTaskToAssignee;
        this.userTaskFormKey = userTaskFormKey;
        this.forms = forms;
        this.incoming = incoming;
        this.outgoing = outgoing;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Task withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public Task withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Task withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("assigneTaskToAssignee")
    public String getAssigneTaskToAssignee() {
        return assigneTaskToAssignee;
    }

    @JsonProperty("assigneTaskToAssignee")
    public void setAssigneTaskToAssignee(String assigneTaskToAssignee) {
        this.assigneTaskToAssignee = assigneTaskToAssignee;
    }

    public Task withAssigneTaskToAssignee(String assigneTaskToAssignee) {
        this.assigneTaskToAssignee = assigneTaskToAssignee;
        return this;
    }

    @JsonProperty("userTaskFormKey")
    public String getUserTaskFormKey() {
        return userTaskFormKey;
    }

    @JsonProperty("userTaskFormKey")
    public void setUserTaskFormKey(String userTaskFormKey) {
        this.userTaskFormKey = userTaskFormKey;
    }

    public Task withUserTaskFormKey(String userTaskFormKey) {
        this.userTaskFormKey = userTaskFormKey;
        return this;
    }

    @JsonProperty("forms")
    public List<Form_> getForms() {
        return forms;
    }

    @JsonProperty("forms")
    public void setForms(List<Form_> forms) {
        this.forms = forms;
    }

    public Task withForms(List<Form_> forms) {
        this.forms = forms;
        return this;
    }

    @JsonProperty("incoming")
    public List<String> getIncoming() {
        return incoming;
    }

    @JsonProperty("incoming")
    public void setIncoming(List<String> incoming) {
        this.incoming = incoming;
    }

    public Task withIncoming(List<String> incoming) {
        this.incoming = incoming;
        return this;
    }

    @JsonProperty("outgoing")
    public List<String> getOutgoing() {
        return outgoing;
    }

    @JsonProperty("outgoing")
    public void setOutgoing(List<String> outgoing) {
        this.outgoing = outgoing;
    }

    public Task withOutgoing(List<String> outgoing) {
        this.outgoing = outgoing;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Task withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("type", type).append("id", id).append("name", name).append("assigneTaskToAssignee", assigneTaskToAssignee).append("userTaskFormKey", userTaskFormKey).append("forms", forms).append("incoming", incoming).append("outgoing", outgoing).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(incoming).append(outgoing).append(assigneTaskToAssignee).append(name).append(id).append(additionalProperties).append(type).append(userTaskFormKey).append(forms).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Task) == false) {
            return false;
        }
        Task rhs = ((Task) other);
        return new EqualsBuilder().append(incoming, rhs.incoming).append(outgoing, rhs.outgoing).append(assigneTaskToAssignee, rhs.assigneTaskToAssignee).append(name, rhs.name).append(id, rhs.id).append(additionalProperties, rhs.additionalProperties).append(type, rhs.type).append(userTaskFormKey, rhs.userTaskFormKey).append(forms, rhs.forms).isEquals();
    }

}
