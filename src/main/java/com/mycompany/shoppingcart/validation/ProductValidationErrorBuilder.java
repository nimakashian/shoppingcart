package com.mycompany.shoppingcart.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class ProductValidationErrorBuilder {

    public static ProductValidationError fromBindingErrors(Errors errors) {

        ProductValidationError error = new ProductValidationError("Validation " +
                "failed. " + errors.getErrorCount() + " error(s)");
        for (ObjectError objectError : errors.getAllErrors()) {
            error.addValidationError(objectError.getDefaultMessage());
        }
        return error;
    }
}
