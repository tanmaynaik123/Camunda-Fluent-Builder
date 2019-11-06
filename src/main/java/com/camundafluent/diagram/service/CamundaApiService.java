package com.camundafluent.diagram.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.model.bpmn.Bpmn;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.model.bpmn.builder.ProcessBuilder;
import org.camunda.bpm.model.bpmn.builder.ServiceTaskBuilder;
import org.camunda.bpm.model.bpmn.builder.StartEventBuilder;
import org.camunda.bpm.model.bpmn.builder.UserTaskBuilder;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.camundafluent.diagram.bean.Flow;
import com.camundafluent.diagram.bean.SchemaForDiagram;
import com.camundafluent.diagram.exception.SchemaException;
import com.camundafluent.diagram.interfaces.ICamundaApi;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class CamundaApiService implements ICamundaApi{


	public UserTaskBuilder userTaskBuilder;
	
	@Override
	public void drawDiagram(String payload) throws Exception {
		// TODO Auto-generated method stub
		SchemaForDiagram schemaForDiagramBean =new Gson().fromJson(payload, SchemaForDiagram.class);
		ProcessBuilder processBuilder=Bpmn.createExecutableProcess(schemaForDiagramBean.getProcessName().getId())
				.name(schemaForDiagramBean.getProcessName().getName());
		StartEventBuilder startEventBuilder =processBuilder.startEvent().id(schemaForDiagramBean.getStartEvent().getId())
				.name(schemaForDiagramBean.getStartEvent().getName());
		
		

		if(!schemaForDiagramBean.getStartEvent().getForms().isEmpty()) {
			schemaForDiagramBean.getStartEvent().getForms().forEach(formsList->{
				startEventBuilder.camundaFormField().camundaId(formsList.getId())
				.camundaType(formsList.getType())
				.camundaLabel(formsList.getLabel())
				;
			});
		}
		else {
			throw new SchemaException("Forms list is empty");
		}
		if(!schemaForDiagramBean.getFlow().isEmpty()){
			schemaForDiagramBean.getFlow().forEach(flowList->{
				if(flowList.getType().equalsIgnoreCase("userTask")) {

					userTaskBuilder=callUserTask(startEventBuilder.userTask(),flowList);
					if(!flowList.getForms().isEmpty()) {
						flowList.getForms().forEach(formList->{
							userTaskBuilder.camundaFormField().camundaId(formList.getId())
							.camundaType(formList.getType())
							.camundaLabel(formList.getLabel());
						});
					}

					else {
						throw new SchemaException("User Task Froms is empty");
					}
				}
				else {
					callServiceTask(startEventBuilder.serviceTask());
				}
			});
		}
		else {
			throw new SchemaException("User Task is empty");
		}
		BpmnModelInstance bpmnModelInstance = userTaskBuilder.endEvent().id(schemaForDiagramBean.getEndEvent().getId()).name(schemaForDiagramBean.getEndEvent().getName()).done();
		createBpmnFile(bpmnModelInstance);

	}

	@Override
	public UserTaskBuilder callUserTask(UserTaskBuilder userTaskBuilder, Flow flowList) {
		// TODO Auto-generated method stub
		userTaskBuilder.id(flowList.getId()).name(flowList.getName()).camundaAssignee(flowList.getCamundaAssignee());

		return userTaskBuilder;
	}

	@Override
	public ServiceTaskBuilder callServiceTask(ServiceTaskBuilder serviceTaskBuilder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createBpmnFile(BpmnModelInstance bpmnModelInstance) throws Exception {
		// TODO Auto-generated method stub
		try {
			File file = File.createTempFile("bpmn-model-api-", ".bpmn",new File("/home/tanmaynaik/Documents/Camunda-FluentApi"));
			Bpmn.writeModelToFile(file, bpmnModelInstance);
			
		}
		catch(Exception e ) {
			System.out.println(e.getMessage());
		}

	}

}


