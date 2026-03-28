package com.shopwithme.cart.repository;

import com.shopwithme.cart.entity.Cart;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, String> {

    Optional<Cart> findByUserId(String userId);

    boolean existsByUserId(String userId);
}
