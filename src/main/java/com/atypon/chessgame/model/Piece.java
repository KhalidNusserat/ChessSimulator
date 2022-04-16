package com.atypon.chessgame.model;

public record Piece(PieceType type, Color color) {
    public static Piece getWhite(PieceType type) {
        return new Piece(type, Color.WHITE);
    }

    public static Piece getBlack(PieceType type) {
        return new Piece(type, Color.BLACK);
    }

    @Override
    public String toString() {
        String pieceColor = (color == Color.WHITE ? "W" : "B");
        String pieceType = "";
        switch (type) {
            case KING -> pieceType = "K";
            case PAWN -> pieceType = "P";
            case ROOK -> pieceType = "R";
            case QUEEN -> pieceType = "Q";
            case BISHOP -> pieceType = "B";
            case KNIGHT -> pieceType = "N";
        }
        return pieceColor + pieceType;
    }
}
