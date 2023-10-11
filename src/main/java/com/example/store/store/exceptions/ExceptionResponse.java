package com.example.store.store.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ExceptionResponse
{
    private boolean error;
    private String message;
    private LocalDateTime localDateTime;
}