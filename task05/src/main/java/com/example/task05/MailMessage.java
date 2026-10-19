package com.example.task05;

public record MailMessage(String from, String to, String content) implements Sendable<String> {
}