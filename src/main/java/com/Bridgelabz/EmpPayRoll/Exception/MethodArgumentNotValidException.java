package com.Bridgelabz.EmpPayRoll.Exception;


import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class MethodArgumentNotValidException extends RuntimeException{

	private int statusCode;
	private String statusMessage;

	public MethodArgumentNotValidException(MethodArgumentNotValidException status) {
		super(status);
	//	this.statusCode = status.getCause()
		this.statusMessage = status.getMessage();
	}

}