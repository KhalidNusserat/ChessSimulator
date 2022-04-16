package com.atypon.chessgame.controller.eventschecker;

import com.atypon.chessgame.model.ChessColor;

public record CheckMateEvent(ChessColor winner) implements ChessEvent {
    public ChessColor getWinnerColor() {
        return winner;
    }
}
