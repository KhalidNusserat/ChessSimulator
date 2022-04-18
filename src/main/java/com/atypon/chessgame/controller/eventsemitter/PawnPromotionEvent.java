package com.atypon.chessgame.controller.eventsemitter;

import com.atypon.chessgame.model.Position;

public record PawnPromotionEvent(Position pawnPosition) implements ChessEvent {
    public static PawnPromotionEvent at(Position pawnPosition) {
        return new PawnPromotionEvent(pawnPosition);
    }

    public Position getPawnPosition() {
        return pawnPosition;
    }
}
