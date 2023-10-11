package com.example.store.store.controllers;

import com.example.store.store.exceptions.ExceptionResponse;
import com.example.store.store.exceptions.ServiceException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionWrapper
{
    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponse> exceptionHandler(ServiceException serviceException)
    {
        ExceptionResponse exceptionResponse = new ExceptionResponse();

        exceptionResponse.setError(true);
        exceptionResponse.setMessage("Not Found");
        exceptionResponse.setLocalDateTime(LocalDateTime.now());

        return ResponseEntity.badRequest().body(exceptionResponse);
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static ResponseEntity<ExceptionResponse> exceptionHandler(ConstraintViolationException constraintViolationException)
    {
        ExceptionResponse exceptionResponse = new ExceptionResponse();

        exceptionResponse.setError(true);
        exceptionResponse.setLocalDateTime(LocalDateTime.now());

        exceptionResponse.setMessage("The Field Must Not Be Null...!");

        return ResponseEntity.badRequest().body(exceptionResponse);
    }

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static ResponseEntity<ExceptionResponse> exceptionHandler(SQLIntegrityConstraintViolationException exception)
    {
        ExceptionResponse exceptionResponse = new ExceptionResponse();

        exceptionResponse.setError(true);
        exceptionResponse.setLocalDateTime(LocalDateTime.now());

        exceptionResponse.setMessage("Duplicated Data Is Not Allowed...!");

        return ResponseEntity.badRequest().body(exceptionResponse);
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static ResponseEntity<ExceptionResponse> exceptionHandler(IllegalArgumentException exception)
    {
        ExceptionResponse exceptionResponse = new ExceptionResponse();

        exceptionResponse.setError(true);
        exceptionResponse.setLocalDateTime(LocalDateTime.now());

        exceptionResponse.setMessage("Invalid Input Data");

        return ResponseEntity.badRequest().body(exceptionResponse);
    }

    @ExceptionHandler(value = NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static ResponseEntity<ExceptionResponse> exceptionHandler(NullPointerException exception)
    {
        ExceptionResponse exceptionResponse = new ExceptionResponse();

        exceptionResponse.setError(true);
        exceptionResponse.setLocalDateTime(LocalDateTime.now());

        exceptionResponse.setMessage("Invalid Data Cannot Be Null");

        return ResponseEntity.badRequest().body(exceptionResponse);
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static ResponseEntity<ExceptionResponse> exceptionHandler(RuntimeException exception)
    {
        ExceptionResponse exceptionResponse = new ExceptionResponse();

        exceptionResponse.setError(true);
        exceptionResponse.setLocalDateTime(LocalDateTime.now());

        exceptionResponse.setMessage("Unknown Error...!");

        return ResponseEntity.badRequest().body(exceptionResponse);
    }
}