package com.trainsearch.controller;



import java.time.LocalDateTime;



import org.springframework.http.HttpStatus;
 import org.springframework.web.HttpRequestMethodNotSupportedException;
 import org.springframework.web.bind.annotation.ExceptionHandler;
 import org.springframework.web.bind.annotation.RestControllerAdvice;
 import org.springframework.web.client.HttpStatusCodeException;

import com.trainsearch.exception.TrainIdNotFoundException;
import com.trainsearch.models.ErrorResponse;

 @RestControllerAdvice
 public class MyGlobalExceptionHandler {

     @ExceptionHandler(value = {TrainIdNotFoundException.class})
     public ErrorResponse trainidNotFound(TrainIdNotFoundException ex) {
         
         ErrorResponse error=new ErrorResponse();
         error.setStatusmessage(HttpStatus.NOT_FOUND);
         error.setDatetime(LocalDateTime.now());
         error.setMessage(ex.getMessage());
         return error;
         
     }
     
     @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
     public ErrorResponse methodtNotSupport(HttpRequestMethodNotSupportedException ex) {
         
         ErrorResponse error=new ErrorResponse();
         error.setStatusmessage(HttpStatus.METHOD_NOT_ALLOWED);
         error.setDatetime(LocalDateTime.now());
         error.setMessage(ex.getMessage());
         return error;
         
     }
     
     
     @ExceptionHandler(value = {Exception.class})
     public ErrorResponse handleException(Exception ex) {
         
         ErrorResponse error=new ErrorResponse();
         error.setStatusmessage(HttpStatus.BAD_REQUEST);
         error.setDatetime(LocalDateTime.now());
         error.setMessage(ex.getMessage());
         return error;
         
     }
 }