package com.atypon.chessgame.model;

public record ChessPiece(ChessPieceType type, ChessColor color) {
    public static ChessPiece getWhite(ChessPieceType type) {
        return new ChessPiece(type, ChessColor.WHITE);
    }

    public static ChessPiece getBlack(ChessPieceType type) {
        return new ChessPiece(type, ChessColor.BLACK);
    }

    @Override
    public String toString() {
        String pieceColor = (color == ChessColor.WHITE ? "W" : "B");
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
