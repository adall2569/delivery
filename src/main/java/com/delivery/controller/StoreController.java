package com.delivery.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.domain.StoreDetail;

@RestController
public class StoreController {
    @RequestMapping("")
    public StoreDetail createStore(@RequestBody StoreDetail store) {
        return null;
    }
}
