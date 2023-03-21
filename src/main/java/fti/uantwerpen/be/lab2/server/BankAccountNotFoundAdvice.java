package fti.uantwerpen.be.lab2.server;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BankAccountNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(BankAccountNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String bankAccountNotFoundHandler(BankAccountNotFoundException exception) {
        return exception.getMessage();
    }
}
