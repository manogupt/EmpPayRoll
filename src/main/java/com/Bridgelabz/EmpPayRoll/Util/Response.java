package com.Bridgelabz.EmpPayRoll.Util;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Response {
	
    public Response(String string, int i, String token2) {
		// TODO Auto-generated constructor stub
    	this.message=string;
    	this.errorCode=i;
    	this.token =token2;
	}
	private String message;
    private int errorCode;
    private Object token;
}