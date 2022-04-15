package com.atypon.chessgame.controllers.eventshandler;

import com.atypon.chessgame.controllers.eventschecker.ChessEvent;
import com.atypon.chessgame.controllers.eventschecker.PawnPromotionEvent;
import com.atypon.chessgame.model.*;

public class DummyPawnPromotionEventHandler implements EventHandler {
    @Override
    public void handle(ChessEvent chessEvent, ChessGameModel chessGameModel) {
        BoardPosition pawnPosition = ((PawnPromotionEvent) chessEvent).getPawnPosition();
        BoardState currentBoardState = chessGameModel.getCurrentBoardState();
        ChessColor color = currentBoardState.getPieceAt(pawnPosition).color();
        chessGameModel.updateCurrentBoardState(
                currentBoardState
                        .withPieceAt(new ChessPiece(ChessPieceType.QUEEN, color), pawnPosition)
        );
    }
}
