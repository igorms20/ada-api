package com.ada.advice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ada.exception.ExistingMovieException;
import com.ada.exception.MovieNotFoundException;
import com.ada.response.ExceptionDetails;
import com.ada.response.Field;

@ControllerAdvice
public class Advice extends ResponseEntityExceptionHandler {

//	@ExceptionHandler(ExistingMovieException.class)
//	public ResponseEntity<ExceptionResponse> existingMovieHandler() {
//		return new ResponseEntity<ExceptionResponse>(new ExceptionResponse(LocalDateTime.now(), 400, "Bad Request",
//				new ExistingMovieException().getMessage()), HttpStatus.BAD_REQUEST);
//	}

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<Field> fields = new ArrayList<>();

        ExceptionDetails body = new ExceptionDetails(LocalDateTime.now(),
                status.value(),
                "MethodArgumentNotValid",
                "Algum campo está inválido",
                fields);

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        for (FieldError fieldError : fieldErrors) {
            String fieldName = fieldError.getField();
            String defaultMessage = fieldError.getDefaultMessage();

            fields.add(new Field(fieldName, defaultMessage));
        }

        return handleExceptionInternal(ex, body, null, status, request);
    }

    @ExceptionHandler(ExistingMovieException.class)
    public ResponseEntity<Object> existingMovieHandler(ExistingMovieException ex, HttpStatus status,
            WebRequest request) {

        ExceptionDetails body = new ExceptionDetails(LocalDateTime.now(),
                status.value(),
                "Bad Request",
                ex.getMessage(),
                null);

        return new ResponseEntity<Object>(body, HttpStatus.BAD_REQUEST);
//        return handleExceptionInternal(ex, body, null, status, request);
    }

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<Object> movieNotFoundHandler(MovieNotFoundException ex, HttpStatus status,
            WebRequest request) {

        ExceptionDetails body = new ExceptionDetails(LocalDateTime.now(),
                status.value(),
                "Not Found",
                ex.getMessage(),
                null);

        return new ResponseEntity<Object>(body, status);
//        return handleExceptionInternal(ex, body, HttpHeaders.EMPTY, status, request);

    }

}
