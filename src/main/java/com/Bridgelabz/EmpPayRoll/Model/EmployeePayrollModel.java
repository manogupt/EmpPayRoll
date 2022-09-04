package com.Bridgelabz.EmpPayRoll.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.Bridgelabz.EmpPayRoll.Dto.DepartmentDto;
import com.Bridgelabz.EmpPayRoll.Dto.EmployeePayrollDto;

import lombok.Data;

@Entity
@Data
public class EmployeePayrollModel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long employeeID;
    private String name;
    private double salary;
    
    private String emailId;
    private String pwd;
    
    @OneToOne
    private Department department;
    
    public EmployeePayrollModel(EmployeePayrollDto employeePayrollDto) {
    	this.name=employeePayrollDto.getName();
    	this.salary=employeePayrollDto.getSalary();
    	this.emailId=employeePayrollDto.getEmailId();
    	this.pwd=employeePayrollDto.getPwd();
//        Department employeeDepartment1=mapDepartment(employeePayrollDto.getDepartment());
 //       this.department=employeeDepartment;
    }

//    public Department mapDepartment(DepartmentDto department) {
//        Department department1=new Department();
//        department1.setDepartmentName(department.getDepartmentName());
//        department1.setDepartmentDescription(department.getDepartmentDesc());
//        return department1;
//    }

	public EmployeePayrollModel() {
		super();
	}

}
	
	
	
	
//	public EmployeePayrollModel(int i, EmployeePayrollModel emp) {
//		 EmployeePayrollModel emp1 =new  EmployeePayrollModel();
//		 emp1=emp;
//		 this.employeeID=emp.employeeID;
//		 this.name=emp.getName();
//		 this.salary=emp.getSalary();
//		 
//	}