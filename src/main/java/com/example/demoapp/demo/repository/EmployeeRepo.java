package com.example.demoapp.demo.repository;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.example.demoapp.demo.model.Employee;
import com.example.demoapp.demo.model.Employees;

@Repository
public class EmployeeRepo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4710396082228375247L;
	
	private static Employees list = new Employees();
	
	public static Employees getList() {
		return list;
	}

	public static void setList(Employees list) {
		EmployeeRepo.list = list;
	}

	static {
		list.getEmployeeList().add(new Employee(1, "Sajid", "H", "abc@xyz.com", 1234546));
		list.getEmployeeList().add(new Employee(2, "Srinu", "M", "qwe@xyz.com", 100000));
		list.getEmployeeList().add(new Employee(3, "Anshi", "S", "rty@xyz.com", 100001));
		list.getEmployeeList().add(new Employee(4, "Luv", "S", "luv@xyz.com", 100002));
	}
	
	public Employees getAllEmployess() {
		return list;
	}
	
	public void addEmployee(Employee emp) throws Exception{
		try {
			list.getEmployeeList().add(emp);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
}
