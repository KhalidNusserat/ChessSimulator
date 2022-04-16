package com.atypon.chessgame.controller.eventsemitter;

import com.atypon.chessgame.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DummyEventsEmitter extends DefaultEventsEmitter {
    public DummyEventsEmitter() {
        addAllEventRules(
                chessGameModel -> {
                    List<ChessEvent> chessEvents = new ArrayList<>();
                    chessGameModel
                            .getCurrentBoardState()
                            .getPositionsOf(Piece.getWhite(PieceType.PAWN))
                            .stream()
                            .filter(position -> position.getRow() == '8')
                            .forEach(position -> chessEvents.add(PawnPromotionEvent.at(position)));
                    chessGameModel
                            .getCurrentBoardState()
                            .getPositionsOf(Piece.getBlack(PieceType.PAWN))
                            .stream()
                            .filter(position -> position.getRow() == '1')
                            .forEach(position -> chessEvents.add(PawnPromotionEvent.at(position)));
                    return chessEvents;
                },
                chessGameModel -> {
                    BoardState boardState = chessGameModel.getCurrentBoardState();
                    if (boardState.getWhiteKingPosition().isEmpty()) {
                        return List.of(new CheckMateEvent(Color.BLACK));
                    }
                    if (boardState.getBlackKingPosition().isEmpty()) {
                        return List.of(new CheckMateEvent(Color.WHITE));
                    }
                    return Collections.emptyList();
                }
        );
    }
}
