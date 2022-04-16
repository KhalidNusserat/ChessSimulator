package com.atypon.chessgame;

import com.atypon.chessgame.controller.GameController;
import com.atypon.chessgame.controller.DummyGameController;
import com.atypon.chessgame.controller.eventschecker.DummyEventsEmitter;
import com.atypon.chessgame.controller.eventshandler.DummyEventsCatcher;
import com.atypon.chessgame.controller.movechecker.DummyMoveValidator;
import com.atypon.chessgame.controller.movechecker.IllegalMove;
import com.atypon.chessgame.controller.moveexecutor.DefaultMoveExecutor;
import com.atypon.chessgame.model.Color;
import com.atypon.chessgame.model.GameModel;
import com.atypon.chessgame.model.DefaultGameModel;

public class DummyChessGame implements ChessGame {
    private final GameModel gameModel;

    private final GameController gameController;

    private final MoveParser moveParser;

    public DummyChessGame(String whitePlayer, String blackPlayer) {
        gameModel = new DefaultGameModel(whitePlayer, blackPlayer);
        gameController = new DummyGameController();
        gameController.setGameModel(gameModel);
        gameController.setEventsEmitter(new DummyEventsEmitter());
        gameController.setEventsCatcher(new DummyEventsCatcher());
        gameController.setMoveValidator(new DummyMoveValidator());
        gameController.setMoveExecutor(new DefaultMoveExecutor());
        moveParser = new DefaultMoveParser();
    }

    @Override
    public void playWhite(String move) {
        try {
            gameController.executeMoveIfLegal(moveParser.parse(move, Color.WHITE));
            gameController.handleEvents();
            gameModel.changeTurns();
        } catch (IllegalMove | InvalidMoveCommand | InvalidBoardPosition e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void playBlack(String move) {
        try {
            gameController.executeMoveIfLegal(moveParser.parse(move, Color.BLACK));
            gameController.handleEvents();
            gameModel.changeTurns();
        } catch (IllegalMove | InvalidMoveCommand | InvalidBoardPosition e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean isDone() {
        return gameModel.isDone();
    }

    @Override
    public boolean isWhiteTurn() {
        return gameModel.getCurrentPlayer().equals(gameModel.getWhitePlayer());
    }

    @Override
    public boolean isBlackTurn() {
        return gameModel.getCurrentPlayer().equals(gameModel.getBlackPlayer());
    }

    @Override
    public void printWinnerName() {
        System.out.printf("The winner is %s", gameModel.getWinner().name());
    }

    @Override
    public void printCurrentBoard() {
        System.out.println(gameModel.getCurrentBoardState());
    }
}
