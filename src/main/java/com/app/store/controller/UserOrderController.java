package com.app.store.controller;

import com.app.store.entity.Order;

import com.app.store.entity.User;
import com.app.store.repository.UserRepository;
import com.app.store.service.OrderLifecycleService;
import com.app.store.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.store.entity.OrderItem;
import com.app.store.entity.ProductVariant;
import com.app.store.service.CartService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user/orders")
@RequiredArgsConstructor
public class UserOrderController {

    private final OrderService orderService;
    private final OrderLifecycleService orderLifecycleService;
    private final CartService cartService;
    private final UserRepository userRepository;

    private User getAuthenticatedUser(Principal principal) {
        if (principal == null)
            return null;
        return userRepository.findByEmail(principal.getName()).orElse(null);
    }
}
