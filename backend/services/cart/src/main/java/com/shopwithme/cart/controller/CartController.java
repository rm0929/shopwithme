package com.shopwithme.cart.controller;

import com.shopwithme.cart.dto.request.AddItemRequestDto;
import com.shopwithme.cart.dto.request.UpdateItemRequestDto;
import com.shopwithme.cart.dto.response.CartResponseDto;
import com.shopwithme.cart.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/{userId}")
    public ResponseEntity<CartResponseDto> getCart(@PathVariable("userId") String userId) {
        CartResponseDto cart = cartService.getCartByUserId(userId);
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<CartResponseDto> createCart(@PathVariable("userId") String userId) {
        CartResponseDto cart = cartService.createCart(userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(cart);
    }

    @PostMapping("/{userId}/items")
    public ResponseEntity<CartResponseDto> addItem(
            @PathVariable("userId") String userId,
            @Valid @RequestBody AddItemRequestDto request) {
        CartResponseDto cart = cartService.addItemToCart(userId, request);
        return ResponseEntity.ok(cart);
    }

    @PutMapping("/{userId}/items/{itemId}")
    public ResponseEntity<CartResponseDto> updateItem(
            @PathVariable("userId") String userId,
            @PathVariable("itemId") String itemId,
            @Valid @RequestBody UpdateItemRequestDto request) {
        CartResponseDto cart = cartService.updateItemQuantity(userId, itemId, request);
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/{userId}/items/{itemId}")
    public ResponseEntity<Void> removeItem(
            @PathVariable("userId") String userId,
            @PathVariable("itemId") String itemId) {
        cartService.removeItemFromCart(userId, itemId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{userId}/items")
    public ResponseEntity<Void> clearCart(@PathVariable("userId") String userId) {
        cartService.clearCart(userId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteCart(@PathVariable("userId") String userId) {
        cartService.deleteCart(userId);
        return ResponseEntity.noContent().build();
    }
}