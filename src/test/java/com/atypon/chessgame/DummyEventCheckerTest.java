package com.atypon.chessgame;

import com.atypon.chessgame.controllers.eventschecker.DummyEventsChecker;
import com.atypon.chessgame.controllers.eventschecker.EventsChecker;
import com.atypon.chessgame.controllers.eventschecker.PawnPromotionEvent;
import com.atypon.chessgame.model.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DummyEventCheckerTest {
    private EventsChecker eventsChecker;

    private ChessGameModel chessGameModel;

    @Before
    public void beforeEach() {
        eventsChecker = new DummyEventsChecker(2);
        chessGameModel = new DefaultChessGameModel("A", "B");
    }

    @Test
    public void testPawnPromotionEvent() {
        chessGameModel.updateCurrentBoardState(
                chessGameModel
                        .getCurrentBoardState()
                        .withSwapped(
                                BoardPosition.at("A2"),
                                BoardPosition.at("A8")
                        )
        );
        assertEquals(
                chessGameModel
                        .getCurrentBoardState()
                        .getPieceAt(BoardPosition.at("A8")),
                ChessPiece.getWhite(ChessPieceType.PAWN)
        );
        assertEquals(1, eventsChecker.getEvents(chessGameModel).size());
        assertEquals(PawnPromotionEvent.class, eventsChecker.getEvents(chessGameModel).get(0).getClass());
    }

    @Test
    public void testCheckmateEvent() {
        assertTrue(eventsChecker.getEvents(chessGameModel).isEmpty());
        assertFalse(eventsChecker.getEvents(chessGameModel).isEmpty());
    }
}