package com.atypon.chessgame.model;

public record BoardPosition(String position) {
    public static BoardPosition at(String position) {
        return new BoardPosition(position);
    }
}
