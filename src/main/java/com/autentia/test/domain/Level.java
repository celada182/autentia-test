package com.autentia.test.domain;

public enum Level {
    EASY("Fácil"),
    INTERMEDIATE("Intermedio"),
    HARD("Difícil");

    public String getLevel() {
        return level;
    }

    private String level;

    Level(String level) {
        this.level = level;
    }
}
