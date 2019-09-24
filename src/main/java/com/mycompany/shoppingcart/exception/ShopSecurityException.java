package com.mycompany.shoppingcart.exception;

public class ShopSecurityException extends Exception {
    public ShopSecurityException(String s) {
    }

    public ShopSecurityException() {
        super();
    }

    public ShopSecurityException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShopSecurityException(Throwable cause) {
        super(cause);
    }

    protected ShopSecurityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
