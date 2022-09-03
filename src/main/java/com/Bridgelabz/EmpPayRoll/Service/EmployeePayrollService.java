package com.Bridgelabz.EmpPayRoll.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bridgelabz.EmpPayRoll.Model.EmployeePayrollModel;
import com.Bridgelabz.EmpPayRoll.Repository.IEmployeePayrollRepository;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
	@Autowired
	IEmployeePayrollRepository repo;

	@Override
	public String start() {

		return "Hello to Uc1";
	}
	@Override
	public EmployeePayrollModel getEmployeeById(long id) {
		EmployeePayrollModel emp = repo.findById(id).orElse(null);
		return emp;
	}

	@Override
	public EmployeePayrollModel createEmp(EmployeePayrollModel emp) {
		repo.save(emp);
		return emp;
	}

	@Override
	public EmployeePayrollModel update(EmployeePayrollModel emp, long id) {
		Optional<EmployeePayrollModel> emp2 = repo.findById(id);
		emp2.get().setName(emp.getName());
		emp2.get().setSalary(emp.getSalary());
		repo.save(emp2.get());
		return emp2.get();
	}

	@Override
	public EmployeePayrollModel delete(long id) {
		Optional<EmployeePayrollModel> emp = repo.findById(id);
		repo.delete(emp.get());
		return emp.get();
	}
}