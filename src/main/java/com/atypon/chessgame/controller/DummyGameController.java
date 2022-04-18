package com.atypon.chessgame.controller;

import com.atypon.chessgame.controller.eventscatcher.EventsCatcher;
import com.atypon.chessgame.controller.eventsemitter.EventsEmitter;
import com.atypon.chessgame.controller.moveexecutor.MoveExecutor;
import com.atypon.chessgame.controller.movevalidator.IllegalMove;
import com.atypon.chessgame.controller.movevalidator.Move;
import com.atypon.chessgame.controller.movevalidator.MoveValidator;
import com.atypon.chessgame.model.GameModel;

public class DummyGameController implements GameController {
    private GameModel gameModel;

    private EventsEmitter eventsEmitter;

    private EventsCatcher eventsCatcher;

    private MoveValidator moveValidator;

    private MoveExecutor moveExecutor;

    @Override
    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    @Override
    public void setEventsEmitter(EventsEmitter eventsEmitter) {
        this.eventsEmitter = eventsEmitter;
    }

    @Override
    public void setEventsCatcher(EventsCatcher eventsCatcher) {
        this.eventsCatcher = eventsCatcher;
    }

    @Override
    public void setMoveValidator(MoveValidator moveValidator) {
        this.moveValidator = moveValidator;
    }

    @Override
    public void setMoveExecutor(MoveExecutor moveExecutor) {
        this.moveExecutor = moveExecutor;
    }

    @Override
    public void executeMoveIfLegal(Move move) throws IllegalMove {
        if (moveValidator.check(move, gameModel)) {
            moveExecutor.execute(move, gameModel);
        } else {
            throw new IllegalMove(move);
        }
    }

    @Override
    public void handleEvents() {
        eventsCatcher.catchEvents(eventsEmitter.getEvents(gameModel), gameModel);
    }
}
