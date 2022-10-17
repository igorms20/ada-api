package com.ada.exception;

public class ExistingMovieException extends RuntimeException {

	public ExistingMovieException() {
		super("Esse filme já existe");
	}

	public ExistingMovieException(String message) {
		super(message);
	}

}
