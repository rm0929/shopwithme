package com.shopwithme.cart.exception;

public class CartItemNotFoundException extends RuntimeException {

    public CartItemNotFoundException(String itemId) {
        super("Cart item not found with id: " + itemId);
    }
}