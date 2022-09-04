package com.Bridgelabz.EmpPayRoll.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import com.Bridgelabz.EmpPayRoll.Model.EmployeePayrollModel;
import com.Bridgelabz.EmpPayRoll.Util.Response;

@ResponseStatus
public class MethodArgumentNotValidException extends RuntimeException{

	private int statusCode;
	private String statusMessage;

	public MethodArgumentNotValidException(MethodArgumentNotValidException status) {
		super(status);
	//	this.statusCode = status.getCause()
		this.statusMessage = status.getMessage();
	}

	public MethodArgumentNotValidException(int i, String string, Response response) {
		this.statusCode=i;
		this.statusMessage=string;
	}

}