package com.Bridgelabz.EmpPayRoll.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import com.Bridgelabz.EmpPayRoll.Model.EmployeePayrollModel;
import com.Bridgelabz.EmpPayRoll.Util.Response;

@ResponseStatus
public class MethodArgumentNotValidException extends RuntimeException{

	private int statusCode;
	private String statusMessage;

	public MethodArgumentNotValidException(int statusCode, String statusMessage) {
		super(statusMessage);
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}

}