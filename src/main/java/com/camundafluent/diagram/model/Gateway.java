
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
    "incoming",
    "outgoing"
})
public class Gateway {

    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    private String id;
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
    public Gateway() {
    }

    /**
     * 
     * @param incoming
     * @param outgoing
     * @param id
     * @param type
     */
    public Gateway(String type, String id, List<String> incoming, List<String> outgoing) {
        super();
        this.type = type;
        this.id = id;
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

    public Gateway withType(String type) {
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

    public Gateway withId(String id) {
        this.id = id;
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

    public Gateway withIncoming(List<String> incoming) {
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

    public Gateway withOutgoing(List<String> outgoing) {
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

    public Gateway withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("type", type).append("id", id).append("incoming", incoming).append("outgoing", outgoing).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(incoming).append(outgoing).append(id).append(additionalProperties).append(type).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Gateway) == false) {
            return false;
        }
        Gateway rhs = ((Gateway) other);
        return new EqualsBuilder().append(incoming, rhs.incoming).append(outgoing, rhs.outgoing).append(id, rhs.id).append(additionalProperties, rhs.additionalProperties).append(type, rhs.type).isEquals();
    }

}
