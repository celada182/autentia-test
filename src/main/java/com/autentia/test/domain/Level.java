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

    public static Level fromString(String text) {
        for (Level b : Level.values()) {
            if (b.level.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new IllegalArgumentException("No constant with value " + text + " found");
    }
}
