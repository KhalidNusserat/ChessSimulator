package com.atypon.chessgame.controller.movevalidator;

import com.atypon.chessgame.model.Color;
import com.atypon.chessgame.model.Position;

public record Move(Color playerColor, Position from, Position to) {
    @Override
    public String toString() {
        return String.format("move %s %s", from, to);
    }
}
