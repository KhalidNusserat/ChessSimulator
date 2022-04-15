package com.atypon.chessgame.controllers.eventschecker;

import com.atypon.chessgame.model.ChessGameModel;
import com.atypon.chessgame.model.ChessPiece;
import com.atypon.chessgame.model.ChessPieceType;

public class DummyEventsChecker extends DefaultEventsChecker {
    public DummyEventsChecker(int numberOfStepsBeforeCheckmate) {
        addAllEventCheckers(
                chessGameModel -> {
                    boolean pawnReachedEnd = chessGameModel
                            .getCurrentBoardState()
                            .getPositionsOf(ChessPiece.getWhite(ChessPieceType.PAWN))
                            .stream()
                            .anyMatch(position -> position.getRow() == '8');
                    pawnReachedEnd = pawnReachedEnd || chessGameModel
                            .getCurrentBoardState()
                            .getPositionsOf(ChessPiece.getBlack(ChessPieceType.PAWN))
                            .stream()
                            .anyMatch(position -> position.getRow() == '1');
                    if (pawnReachedEnd) {
                        return new PawnPromotionEvent();
                    }
                    return null;
                },
                new EventChecker() {
                    private int counter = 0;

                    @Override
                    public ChessEvent check(ChessGameModel chessGameModel) {
                        if (++counter >= numberOfStepsBeforeCheckmate) {
                            return new CheckMateEvent();
                        }
                        return null;
                    }
                }
        );
    }
}
