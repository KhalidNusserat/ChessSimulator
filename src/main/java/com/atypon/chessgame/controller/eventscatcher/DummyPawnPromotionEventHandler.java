package com.atypon.chessgame.controller.eventscatcher;

import com.atypon.chessgame.controller.eventsemitter.ChessEvent;
import com.atypon.chessgame.controller.eventsemitter.PawnPromotionEvent;
import com.atypon.chessgame.model.*;

public class DummyPawnPromotionEventHandler implements EventHandler {
    @Override
    public void handle(ChessEvent chessEvent, GameModel gameModel) {
        Position pawnPosition = ((PawnPromotionEvent) chessEvent).getPawnPosition();
        BoardState currentBoardState = gameModel.getCurrentBoardState();
        Color color = currentBoardState.getPieceAt(pawnPosition).color();
        gameModel.updateCurrentBoardState(
                currentBoardState
                        .with(new Piece(PieceType.QUEEN, color))
                        .at(pawnPosition)
        );
    }
}
