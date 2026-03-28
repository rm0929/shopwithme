package com.shopwithme.cart.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartResponseDto {

    private String cartId;
    private String userId;
    private String status;
    private List<CartItemResponseDto> items;
    private BigDecimal totalPrice; // sum of all item subtotals, calculated in service
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}