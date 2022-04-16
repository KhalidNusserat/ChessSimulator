package com.atypon.chessgame.controller.movechecker;

import com.atypon.chessgame.model.Position;
import com.atypon.chessgame.model.Color;

public record ChessMove(Color playerColor, Position from, Position to) {
    @Override
    public String toString() {
        return String.format("move %s %s", from, to);
    }
}
