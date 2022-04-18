package com.atypon.chessgame.rendering;

import com.atypon.chessgame.model.Piece;
import com.atypon.chessgame.model.PieceType;

public class DefaultPieceStringifier implements PieceStringifier {
    @Override
    public String getString(Piece piece) {
        PieceType type = piece.type();
        if (type == PieceType.PAWN) {
            return "♙";
        } else if (type == PieceType.ROOK) {
            return "♖";
        } else if (type == PieceType.BISHOP) {
            return "♗";
        } else if (type == PieceType.KNIGHT) {
            return "♘";
        } else if (type == PieceType.QUEEN) {
            return "♕";
        } else {
            return "♔";
        }
    }
}
