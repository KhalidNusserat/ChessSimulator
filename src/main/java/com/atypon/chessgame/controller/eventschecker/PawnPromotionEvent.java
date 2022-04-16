package com.atypon.chessgame.controller.eventschecker;

import com.atypon.chessgame.model.BoardPosition;

public record PawnPromotionEvent(BoardPosition pawnPosition) implements ChessEvent {
    public BoardPosition getPawnPosition() {
        return pawnPosition;
    }

    public static PawnPromotionEvent at(BoardPosition pawnPosition) {
        return new PawnPromotionEvent(pawnPosition);
    }
}
