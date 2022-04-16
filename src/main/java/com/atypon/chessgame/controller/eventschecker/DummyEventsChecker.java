package com.atypon.chessgame.controller.eventschecker;

import com.atypon.chessgame.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DummyEventsChecker extends DefaultEventsChecker {
    public DummyEventsChecker() {
        addAllEventCheckers(
                chessGameModel -> {
                    List<ChessEvent> chessEvents = new ArrayList<>();
                    chessGameModel
                            .getCurrentBoardState()
                            .getPositionsOf(ChessPiece.getWhite(ChessPieceType.PAWN))
                            .stream()
                            .filter(position -> position.getRow() == '8')
                            .forEach(position -> chessEvents.add(PawnPromotionEvent.at(position)));
                    chessGameModel
                            .getCurrentBoardState()
                            .getPositionsOf(ChessPiece.getBlack(ChessPieceType.PAWN))
                            .stream()
                            .filter(position -> position.getRow() == '1')
                            .forEach(position -> chessEvents.add(PawnPromotionEvent.at(position)));
                    return chessEvents;
                },
                chessGameModel -> {
                    BoardState boardState = chessGameModel.getCurrentBoardState();
                    if (boardState.getPositionsOf(ChessPieceType.KING).size() == 1) {
                        BoardPosition positionOfKing = boardState.getPositionsOf(ChessPieceType.KING).get(0);
                        ChessColor winnerColor = boardState.getPieceAt(positionOfKing).color();
                        return List.of(new CheckMateEvent(winnerColor));
                    }
                    return Collections.emptyList();
                }
        );
    }
}
