package io.github.artsiomdavidovich.meinbon.exception_handling;

import io.github.artsiomdavidovich.meinbon.exception_handling.custom_exceptions.ObjectNotFoundException;
import io.github.artsiomdavidovich.meinbon.exception_handling.custom_exceptions.ReceiptNotFoundOrDoesntBelongToUserException;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Hidden
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<Response> handleException(ObjectNotFoundException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ReceiptNotFoundOrDoesntBelongToUserException.class)
    public ResponseEntity<Response> handleException(ReceiptNotFoundOrDoesntBelongToUserException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
