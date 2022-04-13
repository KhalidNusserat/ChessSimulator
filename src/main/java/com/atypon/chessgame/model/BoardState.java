package com.atypon.chessgame.model;

import java.util.HashMap;
import java.util.Map;

public class BoardState {
    protected final Map<BoardPosition, ChessPiece> board = new HashMap<>();

    public ChessPiece getPieceAt(BoardPosition position) {
        return board.get(position);
    }
}
