package com.atypon.chessgame.model;

public record Piece(PieceType type, Color color) {
    public static Piece getWhite(PieceType type) {
        return new Piece(type, Color.WHITE);
    }

    public static Piece getBlack(PieceType type) {
        return new Piece(type, Color.BLACK);
    }
}
