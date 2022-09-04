package com.Bridgelabz.EmpPayRoll.Dto;

import lombok.Data;

@Data
public class EmployeePayrollDto {
//	private long id;
	private String name;
	private double salary;
	
    private String emailId;
    private String pwd;
	
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}