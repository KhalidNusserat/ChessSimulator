package com.atypon.chessgame;

import com.atypon.chessgame.controller.eventschecker.ChessEvent;
import com.atypon.chessgame.controller.eventschecker.DummyEventsChecker;
import com.atypon.chessgame.controller.eventschecker.EventsChecker;
import com.atypon.chessgame.controller.eventshandler.DummyEventsHandler;
import com.atypon.chessgame.controller.eventshandler.EventsHandler;
import com.atypon.chessgame.controller.movechecker.DummyMoveChecker;
import com.atypon.chessgame.controller.movechecker.Move;
import com.atypon.chessgame.controller.movechecker.MoveChecker;
import com.atypon.chessgame.controller.moveexecutor.MoveExecutor;
import com.atypon.chessgame.model.ChessColor;
import com.atypon.chessgame.model.ChessGameModel;
import com.atypon.chessgame.model.DefaultChessGameModel;

import java.util.List;

public class DummyChessGame implements ChessGame {
    private final ChessGameModel chessGameModel;

    private final MoveParser moveParser;

    private final MoveChecker moveChecker;

    private final EventsChecker eventsChecker;

    private MoveExecutor moveExecutor;

    private final EventsHandler eventsHandler;

    public DummyChessGame(String whitePlayerName, String blackPlayerName) {
        chessGameModel = new DefaultChessGameModel(whitePlayerName, blackPlayerName);
        moveParser = new DefaultMoveParser();
        moveChecker = new DummyMoveChecker();
        eventsChecker = new DummyEventsChecker(10);
        eventsHandler = new DummyEventsHandler();
    }

    private void playMove(String moveCommand, ChessColor playerColor) throws IllegalArgumentException {
        try {
            Move move = moveParser.parse(moveCommand, playerColor);
            if (moveChecker.check(move, chessGameModel)) {
                moveExecutor.execute(move, chessGameModel);
            } else {
                throw new IllegalArgumentException("Illegal move.");
            }
            List<ChessEvent> events = eventsChecker.getEvents(chessGameModel);
            eventsHandler.handleEvents(events, chessGameModel);
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
        }
    }

    @Override
    public void playWhite(String moveCommand) {
        playMove(moveCommand, ChessColor.WHITE);
    }

    @Override
    public void playBlack(String moveCommand) {
        playMove(moveCommand, ChessColor.BLACK);
    }

    @Override
    public boolean isDone() {
        return chessGameModel.isDone();
    }

    @Override
    public boolean isWhiteTurn() {
        return chessGameModel.getWhitePlayer().equals(chessGameModel.getCurrentPlayer());
    }

    @Override
    public boolean isBlackTurn() {
        return chessGameModel.getBlackPlayer().equals(chessGameModel.getCurrentPlayer());
    }

    @Override
    public void printWinnerName() {
        System.out.println(chessGameModel.getWinner().name());
    }
}
