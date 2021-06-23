package com.company;

public enum DemoOptions {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3);

    private final int number;

    DemoOptions (int number) {
        this.number = number;
    }

    public int getNumber () {
        return this.number;
    }
}
