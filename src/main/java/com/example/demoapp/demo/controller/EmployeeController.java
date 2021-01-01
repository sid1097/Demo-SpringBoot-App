package com.example.demoapp.demo.controller;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoapp.demo.model.Employee;
import com.example.demoapp.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5884226646004135176L;
	
	@Autowired
	EmployeeService empService;
	
	@RequestMapping(value = {"/getAllEmployee/{id}","/getAllEmployee"}, method = RequestMethod.GET)
	public ResponseEntity<Object> getAllEmployee(
			@RequestParam(value = "id", required = false) Optional<Integer> id,
			@PathVariable(value = "id", required = false) Optional<Integer> idP){
		
		try {
			if(id.isPresent()) {
				return new ResponseEntity<Object>(empService.getAllEmployess(id.get().intValue()), HttpStatus.OK);
			}else if(idP.isPresent()) {
				return new ResponseEntity<Object>(empService.getAllEmployess(idP.get().intValue()), HttpStatus.OK);
			}
			else
				return new ResponseEntity<Object>(empService.getAllEmployess(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ResponseEntity<Object> getAllEmployee(@RequestBody Employee emp){
		
		int status = empService.addEmployee(emp);
		
		if(status==1)
			return new ResponseEntity<Object>("Record Added Successfully.", HttpStatus.CREATED);
		else
			return new ResponseEntity<Object>("Internal Error Occured", HttpStatus.BAD_REQUEST);
		
	}

}
