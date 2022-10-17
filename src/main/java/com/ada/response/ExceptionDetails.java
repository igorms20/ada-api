package com.ada.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionDetails {
	
	private LocalDateTime timestamp;
	private int status;
	private String error;
	private String message;
}
