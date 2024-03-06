package com.evcharging.station.GlobalExceptionHandler;

import com.evcharging.station.RuntimeException.ResourceAlreadyExist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceAlreadyExist.class)
    public ResponseEntity<Map<String,String>> alreadyExist(ResourceAlreadyExist ex) {
        String resource = ex.getResource();
        String message = ex.getMessage();
        Map<String, String> mp = new HashMap<>();
        mp.put("Error", resource + " " + message);
        return new ResponseEntity<Map<String, String>>(mp, HttpStatus.FORBIDDEN);
    }
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String,String>>HandleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
//        Map<String,String> resp=new HashMap<String,String>();
//        ex.getBindingResult().getAllErrors().forEach(e->{
//            String field=((fielderror)e).getField();
//            String defaultMessage=e.getDefaultMessage();
//            resp.put(field,defaultMessage);
//        });
//
//        return null;
//
//    }

}
