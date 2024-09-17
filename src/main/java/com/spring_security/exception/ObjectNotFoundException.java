package com.spring_security.exception;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class ObjectNotFoundException extends RuntimeException {

    private final String message;

}
