package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public void process(String mode, int delayMs) {
        if ("cpu".equalsIgnoreCase(mode)) {
            cpuWork(delayMs);
        } else {
            ioWork(delayMs);
        }
    }

    // CPU-bound 시뮬레이션
    private void cpuWork(int delayMs) {
        long end = System.currentTimeMillis() + delayMs;
        double dummy = 0;
        while (System.currentTimeMillis() < end) {
            dummy += Math.sqrt(Math.random());
        }
    }

    // IO-bound 시뮬레이션 (DB 대체)
    private void ioWork(int delayMs) {
        try {
            Thread.sleep(delayMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
