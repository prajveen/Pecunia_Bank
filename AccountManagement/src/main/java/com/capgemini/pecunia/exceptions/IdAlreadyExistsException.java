package com.capgemini.pecunia.exceptions;

@SuppressWarnings("serial")
public class IdAlreadyExistsException extends Exception {
	public  IdAlreadyExistsException(String errorMsg){
		super(errorMsg);
	}
}
