package com.Bridgelabz.EmpPayRoll.Dto;

import lombok.Data;


@Data
public class EmployeePayrollDto {
//	private long id;
	private String name;
	private double salary;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

}