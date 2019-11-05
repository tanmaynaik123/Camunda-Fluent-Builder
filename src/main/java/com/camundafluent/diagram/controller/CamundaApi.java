package com.camundafluent.diagram.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.camundafluent.diagram.exception.SchemaException;
import com.camundafluent.diagram.interfaces.ICamundaApi;


@RestController
@RequestMapping("/api")
public class CamundaApi {

	@Autowired
	ICamundaApi camundaApi;

	@RequestMapping(value="/draw",method=RequestMethod.POST,consumes = {
	"application/JSON"})
	@ResponseBody
	public String drawDiagramApi(@RequestBody String payload) throws Exception, SchemaException {	

		try {
			
			camundaApi.drawDiagram(payload);
			return "Success";
		}
		catch(SchemaException exception) {

			System.out.println(exception.getMessage());
		}
		return "Failed";
	}

}


