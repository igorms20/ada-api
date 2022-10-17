package com.ada.advice;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ada.exception.ExistingMovieException;
import com.ada.exception.MovieNotFoundException;
import com.ada.response.ExceptionDetails;

@RestControllerAdvice
public class Advice {

//	@ExceptionHandler(ExistingMovieException.class)
//	public ResponseEntity<ExceptionResponse> existingMovieHandler() {
//		return new ResponseEntity<ExceptionResponse>(new ExceptionResponse(LocalDateTime.now(), 400, "Bad Request",
//				new ExistingMovieException().getMessage()), HttpStatus.BAD_REQUEST);
//	}

	@ExceptionHandler(ExistingMovieException.class)
	public ResponseEntity<ExceptionDetails> existingMovieHandler(ExistingMovieException e) {
		return new ResponseEntity<ExceptionDetails>(
				new ExceptionDetails(LocalDateTime.now(), 400, "Bad Request", e.getMessage()),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MovieNotFoundException.class)
	public ResponseEntity<ExceptionDetails> movieNotFoundHandler(MovieNotFoundException e) {
		return new ResponseEntity<ExceptionDetails>(
				new ExceptionDetails(LocalDateTime.now(), 404, "Not Found", e.getMessage()),
				HttpStatus.NOT_FOUND);

	}

}
