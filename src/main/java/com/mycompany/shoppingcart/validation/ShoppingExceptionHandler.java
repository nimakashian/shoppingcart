package com.mycompany.shoppingcart.validation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(basePackages = "com.mycompany.shoppingcart.controller")
public class ShoppingExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ProductValidationError handleError(Exception e) {
        return new ProductValidationError(e.getMessage());
    }

    //TODO other status implementation

}
