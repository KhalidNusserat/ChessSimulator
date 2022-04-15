package com.atypon.chessgame.controller;

import com.atypon.chessgame.controller.eventschecker.EventsChecker;
import com.atypon.chessgame.controller.eventshandler.EventsHandler;
import com.atypon.chessgame.controller.movechecker.ChessMove;
import com.atypon.chessgame.controller.movechecker.InvalidMove;
import com.atypon.chessgame.controller.movechecker.MoveChecker;
import com.atypon.chessgame.controller.moveexecutor.MoveExecutor;
import com.atypon.chessgame.model.ChessGameModel;
import com.atypon.chessgame.model.ChessPlayer;

public class DummyGameController implements ChessGameController {
    private ChessGameModel chessGameModel;

    private EventsChecker eventsChecker;

    private EventsHandler eventsHandler;

    private MoveChecker moveChecker;

    private MoveExecutor moveExecutor;

    @Override
    public void setChessGameModel(ChessGameModel chessGameModel) {
        this.chessGameModel = chessGameModel;
    }

    @Override
    public void setEventsChecker(EventsChecker eventsChecker) {
        this.eventsChecker = eventsChecker;
    }

    @Override
    public void setEventsHandler(EventsHandler eventsHandler) {
        this.eventsHandler = eventsHandler;
    }

    @Override
    public void setMoveChecker(MoveChecker moveChecker) {
        this.moveChecker = moveChecker;
    }

    @Override
    public void setMoveExecutor(MoveExecutor moveExecutor) {
        this.moveExecutor = moveExecutor;
    }

    @Override
    public void executeMoveIfLegal(ChessMove chessMove) throws InvalidMove {
        if (moveChecker.check(chessMove, chessGameModel)) {
            moveExecutor.execute(chessMove, chessGameModel);
        } else {
            throw new InvalidMove(chessMove);
        }
    }

    @Override
    public void handleEvents() {
        eventsHandler.handleEvents(eventsChecker.getEvents(chessGameModel), chessGameModel);
    }
}
