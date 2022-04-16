package com.atypon.chessgame;

import com.atypon.chessgame.controller.eventschecker.DummyEventsChecker;
import com.atypon.chessgame.controller.eventschecker.EventsChecker;
import com.atypon.chessgame.controller.eventschecker.PawnPromotionEvent;
import com.atypon.chessgame.model.BoardPosition;
import com.atypon.chessgame.model.ChessGameModel;
import com.atypon.chessgame.model.DefaultChessGameModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DummyEventCheckerTest {
    private EventsChecker eventsChecker;

    private ChessGameModel chessGameModel;

    @Before
    public void beforeEach() {
        eventsChecker = new DummyEventsChecker();
        chessGameModel = new DefaultChessGameModel("A", "B");
    }

    @Test
    public void testPawnPromotionEvent() {
        chessGameModel.setCurrentBoardState(
                chessGameModel
                        .getCurrentBoardState()
                        .withSwapped(
                                BoardPosition.at("A2"),
                                BoardPosition.at("A8")
                        )
        );
        assertTrue(
                eventsChecker
                        .getEvents(chessGameModel)
                        .stream()
                        .anyMatch(eventClass -> eventClass instanceof PawnPromotionEvent)
        );
        chessGameModel.setCurrentBoardState(
                chessGameModel
                        .getCurrentBoardState()
                        .withSwapped(
                                BoardPosition.at("A7"),
                                BoardPosition.at("A1")
                        )
        );
        assertTrue(
                eventsChecker
                        .getEvents(chessGameModel)
                        .stream()
                        .anyMatch(eventClass -> eventClass instanceof PawnPromotionEvent)
        );
        assertEquals(2, eventsChecker.getEvents(chessGameModel).size());
        assertTrue(
                eventsChecker
                        .getEvents(chessGameModel)
                        .stream()
                        .filter(chessEvent -> chessEvent instanceof PawnPromotionEvent)
                        .anyMatch(
                                chessEvent -> ((PawnPromotionEvent) chessEvent)
                                        .getPawnPosition()
                                        .equals(BoardPosition.at("A8"))
                        )
        );
        assertTrue(
                eventsChecker
                        .getEvents(chessGameModel)
                        .stream()
                        .filter(chessEvent -> chessEvent instanceof PawnPromotionEvent)
                        .anyMatch(
                                chessEvent -> ((PawnPromotionEvent) chessEvent)
                                        .getPawnPosition()
                                        .equals(BoardPosition.at("A1"))
                        )
        );
    }
}
