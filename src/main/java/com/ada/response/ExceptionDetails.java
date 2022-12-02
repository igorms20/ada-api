package com.ada.response;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(content = Include.NON_EMPTY)
public class ExceptionDetails {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private List<Field> fieldErrors;
    
}
