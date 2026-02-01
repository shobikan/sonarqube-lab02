package com.example;

public class Calculator {

    public int calculate(int a, int b, String op) {
        if (op == null) {
            throw new IllegalArgumentException("Operator cannot be null");
        }

        switch (op) {
            case "add":
                return add(a, b);
            case "sub":
                return a - b;
            case "mul":
                return a * b;
            case "div":
                return divide(a, b);
            case "mod":
                return a % b;
            case "pow":
                return pow(a, b);
            default:
                throw new IllegalArgumentException("Unsupported operator: " + op);
        }
    }

    public int add(int x, int y) {
        return x + y;
    }

    private int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero");
        }
        return a / b;
    }

    private int pow(int a, int b) {
        if (b < 0) {
            throw new IllegalArgumentException("Exponent must be non-negative");
        }
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }
}