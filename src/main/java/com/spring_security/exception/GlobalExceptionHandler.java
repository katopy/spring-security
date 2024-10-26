package com.spring_security.exception;


import com.spring_security.dto.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerGenericException(Exception ex, HttpServletRequest req) {

        ApiError apiError = new ApiError();
        apiError.setBackendMessage(ex.getLocalizedMessage());
        apiError.setUrl(req.getRequestURL().toString());
        apiError.setMethod(req.getMethod());
        apiError.setMessage("Error from the internal server");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentValidException(MethodArgumentNotValidException ex, HttpServletRequest req) {

        ApiError apiError = new ApiError();
        apiError.setBackendMessage(ex.getLocalizedMessage());
        apiError.setUrl(req.getRequestURL().toString());
        apiError.setMethod(req.getMethod());
        apiError.setMessage("Error with request");

        System.out.println(ex.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }


}
