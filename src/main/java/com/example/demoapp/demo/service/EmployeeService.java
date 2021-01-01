package com.example.demoapp.demo.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoapp.demo.model.Employee;
import com.example.demoapp.demo.repository.EmployeeRepo;

@Service
public class EmployeeService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2580447059599047711L;
	
	@Autowired
	EmployeeRepo empRepo;
	
	public List<Employee> getAllEmployess() {
		return empRepo.getAllEmployess().getEmployeeList();
	}
	
	public Employee getAllEmployess(int id) {
		return empRepo.getAllEmployess().getEmployeeList().stream()
				.filter(f->f.getId()==id)
				.findFirst()
				.orElse(null);
	}
	
	public int addEmployee(Employee employee) {
        try {
        	empRepo.addEmployee(employee);
        	return 1;
        }catch(Exception e) {
        	return 0;
        }	
    }
	
}
