package com.example.demo;

import org.springframework.stereotype.Service;
@Service
public class OrderService {
    private long stockInventory = 10_000_000L; // 가상의 종목 잔량

    // synchronized를 통해 한 번에 한 스레드만 접근 가능하게 설정 (병목 유도)
    public synchronized String processOrder(OrderRequest request) {
        // 1. 복잡한 계산 시뮬레이션 (CPU 부하)
        double dummy = 0;
        for (int i = 0; i < 100_000; i++) {
            dummy += Math.sqrt(i);
        }

        try {
            Thread.sleep(100); // 0.1초 대기
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // 2. 주문 처리 (잔량 확인 및 차감)
        if (stockInventory >= request.quantity()) {
            stockInventory -= request.quantity();

            // 3. DB나 외부 API 연산을 시뮬레이션하는 지연 (Network I/O 부하)
            try {
                Thread.sleep(20); // 20ms 지연
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "SUCCESS";
        }



        return "FAIL_INSUFFICIENT_STOCK";
    }
}