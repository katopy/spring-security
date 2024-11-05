package com.spring_security.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class InvalidPasswordException extends RuntimeException{

    private String message;
}
