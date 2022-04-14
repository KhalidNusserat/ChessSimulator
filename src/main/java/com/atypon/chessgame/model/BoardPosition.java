package com.atypon.chessgame.model;

public record BoardPosition(String position) {
    public BoardPosition(String position) {
        if (position.matches("^[a-hA-H][1-8]$")) {
            this.position = position;
        }
        else {
            throw new IllegalArgumentException(position + " is not a valid chess position.");
        }
    }

    public static BoardPosition at(String position) {
        return new BoardPosition(position);
    }
}
