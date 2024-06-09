package com.tn.esprit.edtech.handler;

import com.tn.esprit.edtech.exceptions.AlreadyExistException;
import com.tn.esprit.edtech.exceptions.RessourceNotFoundException;
import com.tn.esprit.edtech.exceptions.UsernameNotFoundException;
import com.tn.esprit.edtech.response.ServerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler {
    @ExceptionHandler(value = RessourceNotFoundException.class)
    public ResponseEntity<ServerResponse> notFoundException(RessourceNotFoundException r){
        ServerResponse serverResponse = new ServerResponse(
                HttpStatus.NOT_FOUND.getReasonPhrase() ,
                r.getMessage()
        );
        return new ResponseEntity<ServerResponse>(serverResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = AlreadyExistException.class)
    public ResponseEntity<ServerResponse> alreadyExistException(AlreadyExistException r){
        ServerResponse serverResponse = new ServerResponse(
                HttpStatus.FOUND.getReasonPhrase() ,
                r.getMessage()
        );
        return new ResponseEntity<ServerResponse>(serverResponse, HttpStatus.FOUND);
    }

    @ExceptionHandler(value = UsernameNotFoundException.class)
    public ResponseEntity<ServerResponse> usernameNotFoundException(UsernameNotFoundException r){
        ServerResponse serverResponse = new ServerResponse(
                HttpStatus.NOT_FOUND.getReasonPhrase() ,
                r.getMessage()
        );
        return new ResponseEntity<ServerResponse>(serverResponse, HttpStatus.NOT_FOUND);
    }
}
