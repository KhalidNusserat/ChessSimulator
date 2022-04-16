package com.atypon.chessgame;

import com.atypon.chessgame.controller.ChessGameController;
import com.atypon.chessgame.controller.DummyGameController;
import com.atypon.chessgame.controller.eventschecker.DummyEventsChecker;
import com.atypon.chessgame.controller.eventshandler.DummyEventsHandler;
import com.atypon.chessgame.controller.movechecker.DummyMoveChecker;
import com.atypon.chessgame.controller.movechecker.IllegalMove;
import com.atypon.chessgame.controller.moveexecutor.DefaultMoveExecutor;
import com.atypon.chessgame.model.ChessColor;
import com.atypon.chessgame.model.ChessGameModel;
import com.atypon.chessgame.model.DefaultChessGameModel;

public class DummyChessGame implements ChessGame {
    private final ChessGameModel chessGameModel;

    private final ChessGameController chessGameController;

    private final MoveParser moveParser;

    public DummyChessGame(String whitePlayer, String blackPlayer) {
        chessGameModel = new DefaultChessGameModel(whitePlayer, blackPlayer);
        chessGameController = new DummyGameController();
        chessGameController.setChessGameModel(chessGameModel);
        chessGameController.setEventsChecker(new DummyEventsChecker());
        chessGameController.setEventsHandler(new DummyEventsHandler());
        chessGameController.setMoveChecker(new DummyMoveChecker());
        chessGameController.setMoveExecutor(new DefaultMoveExecutor());
        moveParser = new DefaultMoveParser();
    }

    @Override
    public void playWhite(String move) {
        try {
            chessGameController.executeMoveIfLegal(moveParser.parse(move, ChessColor.WHITE));
            chessGameController.handleEvents();
            chessGameModel.changeTurns();
        } catch (IllegalMove | InvalidMoveCommand e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void playBlack(String move) {
        try {
            chessGameController.executeMoveIfLegal(moveParser.parse(move, ChessColor.BLACK));
            chessGameController.handleEvents();
            chessGameModel.changeTurns();
        } catch (IllegalMove | InvalidMoveCommand e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean isDone() {
        return chessGameModel.isDone();
    }

    @Override
    public boolean isWhiteTurn() {
        return chessGameModel.getCurrentPlayer().equals(chessGameModel.getWhitePlayer());
    }

    @Override
    public boolean isBlackTurn() {
        return chessGameModel.getCurrentPlayer().equals(chessGameModel.getBlackPlayer());
    }

    @Override
    public void printWinnerName() {
        System.out.printf("The winner is %s", chessGameModel.getWinner().name());
    }

    @Override
    public void printCurrentBoard() {
        System.out.println(chessGameModel.getCurrentBoardState());
    }
}
