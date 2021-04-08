package ru.shein.dmitriy.handbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.shein.dmitriy.handbook.entity.Response;

@ControllerAdvice
public class PersonExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Response> PersonNotFound(NullPointerException e){
        Response response = new Response("Person not found");
        return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
    }
}
