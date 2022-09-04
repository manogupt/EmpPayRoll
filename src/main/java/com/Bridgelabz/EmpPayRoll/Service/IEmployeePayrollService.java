package com.Bridgelabz.EmpPayRoll.Service;


import java.util.List;

import com.Bridgelabz.EmpPayRoll.Dto.EmployeePayrollDto;
import com.Bridgelabz.EmpPayRoll.Model.EmployeePayrollModel;
import com.Bridgelabz.EmpPayRoll.Util.Response;

public interface IEmployeePayrollService {
	
	String start();

	EmployeePayrollModel getEmployeeById(long id);

//	EmployeePayrollModel createEmp(EmployeePayrollModel emp);

	EmployeePayrollModel update(EmployeePayrollModel emp, long id);

	EmployeePayrollModel delete(long id);

	Response login(String email, String pwd);

	List<EmployeePayrollModel> getlist();

	EmployeePayrollModel createEmp(EmployeePayrollDto emp);

	EmployeePayrollModel getempbytoken(String token);

	void sendmail(long id);



}