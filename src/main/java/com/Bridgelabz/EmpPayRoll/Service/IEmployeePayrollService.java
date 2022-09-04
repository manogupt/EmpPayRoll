package com.Bridgelabz.EmpPayRoll.Service;


import java.util.List;

import com.Bridgelabz.EmpPayRoll.Dto.EmployeePayrollDto;
import com.Bridgelabz.EmpPayRoll.Model.EmployeePayrollModel;
import com.Bridgelabz.EmpPayRoll.Util.Response;

public interface IEmployeePayrollService {
	
	String start();

	EmployeePayrollModel getEmployeeById(long id);

//	EmployeePayrollModel createEmp(EmployeePayrollModel emp);

//	EmployeePayrollModel update(EmployeePayrollModel emp, long id);

	EmployeePayrollModel delete(long id);

	Response login(String email, String pwd);

	EmployeePayrollModel createEmp(EmployeePayrollDto emp, Long department_id);

	void sendMail(long id);

	EmployeePayrollModel getEmpByToken(String token);

	List<EmployeePayrollModel> getList();

	EmployeePayrollModel updateWithToken(String token);

	EmployeePayrollModel deleteWithToken(String token);

//	EmployeePayrollModel update(EmployeePayrollModel emp, long empId, long deptId);

	EmployeePayrollModel update(EmployeePayrollDto emp, long empId, long deptId);

	EmployeePayrollModel updateDepartmentWithToken(EmployeePayrollDto emp, String token, long deptId);

		List<EmployeePayrollModel> getByContent(String content);



}