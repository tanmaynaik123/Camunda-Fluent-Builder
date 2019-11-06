
package com.camundafluent.diagram.model;

import java.util.HashMap;
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
    "id",
    "name",
    "sourceRef",
    "targetRef"
})
public class SequenceFlow {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("sourceRef")
    private String sourceRef;
    @JsonProperty("targetRef")
    private String targetRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SequenceFlow() {
    }

    /**
     * 
     * @param targetRef
     * @param name
     * @param id
     * @param sourceRef
     */
    public SequenceFlow(String id, String name, String sourceRef, String targetRef) {
        super();
        this.id = id;
        this.name = name;
        this.sourceRef = sourceRef;
        this.targetRef = targetRef;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public SequenceFlow withId(String id) {
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

    public SequenceFlow withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("sourceRef")
    public String getSourceRef() {
        return sourceRef;
    }

    @JsonProperty("sourceRef")
    public void setSourceRef(String sourceRef) {
        this.sourceRef = sourceRef;
    }

    public SequenceFlow withSourceRef(String sourceRef) {
        this.sourceRef = sourceRef;
        return this;
    }

    @JsonProperty("targetRef")
    public String getTargetRef() {
        return targetRef;
    }

    @JsonProperty("targetRef")
    public void setTargetRef(String targetRef) {
        this.targetRef = targetRef;
    }

    public SequenceFlow withTargetRef(String targetRef) {
        this.targetRef = targetRef;
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

    public SequenceFlow withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("sourceRef", sourceRef).append("targetRef", targetRef).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(targetRef).append(id).append(additionalProperties).append(sourceRef).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SequenceFlow) == false) {
            return false;
        }
        SequenceFlow rhs = ((SequenceFlow) other);
        return new EqualsBuilder().append(name, rhs.name).append(targetRef, rhs.targetRef).append(id, rhs.id).append(additionalProperties, rhs.additionalProperties).append(sourceRef, rhs.sourceRef).isEquals();
    }

}
