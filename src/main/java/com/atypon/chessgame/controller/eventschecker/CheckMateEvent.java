package com.atypon.chessgame.controller.eventschecker;

import com.atypon.chessgame.model.Color;

public record CheckMateEvent(Color winner) implements ChessEvent {
    public Color getWinnerColor() {
        return winner;
    }
}
