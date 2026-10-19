package com.example.task05;

public record Salary(String from, String to, Integer content) implements Sendable<Integer> {
}