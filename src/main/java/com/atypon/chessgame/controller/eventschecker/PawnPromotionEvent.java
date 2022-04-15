package com.atypon.chessgame.controller.eventschecker;

import com.atypon.chessgame.model.BoardPosition;

public class PawnPromotionEvent implements ChessEvent {
    private final BoardPosition pawnPosition;

    public PawnPromotionEvent(BoardPosition pawnPosition) {
        this.pawnPosition = pawnPosition;
    }

    public BoardPosition getPawnPosition() {
        return pawnPosition;
    }
}
