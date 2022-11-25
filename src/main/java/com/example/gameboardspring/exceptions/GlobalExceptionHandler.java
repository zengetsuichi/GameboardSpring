package com.example.gameboardspring.exceptions;

import com.example.gameboardspring.model.Node;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Set;
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(com.example.gameboardspring.exceptions.IllegalMoveException.class)
    public ResponseEntity handleIllegalMoveException(IllegalMoveException exc) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new IllegalMoveException("WRONG_PARAMETERS", exc.getMissingFields()));
    }

    //MethodArgumentNotValidException

    @Value
    static class IllegalMoveException {
        private String code;
        private Set<Node> missingFields;
    }
}
