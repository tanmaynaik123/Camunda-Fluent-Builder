package com.camundafluent.diagram.interfaces;

import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.model.bpmn.builder.ServiceTaskBuilder;
import org.camunda.bpm.model.bpmn.builder.UserTaskBuilder;

import com.camundafluent.diagram.bean.Flow;

public interface ICamundaApi {

	public void drawDiagram(String payload) throws Exception;
	
	public UserTaskBuilder callUserTask(UserTaskBuilder userTaskBuilder,Flow flowList);
	
	public ServiceTaskBuilder callServiceTask(ServiceTaskBuilder serviceTaskBuilder);
	
	public void createBpmnFile(BpmnModelInstance bpmnModelInstance) throws Exception;
}
