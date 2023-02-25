package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmpRepo;

@Service
public class EmpService {
	
	@Autowired
	private EmpRepo repo;
	
	public void addEmp(Employee e) {
		repo.save(e);
		
	}
	
	public void deleteEmp(int id) {
		repo.deleteById(id);
		
	}
	/*
	 * public void updateEmp(Employee e) { Employee emp =
	 * repo.findById(e.getId()).get(); emp.setId(e.getId());
	 * emp.setName(e.getName()); emp.setEmail(e.getEmail());
	 * emp.setPhone(e.getPhone()); emp.setSalary(e.getSalary());
	 * 
	 * repo.save(emp);
	 * 
	 * }
	 */
	
	public List<Employee> getAllEmp(){
		return repo.findAll();
		
	}
	
	public Employee getEmpById(int id) {
		Optional<Employee> e = repo.findById(id);
		if(e.isPresent()) {
			return e.get();
		}else {
			return null;
		}
	}

}
