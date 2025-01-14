package com.surbhikalra.healinghearts.repository;

import com.surbhikalra.healinghearts.model.Cart;
import com.surbhikalra.healinghearts.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findCartByUser(User user);

}