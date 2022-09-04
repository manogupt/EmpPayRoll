package com.Bridgelabz.EmpPayRoll.Dto;

import lombok.Data;

@Data
public class DepartmentDto {

    private String departmentName;
    private String departmentDesc;
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentDesc() {
		return departmentDesc;
	}
	public void setDepartmentDesc(String departmentDesc) {
		this.departmentDesc = departmentDesc;
	}
    
}
