package com.atypon.chessgame.controller.eventschecker;

import com.atypon.chessgame.model.ChessGameModel;
import com.atypon.chessgame.model.ChessPiece;
import com.atypon.chessgame.model.ChessPieceType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DummyEventsChecker extends DefaultEventsChecker {
    public DummyEventsChecker(int numberOfStepsBeforeCheckmate) {
        addAllEventCheckers(
                chessGameModel -> {
                    List<ChessEvent> chessEvents = new ArrayList<>();
                    chessGameModel
                            .getCurrentBoardState()
                            .getPositionsOf(ChessPiece.getWhite(ChessPieceType.PAWN))
                            .stream()
                            .filter(position -> position.getRow() == '8')
                            .forEach(position -> chessEvents.add(new PawnPromotionEvent(position)));
                    chessGameModel
                            .getCurrentBoardState()
                            .getPositionsOf(ChessPiece.getBlack(ChessPieceType.PAWN))
                            .stream()
                            .filter(position -> position.getRow() == '1')
                            .forEach(position -> chessEvents.add(new PawnPromotionEvent(position)));
                    return chessEvents;
                },
                new EventChecker() {
                    private int counter = 0;

                    @Override
                    public Collection<ChessEvent> check(ChessGameModel chessGameModel) {
                        if (++counter >= numberOfStepsBeforeCheckmate) {
                            return List.of(new CheckMateEvent());
                        }
                        return Collections.emptyList();
                    }
                }
        );
    }
}
