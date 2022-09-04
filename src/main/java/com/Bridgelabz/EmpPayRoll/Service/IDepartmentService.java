package com.Bridgelabz.EmpPayRoll.Service;

import java.util.List;

import com.Bridgelabz.EmpPayRoll.Dto.DepartmentDto;
import com.Bridgelabz.EmpPayRoll.Model.Department;

public interface IDepartmentService {
	Department addDepartment(DepartmentDto departmentDTO);

	Department getDepartmentByToken(String token);

	List<Department> getDepartments();

	Department update(long id, DepartmentDto departmentDto);
}