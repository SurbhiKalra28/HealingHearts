package com.surbhikalra.healinghearts.service;

import com.surbhikalra.healinghearts.model.Appointment;
import com.surbhikalra.healinghearts.model.Cart;
import com.surbhikalra.healinghearts.model.Merchandise;
import com.surbhikalra.healinghearts.model.User;
import com.surbhikalra.healinghearts.repository.CartRepository;
import com.surbhikalra.healinghearts.repository.MerchandiseRepository;
import com.surbhikalra.healinghearts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private MerchandiseRepository merchandiseRepository;

    @Autowired
    private UserRepository userRepository;

    public void saveCart(Cart cart) {
        cartRepository.save(cart);
    }
}