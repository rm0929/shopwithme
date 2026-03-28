package com.shopwithme.cart.service;

import com.shopwithme.cart.dto.request.AddItemRequestDto;
import com.shopwithme.cart.dto.request.UpdateItemRequestDto;
import com.shopwithme.cart.dto.response.CartResponseDto;

public interface CartService {

    CartResponseDto getCartByUserId(String userId);

    CartResponseDto createCart(String userId);

    CartResponseDto addItemToCart(String userId, AddItemRequestDto request);

    CartResponseDto updateItemQuantity(String userId, String itemId, UpdateItemRequestDto request);

    void removeItemFromCart(String userId, String itemId);

    void clearCart(String userId);

    void deleteCart(String userId);
}