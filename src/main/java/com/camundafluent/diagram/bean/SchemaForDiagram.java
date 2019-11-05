
package com.camundafluent.diagram.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.camundafluent.diagram.bean.ProcessName;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "processName",
    "startEvent",
    "flow",
    "endEvent"
})
public class SchemaForDiagram {

    @JsonProperty("processName")
    private ProcessName processName;
    @JsonProperty("startEvent")
    private StartEvent startEvent;
    @JsonProperty("flow")
    private List<Flow> flow = null;
    @JsonProperty("endEvent")
    private EndEvent endEvent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SchemaForDiagram() {
    }

    /**
     * 
     * @param endEvent
     * @param processName
     * @param startEvent
     * @param flow
     */
    public SchemaForDiagram(ProcessName processName, StartEvent startEvent, List<Flow> flow, EndEvent endEvent) {
        super();
        this.processName = processName;
        this.startEvent = startEvent;
        this.flow = flow;
        this.endEvent = endEvent;
    }

    @JsonProperty("processName")
    public ProcessName getProcessName() {
        return processName;
    }

    @JsonProperty("processName")
    public void setProcessName(ProcessName processName) {
        this.processName = processName;
    }

    @JsonProperty("startEvent")
    public StartEvent getStartEvent() {
        return startEvent;
    }

    @JsonProperty("startEvent")
    public void setStartEvent(StartEvent startEvent) {
        this.startEvent = startEvent;
    }

    @JsonProperty("flow")
    public List<Flow> getFlow() {
        return flow;
    }

    @JsonProperty("flow")
    public void setFlow(List<Flow> flow) {
        this.flow = flow;
    }

    @JsonProperty("endEvent")
    public EndEvent getEndEvent() {
        return endEvent;
    }

    @JsonProperty("endEvent")
    public void setEndEvent(EndEvent endEvent) {
        this.endEvent = endEvent;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("processName", processName).append("startEvent", startEvent).append("flow", flow).append("endEvent", endEvent).append("additionalProperties", additionalProperties).toString();
    }

}
