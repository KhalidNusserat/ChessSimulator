package com.atypon.chessgame;

public record BoardPosition(String position) {
    public static BoardPosition at(String position) {
        return new BoardPosition(position);
    }
}
