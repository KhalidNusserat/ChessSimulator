package com.atypon.chessgame.controller.eventshandler;

import com.atypon.chessgame.controller.eventschecker.ChessEvent;
import com.atypon.chessgame.controller.eventschecker.PawnPromotionEvent;
import com.atypon.chessgame.model.*;

public class DummyPawnPromotionEventHandler implements EventHandler {
    @Override
    public void handle(ChessEvent chessEvent, GameModel gameModel) {
        BoardPosition pawnPosition = ((PawnPromotionEvent) chessEvent).getPawnPosition();
        BoardState currentBoardState = gameModel.getCurrentBoardState();
        Color color = currentBoardState.getPieceAt(pawnPosition).color();
        gameModel.setCurrentBoardState(
                currentBoardState
                        .with(new Piece(PieceType.QUEEN, color))
                        .at(pawnPosition)
        );
    }
}
