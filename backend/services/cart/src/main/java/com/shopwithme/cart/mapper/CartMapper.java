package com.shopwithme.cart.mapper;

import com.shopwithme.cart.dto.response.CartItemResponseDto;
import com.shopwithme.cart.dto.response.CartResponseDto;
import com.shopwithme.cart.entity.Cart;
import com.shopwithme.cart.entity.CartItem;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class CartMapper {

    public CartResponseDto toCartResponseDto(Cart cart) {
        List<CartItemResponseDto> itemDtos = cart.getItems()
                .stream()
                .map(this::toCartItemResponseDto)
                .toList();

        BigDecimal totalPrice = itemDtos.stream()
                .map(CartItemResponseDto::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return CartResponseDto.builder()
                .cartId(cart.getId())
                .userId(cart.getUserId())
                .status(cart.getStatus().name())
                .items(itemDtos)
                .totalPrice(totalPrice)
                .createdAt(cart.getCreatedAt())
                .updatedAt(cart.getUpdatedAt())
                .build();
    }

    public CartItemResponseDto toCartItemResponseDto(CartItem item) {
        BigDecimal subtotal = item.getPrice()
                .multiply(BigDecimal.valueOf(item.getQuantity()));

        return CartItemResponseDto.builder()
                .id(item.getId())
                .productId(item.getProductId())
                .productName(item.getProductName())
                .price(item.getPrice())
                .quantity(item.getQuantity())
                .subtotal(subtotal)
                .build();
    }
}