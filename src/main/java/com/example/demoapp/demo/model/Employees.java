package com.example.demoapp.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Employees implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7924063734325631343L;
	
	private List<Employee> employeeList;
	
	public List<Employee> getEmployeeList(){
		if(this.employeeList == null) {
			this.employeeList = new ArrayList<>();
		}
		return this.employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

}
