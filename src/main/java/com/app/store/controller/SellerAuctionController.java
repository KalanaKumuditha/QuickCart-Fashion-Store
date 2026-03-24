package com.app.store.controller;

import com.app.store.entity.Auction;
import com.app.store.entity.Bid;
import com.app.store.entity.Product;
import com.app.store.entity.User;
import com.app.store.repository.ProductRepository;
import com.app.store.service.AuctionService;
import com.app.store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.List;

