package com.ahmete.odakiralama.exception;

import lombok.Getter;

@Getter
public class OdaKiralamaException extends RuntimeException {
	private ErrorType errorType;
	public OdaKiralamaException(ErrorType errorType){
		super(errorType.getMessage());
		this.errorType = errorType;
	}
}