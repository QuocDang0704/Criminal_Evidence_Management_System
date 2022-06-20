package com.FIS.Quocdb.util;

public enum Rank {
    TRAINEE(1),
    JUNIOR(2),
    SENIOR(3),
    INSPECTOR(4),
    CHIEF_INSPECTOR(5);

    private final int value;

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
