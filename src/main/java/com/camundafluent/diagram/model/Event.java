
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
    "formKey",
    "forms",
    "outgoing",
    "incoming"
})
public class Event {

    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("formKey")
    private String formKey;
    @JsonProperty("forms")
    private List<Form> forms = null;
    @JsonProperty("outgoing")
    private List<String> outgoing = null;
    @JsonProperty("incoming")
    private List<String> incoming = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Event() {
    }

    /**
     * 
     * @param outgoing
     * @param incoming
     * @param formKey
     * @param name
     * @param id
     * @param type
     * @param forms
     */
    public Event(String type, String id, String name, String formKey, List<Form> forms, List<String> outgoing, List<String> incoming) {
        super();
        this.type = type;
        this.id = id;
        this.name = name;
        this.formKey = formKey;
        this.forms = forms;
        this.outgoing = outgoing;
        this.incoming = incoming;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Event withType(String type) {
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

    public Event withId(String id) {
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

    public Event withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("formKey")
    public String getFormKey() {
        return formKey;
    }

    @JsonProperty("formKey")
    public void setFormKey(String formKey) {
        this.formKey = formKey;
    }

    public Event withFormKey(String formKey) {
        this.formKey = formKey;
        return this;
    }

    @JsonProperty("forms")
    public List<Form> getForms() {
        return forms;
    }

    @JsonProperty("forms")
    public void setForms(List<Form> forms) {
        this.forms = forms;
    }

    public Event withForms(List<Form> forms) {
        this.forms = forms;
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

    public Event withOutgoing(List<String> outgoing) {
        this.outgoing = outgoing;
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

    public Event withIncoming(List<String> incoming) {
        this.incoming = incoming;
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

    public Event withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("type", type).append("id", id).append("name", name).append("formKey", formKey).append("forms", forms).append("outgoing", outgoing).append("incoming", incoming).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(outgoing).append(incoming).append(formKey).append(name).append(id).append(additionalProperties).append(type).append(forms).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Event) == false) {
            return false;
        }
        Event rhs = ((Event) other);
        return new EqualsBuilder().append(outgoing, rhs.outgoing).append(incoming, rhs.incoming).append(formKey, rhs.formKey).append(name, rhs.name).append(id, rhs.id).append(additionalProperties, rhs.additionalProperties).append(type, rhs.type).append(forms, rhs.forms).isEquals();
    }

}
