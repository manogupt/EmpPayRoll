package com.Bridgelabz.EmpPayRoll.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bridgelabz.EmpPayRoll.Dto.DepartmentDto;
import com.Bridgelabz.EmpPayRoll.Exception.EmployeeNotFoundException;
import com.Bridgelabz.EmpPayRoll.Model.Department;
import com.Bridgelabz.EmpPayRoll.Model.EmployeePayrollModel;
import com.Bridgelabz.EmpPayRoll.Repository.IDepartmentRepository;
import com.Bridgelabz.EmpPayRoll.Repository.IEmployeePayrollRepository;
import com.Bridgelabz.EmpPayRoll.Util.TokenUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService implements IDepartmentService{

    @Autowired
    IDepartmentRepository departmentRepo;
    
    @Autowired
    IEmployeePayrollRepository empRepo;
    
	@Autowired
	TokenUtil tokenUtil;
	
	 @Override
	    public Department addDepartment(DepartmentDto departmentDto) {
	        Department department=new Department();
	        department.setDepartmentName(departmentDto.getDepartmentName());
	        department.setDepartmentDescription(departmentDto.getDepartmentDesc());
//	        department.setCreatedTimeStamp(LocalDateTime.now());
	        departmentRepo.save(department);
	        return department;
	    }

	@Override
	public Department getDepartmentByToken(String token) {
		long id = tokenUtil.decodeToken(token);
		Optional<EmployeePayrollModel> isEmpPresent = empRepo.findById(id);
		if(isEmpPresent.isPresent()) {
			return isEmpPresent.get().getDepartment();
		}
		throw new EmployeeNotFoundException(100,"no data");
	}

	@Override
	public List<Department> getDepartments() {
		List<Department> list = departmentRepo.findAll();
		if(!list.isEmpty())
			return list;
		log.info("No Department Present");
		return null;
	}
}