package com.example.demo;

public record OrderRequest(String symbol, int quantity, long price) {}