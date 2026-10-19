package com.example.task05;

public interface Sendable<T> {
    String from();
    String to();
    T content();
}