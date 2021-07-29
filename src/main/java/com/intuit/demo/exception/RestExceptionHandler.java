package com.intuit.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

   
   @ExceptionHandler(CustomException.class)
   protected ResponseEntity<Object> handleHttpMessageNotReadable(CustomException error) {
       return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error.getMessage(), "Some Error Occured"));
   }

   private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
       return new ResponseEntity<>(apiError, apiError.getStatus());
   }


}