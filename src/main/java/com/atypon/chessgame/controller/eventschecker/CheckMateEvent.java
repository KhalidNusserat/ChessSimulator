package com.atypon.chessgame.controller.eventschecker;

import com.atypon.chessgame.model.ChessColor;

public class CheckMateEvent implements ChessEvent {
    private final ChessColor winner;

    public CheckMateEvent(ChessColor winner) {
        this.winner = winner;
    }

    public ChessColor getWinnerColor() {
        return winner;
    }
}
