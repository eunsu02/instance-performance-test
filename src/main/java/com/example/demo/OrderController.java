package com.example.demo;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public ResponseEntity<String> order(
            @RequestParam(defaultValue = "io") String mode,
            @RequestParam(defaultValue = "200") int delayMs
    ) {
        long start = System.currentTimeMillis();

        orderService.process(mode, delayMs);

        long latency = System.currentTimeMillis() - start;
        return ResponseEntity.ok("OK (" + latency + " ms)");
    }
}
