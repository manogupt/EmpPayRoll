package com.Bridgelabz.EmpPayRoll.Util;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Response {
	
    private String message;
    private int errorCode;
    private Object token;

    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public Object getToken() {
		return token;
	}

	public void setToken(Object token) {
		this.token = token;
	}

	public Response() {

    }

	public Response(String string, int i) {
		// TODO Auto-generated constructor stub
		this.message=string;
		this.errorCode=i;
	}

	public Response(String string, int i, String token2) {
		this.message=string;
		this.errorCode=i;
		this.token=token2;
	}
}