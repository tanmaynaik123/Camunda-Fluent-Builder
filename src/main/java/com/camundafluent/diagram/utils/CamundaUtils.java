package com.camundafluent.diagram.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.camunda.bpm.model.bpmn.Bpmn;
import org.camunda.bpm.model.bpmn.builder.EndEventBuilder;
import org.camunda.bpm.model.bpmn.builder.ExclusiveGatewayBuilder;
import org.camunda.bpm.model.bpmn.builder.ProcessBuilder;
import org.camunda.bpm.model.bpmn.builder.SequenceFlowBuilder;
import org.camunda.bpm.model.bpmn.builder.StartEventBuilder;
import org.camunda.bpm.model.bpmn.builder.UserTaskBuilder;
import org.camunda.bpm.model.bpmn.instance.UserTask;
import org.springframework.stereotype.Component;

import com.camundafluent.diagram.model.CamundaObject;
import com.camundafluent.diagram.model.Event;
import com.camundafluent.diagram.model.Gateway;
import com.camundafluent.diagram.model.ProcessName;
import com.camundafluent.diagram.model.SequenceFlow;
import com.camundafluent.diagram.model.Task;

@Component
public class CamundaUtils {

	private ProcessBuilder processBuilder;

	private StartEventBuilder startEventBuilder;
	private EndEventBuilder endEventBuilder;
	private SequenceFlowBuilder sequenceFlowBuilder;
	private ExclusiveGatewayBuilder exclusiveGatewayBuilder;
	private UserTaskBuilder userTaskBuilder = new UserTaskBuilder(null, null);

	public void getFinalObject(CamundaObject camundaObject) {

		if (camundaObject.getProcessName() != null)
			setProcessDetails(camundaObject.getProcessName());

		if (camundaObject.getEvents() != null && !camundaObject.getEvents().isEmpty())
			setEventsDetails(camundaObject.getEvents(), camundaObject);




		File file;
		try {
			file = File.createTempFile("bpmn-model-api-", ".bpmn",
					new File("/home/tanmaynaik/Documents/Camunda-FluentApi"));
			Bpmn.writeModelToFile(file, processBuilder.done());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void setGatewayDetails(List<Gateway> gatewayList) {
		// TODO Auto-generated method stub
		gatewayList.forEach(gateway -> {
			if (gateway.getType().equalsIgnoreCase("ExclusiveGateway")) {
				exclusiveGatewayBuilder.id(gateway.getId());
			}
		});
	}

	private void setSequenceFlowDetails(List<SequenceFlow> sequenceFlow) {
		// TODO Auto-generated method stub

	}

	private void setTasksDetails(Task task,CamundaObject camundaObject) {
		// TODO Auto-generated method stub

		userTaskBuilder = startEventBuilder.userTask().id(task.getId()).name(task.getName()).camundaAssignee(task.getAssigneTaskToAssignee())
				.camundaFormKey(task.getUserTaskFormKey());
		setUserTaskForms(task);

	}

	private void setUserTaskForms(Task task) {
		// TODO Auto-generated method stub
		task.getForms().forEach(userTaskForm->{
			userTaskBuilder.camundaFormField().camundaId(userTaskForm.getId())
			.camundaLabel(userTaskForm.getLabel())
			.camundaType(userTaskForm.getType())
			.camundaFormFieldDone();
		});
	}

	private void setEventsDetails(List<Event> events, CamundaObject camundaObject) {
		// TODO Auto-generated method stub
		events.forEach(event -> {
			if (event.getType().equalsIgnoreCase("StartEvent")) {
				startEvent(event, camundaObject);
			}
			// else if (event.getType().equalsIgnoreCase("EndEvent")) { //TODO
			//				endEvent(event);
			//			}
		});
	}

	private void endEvent(Event endEvent,  String sourceReference) {
		// TODO Auto-generated method stub
		//		processBuilder.endEvent().id(endEvent.getId()).name(endEvent.getName());
		//userTaskBuilder.connectTo(endEvent.getId());
	}

	private void startEvent(Event startEvent, CamundaObject camundaObject) {
		// TODO Auto-generated method stub
		startEventBuilder = processBuilder.startEvent().id(startEvent.getId()).name(startEvent.getName());
		setStartEventForms(startEvent, camundaObject);
		//SequenceFLow list - > current event/procress/task id ma5tch with souuurce od SF
		getNextProcess(startEvent.getId(), camundaObject);

	}

	private void getNextProcess(String id, CamundaObject camundaObject) {
		List<SequenceFlow> listOfSequence = camundaObject.getSequenceFlow().stream().filter(sequenceFlow-> sequenceFlow.getSourceRef().equals(id))
				.collect(Collectors.toList());
		if(listOfSequence!=null && !listOfSequence.isEmpty()) {
			listOfSequence.forEach(sequence->{
				startEventBuilder.sequenceFlowId(sequence.getId());
				if(sequence.getTargetRef().startsWith("userTask_")) {
					//TODO
					Task userTask =  camundaObject.getTasks().stream().filter(task-> task.getId().equals(sequence.getTargetRef()))
							.findAny()
							.orElse(null);
					setTasksDetails(userTask, camundaObject);

				}
				else if(sequence.getTargetRef().startsWith("ExclusiveGateway__")) {
					//TODO
				}
				else if(sequence.getTargetRef().startsWith("EndEvent_")) {
					//TODO
					Event endEvents =  camundaObject.getEvents().stream().filter(endEvent-> endEvent.getId().equals(sequence.getTargetRef()))
							.findAny()
							.orElse(null);
					endEvent(endEvents,sequence.getSourceRef());
				}
				if(sequence.getTargetRef()!=null) 
				getNextProcess(sequence.getTargetRef(), camundaObject);
				
			});
		}
	}

	private void setStartEventForms(Event startEvent, CamundaObject camundaObject) {
		startEventBuilder.camundaFormKey(startEvent.getFormKey()).id(startEvent.getId()).name(startEvent.getName());
		if (!startEvent.getForms().isEmpty() && startEvent.getForms() != null) {
			startEvent.getForms().forEach(forms -> {
				startEventBuilder.camundaFormField().camundaId(forms.getId()).camundaType(forms.getType())
				.camundaLabel(forms.getLabel());
			});
			startEventBuilder.camundaFormField().camundaFormFieldDone();

		}

	}

	private void setProcessDetails(ProcessName processName) {
		// TODO Auto-generated method stub
		processBuilder = Bpmn.createExecutableProcess(processName.getId()).name(processName.getName());

	}

}
