package com.atypon.chessgame.controller;

import com.atypon.chessgame.controller.eventschecker.EventsChecker;
import com.atypon.chessgame.controller.eventshandler.EventsHandler;
import com.atypon.chessgame.controller.movechecker.ChessMove;
import com.atypon.chessgame.controller.movechecker.IllegalMove;
import com.atypon.chessgame.controller.movechecker.MoveChecker;
import com.atypon.chessgame.controller.moveexecutor.MoveExecutor;
import com.atypon.chessgame.model.GameModel;

public class DummyGameController implements GameController {
    private GameModel gameModel;

    private EventsChecker eventsChecker;

    private EventsHandler eventsHandler;

    private MoveChecker moveChecker;

    private MoveExecutor moveExecutor;

    @Override
    public void setChessGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
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
    public void executeMoveIfLegal(ChessMove chessMove) throws IllegalMove {
        if (moveChecker.check(chessMove, gameModel)) {
            moveExecutor.execute(chessMove, gameModel);
        } else {
            throw new IllegalMove(chessMove);
        }
    }

    @Override
    public void handleEvents() {
        eventsHandler.handleEvents(eventsChecker.getEvents(gameModel), gameModel);
    }
}
