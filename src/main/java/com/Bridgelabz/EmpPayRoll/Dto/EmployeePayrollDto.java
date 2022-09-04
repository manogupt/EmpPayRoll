package com.Bridgelabz.EmpPayRoll.Dto;

import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class EmployeePayrollDto {
//	private long id;
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="name invalid")
	private String name;
	private double salary;
	
    private String emailId;
    private String pwd;
	
//    private DepartmentDto department;
    

}