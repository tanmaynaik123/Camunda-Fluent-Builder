package com.camundafluent.diagram.service;

import java.io.File;

import org.camunda.bpm.model.bpmn.Bpmn;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.model.bpmn.builder.CamundaStartEventFormFieldBuilder;
import org.camunda.bpm.model.bpmn.builder.ProcessBuilder;
import org.camunda.bpm.model.bpmn.builder.ServiceTaskBuilder;
import org.camunda.bpm.model.bpmn.builder.UserTaskBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camundafluent.diagram.bean.Flow;
import com.camundafluent.diagram.interfaces.ICamundaApi;
import com.camundafluent.diagram.model.CamundaObject;
import com.camundafluent.diagram.utils.CamundaUtils;
import com.google.gson.Gson;

@Service
public class CamundaApiService implements ICamundaApi{


	@Autowired
	CamundaUtils camundaUtils;
	
	@Override
	public void drawDiagram(String payload) throws Exception {
		// TODO Auto-generated method stub
		CamundaObject camundaObject =new Gson().fromJson(payload, CamundaObject.class);
		camundaUtils.getFinalObject(camundaObject);
		
	}

	

}


