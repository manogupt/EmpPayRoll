package com.Bridgelabz.EmpPayRoll.Service;


import com.Bridgelabz.EmpPayRoll.Model.EmployeePayrollModel;

public interface IEmployeePayrollService {
	
	String start();

	EmployeePayrollModel getEmployeeById(long id);

	EmployeePayrollModel createEmp(EmployeePayrollModel emp);

	EmployeePayrollModel update(EmployeePayrollModel emp, long id);

	EmployeePayrollModel delete(long id);

}