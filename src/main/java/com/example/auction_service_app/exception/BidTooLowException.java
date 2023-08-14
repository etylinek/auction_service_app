package com.example.auction_service_app.exception;

public class BidTooLowException extends RuntimeException {
    public BidTooLowException(String message) {
        super(message);
    }
    // Możliwe dodanie innych konstruktorów lub metod, jeśli są potrzebn
}