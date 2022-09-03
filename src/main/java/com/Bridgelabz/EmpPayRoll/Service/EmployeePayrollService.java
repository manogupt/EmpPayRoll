package com.Bridgelabz.EmpPayRoll.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bridgelabz.EmpPayRoll.Exception.EmployeeNotFoundException;
import com.Bridgelabz.EmpPayRoll.Model.EmployeePayrollModel;
import com.Bridgelabz.EmpPayRoll.Repository.IEmployeePayrollRepository;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
	
	
	private List<EmployeePayrollModel> empList = new ArrayList<>();
	@Autowired
	IEmployeePayrollRepository repo;

	@Override
	public String start() {

		return "Hello to Uc1";
	}
	
//	public List<EmployeePayrollModel> getEmployeeData(){
//		return empList;
//		
//	}
	@Override
	public EmployeePayrollModel getEmployeeById(long id) {
		
		Optional<EmployeePayrollModel> emp = repo.findById(id);
		if (emp.isPresent()) 
		return empList.get((int)id-1);		
			throw new EmployeeNotFoundException(400,"emp not present");
	}

	@Override
	public EmployeePayrollModel createEmp(EmployeePayrollModel emp) {
		EmployeePayrollModel emp1 = null;
		emp1=new EmployeePayrollModel(empList.size()+1,emp);
		empList.add(emp1);
		return emp1; 
//		repo.save(emp);
//		return emp;
	}

	@Override
	public EmployeePayrollModel update(EmployeePayrollModel emp, long id) {
		Optional<EmployeePayrollModel> emp1 =repo.findById(id);
		if(emp1.isPresent()) {
			emp1.get().setName(emp.getName());
			emp1.get().setSalary(emp.getSalary());
			empList.set((int)id-1,emp1.get());
			return emp1.get();
		}
		throw new EmployeeNotFoundException(400,"Employee Not Present!!");
//		Optional<EmployeePayrollModel> emp2 = repo.findById(id);
//		emp2.get().setName(emp.getName());
//		emp2.get().setSalary(emp.getSalary());
//		repo.save(emp2.get());
//		return emp2.get();
	}

	@Override
	public void deleteFromList(long id) {
		if (empList.size() > 0)
			empList.remove((int)id-1); 
        else
            throw new EmployeeNotFoundException(400, "No DATA Present");
	}
	@Override
	 public List<EmployeePayrollModel> getAll() {	
               return empList;
	}
	
	@Override
	public EmployeePayrollModel delete(long id) {

		Optional<EmployeePayrollModel> emp = repo.findById(id);
		if(emp.isPresent()) {
			empList.remove((int)id-1);
		//	repo.delete(emp.get());
			return emp.get();
		}
		throw new EmployeeNotFoundException(400,"Employee Not Present");
	}
}