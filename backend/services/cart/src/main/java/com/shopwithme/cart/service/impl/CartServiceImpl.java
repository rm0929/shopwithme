package com.shopwithme.cart.service.impl;

import com.shopwithme.cart.dto.request.AddItemRequestDto;
import com.shopwithme.cart.dto.request.UpdateItemRequestDto;
import com.shopwithme.cart.dto.response.CartResponseDto;
import com.shopwithme.cart.entity.Cart;
import com.shopwithme.cart.entity.CartItem;
import com.shopwithme.cart.exception.CartAlreadyExistsException;
import com.shopwithme.cart.exception.CartItemNotFoundException;
import com.shopwithme.cart.exception.CartNotFoundException;
import com.shopwithme.cart.mapper.CartMapper;
import com.shopwithme.cart.model.CartStatus;
import com.shopwithme.cart.repository.CartItemRepository;
import com.shopwithme.cart.repository.CartRepository;
import com.shopwithme.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

        private final CartRepository cartRepository;
        private final CartItemRepository cartItemRepository;
        private final CartMapper cartMapper;

        @Override
        @Transactional(readOnly = true)
        public CartResponseDto getCartByUserId(String userId) {
                Cart cart = cartRepository.findByUserId(userId)
                                .orElseThrow(() -> new CartNotFoundException(userId));

                return cartMapper.toCartResponseDto(cart);
        }

        @Override
        @Transactional
        public CartResponseDto createCart(String userId) {
                if (cartRepository.existsByUserId(userId)) {
                        throw new CartAlreadyExistsException(userId);
                }

                Cart cart = Cart.builder()
                                .userId(userId)
                                .status(CartStatus.ACTIVE)
                                .build();

                Cart savedCart = cartRepository.save(cart);
                return cartMapper.toCartResponseDto(savedCart);
        }

        @Override
        @Transactional
        public CartResponseDto addItemToCart(String userId, AddItemRequestDto request) {
                Cart cart = cartRepository.findByUserId(userId)
                                .orElseThrow(() -> new CartNotFoundException(userId));

                cartItemRepository.findByCartIdAndProductId(cart.getId(), request.getProductId())
                                .ifPresentOrElse(
                                                existingItem -> existingItem.setQuantity(
                                                                existingItem.getQuantity() + request.getQuantity()),
                                                () -> {
                                                        CartItem newItem = CartItem.builder()
                                                                        .cart(cart)
                                                                        .productId(request.getProductId())
                                                                        .productName(request.getProductName())
                                                                        .price(request.getPrice())
                                                                        .quantity(request.getQuantity())
                                                                        .build();
                                                        cart.getItems().add(newItem);
                                                });

                Cart updatedCart = cartRepository.save(cart);
                return cartMapper.toCartResponseDto(updatedCart);
        }

        @Override
        @Transactional
        public CartResponseDto updateItemQuantity(String userId, String itemId, UpdateItemRequestDto request) {
                Cart cart = cartRepository.findByUserId(userId)
                                .orElseThrow(() -> new CartNotFoundException(userId));

                CartItem item = cartItemRepository.findById(itemId)
                                .orElseThrow(() -> new CartItemNotFoundException(itemId));

                item.setQuantity(request.getQuantity());
                cartRepository.save(cart);

                return cartMapper.toCartResponseDto(cart);
        }

        @Override
        @Transactional
        public void removeItemFromCart(String userId, String itemId) {
                Cart cart = cartRepository.findByUserId(userId)
                                .orElseThrow(() -> new CartNotFoundException(userId));

                CartItem item = cartItemRepository.findById(itemId)
                                .orElseThrow(() -> new CartItemNotFoundException(itemId));

                cart.getItems().remove(item);
                cartRepository.save(cart);
        }

        @Override
        @Transactional
        public void clearCart(String userId) {
                Cart cart = cartRepository.findByUserId(userId)
                                .orElseThrow(() -> new CartNotFoundException(userId));

                cart.getItems().clear();
                cartRepository.save(cart);
        }

        @Override
        @Transactional
        public void deleteCart(String userId) {
                Cart cart = cartRepository.findByUserId(userId)
                                .orElseThrow(() -> new CartNotFoundException(userId));

                cartRepository.delete(cart);
        }
}