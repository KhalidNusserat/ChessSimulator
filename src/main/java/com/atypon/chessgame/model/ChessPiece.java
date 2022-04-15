package com.atypon.chessgame.model;

public record ChessPiece(ChessPieceType type, ChessColor color) {
    public static ChessPiece getWhite(ChessPieceType type) {
        return new ChessPiece(type, ChessColor.WHITE);
    }

    public static ChessPiece getBlack(ChessPieceType type) {
        return new ChessPiece(type, ChessColor.BLACK);
    }
}
