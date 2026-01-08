package com.example.demo;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public Map<String, Object> placeOrder(@RequestBody OrderRequest request) {
        long startTime = System.currentTimeMillis();

        String status = orderService.processOrder(request);

        long endTime = System.currentTimeMillis();

        Map<String, Object> response = new HashMap<>();
        response.put("status", status);
        response.put("processingTimeMs", (endTime - startTime));
        return response;
    }
}