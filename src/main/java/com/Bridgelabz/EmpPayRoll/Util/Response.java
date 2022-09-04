package com.Bridgelabz.EmpPayRoll.Util;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Response {
	
    public Response() {
		// TODO Auto-generated constructor stub
	}
	private String message;
    private int errorCode;
    private Object token;
}