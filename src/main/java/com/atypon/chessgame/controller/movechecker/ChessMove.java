package com.atypon.chessgame.controller.movechecker;

import com.atypon.chessgame.model.BoardPosition;
import com.atypon.chessgame.model.ChessColor;

public record ChessMove(ChessColor playerColor, BoardPosition from, BoardPosition to) {
    @Override
    public String toString() {
        return String.format("move %s %s", from, to);
    }
}
