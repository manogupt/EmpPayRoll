package com.Bridgelabz.EmpPayRoll.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    
    public EmployeePayrollModel(EmployeePayrollDto employeePayrollDto) {

    	this.name=employeePayrollDto.getName();
    	this.salary=employeePayrollDto.getSalary();
    	this.emailId=employeePayrollDto.getEmailId();
    	this.pwd=employeePayrollDto.getpw();
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
	public long getEmployeeID() {
		return employeeID;
	}


	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}
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
	public EmployeePayrollModel() {
		super();
	}
//	public EmployeePayrollModel(int i, EmployeePayrollModel emp) {
//		 EmployeePayrollModel emp1 =new  EmployeePayrollModel();
////		 emp1=emp;
////		 this.employeeID=emp.employeeID;
//		 this.name=emp.getName();
//		 this.salary=emp.getSalary();
//		 
//	}

}