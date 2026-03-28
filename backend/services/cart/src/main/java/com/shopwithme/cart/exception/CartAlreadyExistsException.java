package com.shopwithme.cart.exception;

public class CartAlreadyExistsException extends RuntimeException {

    public CartAlreadyExistsException(String userId) {
        super("Cart already exists for user: " + userId);
    }
}