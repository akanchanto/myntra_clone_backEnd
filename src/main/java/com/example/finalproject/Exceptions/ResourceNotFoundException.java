package com.example.finalproject.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.function.Supplier;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String fieldName;

    public ResourceNotFoundException(){
        super();
    }
    public ResourceNotFoundException(String message, String fieldName) {
        super(String.format("%s not found with %s: '%s' ", message, fieldName));
        this.fieldName = fieldName;
    }


    public String getFieldName() {
        return fieldName;
    }

}
