package com.atypon.chessgame.controller.movechecker;

import com.atypon.chessgame.model.BoardPosition;
import com.atypon.chessgame.model.Color;

public record ChessMove(Color playerColor, BoardPosition from, BoardPosition to) {
    @Override
    public String toString() {
        return String.format("move %s %s", from, to);
    }
}
