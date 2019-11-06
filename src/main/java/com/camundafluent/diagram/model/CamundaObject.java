
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
    "processName",
    "events",
    "tasks",
    "sequenceFlow",
    "gateway"
})
public class CamundaObject {

    @JsonProperty("processName")
    private ProcessName processName;
    @JsonProperty("events")
    private List<Event> events = null;
    @JsonProperty("tasks")
    private List<Task> tasks = null;
    @JsonProperty("sequenceFlow")
    private List<SequenceFlow> sequenceFlow = null;
    @JsonProperty("gateway")
    private List<Gateway> gateway = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CamundaObject() {
    }

    /**
     * 
     * @param sequenceFlow
     * @param processName
     * @param events
     * @param tasks
     * @param gateway
     */
    public CamundaObject(ProcessName processName, List<Event> events, List<Task> tasks, List<SequenceFlow> sequenceFlow, List<Gateway> gateway) {
        super();
        this.processName = processName;
        this.events = events;
        this.tasks = tasks;
        this.sequenceFlow = sequenceFlow;
        this.gateway = gateway;
    }

    @JsonProperty("processName")
    public ProcessName getProcessName() {
        return processName;
    }

    @JsonProperty("processName")
    public void setProcessName(ProcessName processName) {
        this.processName = processName;
    }

    public CamundaObject withProcessName(ProcessName processName) {
        this.processName = processName;
        return this;
    }

    @JsonProperty("events")
    public List<Event> getEvents() {
        return events;
    }

    @JsonProperty("events")
    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public CamundaObject withEvents(List<Event> events) {
        this.events = events;
        return this;
    }

    @JsonProperty("tasks")
    public List<Task> getTasks() {
        return tasks;
    }

    @JsonProperty("tasks")
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public CamundaObject withTasks(List<Task> tasks) {
        this.tasks = tasks;
        return this;
    }

    @JsonProperty("sequenceFlow")
    public List<SequenceFlow> getSequenceFlow() {
        return sequenceFlow;
    }

    @JsonProperty("sequenceFlow")
    public void setSequenceFlow(List<SequenceFlow> sequenceFlow) {
        this.sequenceFlow = sequenceFlow;
    }

    public CamundaObject withSequenceFlow(List<SequenceFlow> sequenceFlow) {
        this.sequenceFlow = sequenceFlow;
        return this;
    }

    @JsonProperty("gateway")
    public List<Gateway> getGateway() {
        return gateway;
    }

    @JsonProperty("gateway")
    public void setGateway(List<Gateway> gateway) {
        this.gateway = gateway;
    }

    public CamundaObject withGateway(List<Gateway> gateway) {
        this.gateway = gateway;
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

    public CamundaObject withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("processName", processName).append("events", events).append("tasks", tasks).append("sequenceFlow", sequenceFlow).append("gateway", gateway).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sequenceFlow).append(processName).append(additionalProperties).append(events).append(tasks).append(gateway).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CamundaObject) == false) {
            return false;
        }
        CamundaObject rhs = ((CamundaObject) other);
        return new EqualsBuilder().append(sequenceFlow, rhs.sequenceFlow).append(processName, rhs.processName).append(additionalProperties, rhs.additionalProperties).append(events, rhs.events).append(tasks, rhs.tasks).append(gateway, rhs.gateway).isEquals();
    }

}
