package fis.quocdb3.controller;

import fis.quocdb3.config.exception.ErrorMessager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandlder extends ResponseEntityExceptionHandler {
    @ExceptionHandler(
            value = IllegalArgumentException.class
    )
    public ResponseEntity<ErrorMessager> handleNotFoundException(
            Exception exception
    ) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorMessager.builder()
                        .code("INTERNAL_SERVER_ERROR")
                        .messager(exception.getMessage())
                        .build()
                );
    }

    @ExceptionHandler(
            value = Exception.class
    )
    public ResponseEntity<ErrorMessager> handleException(
            Exception exception
    ) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorMessager.builder()
                        .code("INTERNAL_SERVER_ERROR")
                        .messager(exception.getMessage())
                        .build()
                );
    }
}
