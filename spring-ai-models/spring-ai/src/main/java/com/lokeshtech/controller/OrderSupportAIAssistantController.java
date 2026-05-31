package com.lokeshtech.controller;

import com.lokeshtech.service.OrderSupportAIAssistantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderSupportAIAssistantController {

    public OrderSupportAIAssistantController(OrderSupportAIAssistantService orderSupportAIAssistantService) {
        this.orderSupportAIAssistantService = orderSupportAIAssistantService;
    }

    private OrderSupportAIAssistantService orderSupportAIAssistantService;

    @GetMapping("/order-support")
    public String getOrderSupport(@RequestParam String customerName, String orderId, String customerMessage){
        return orderSupportAIAssistantService.assistWithOrderSupport(customerName, orderId, customerMessage);
    }
}
