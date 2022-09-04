package com.Bridgelabz.EmpPayRoll.Dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class EmployeePayrollDto {
//	private long id;
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="name invalid  !!!!!!")
	private String name;
	@Min(value=500,message="Salary in Not Valid..! minimum is 500 ")
	private double salary;
	
    private String emailId;
    private String pwd;
	
//    private DepartmentDto department;
    

}