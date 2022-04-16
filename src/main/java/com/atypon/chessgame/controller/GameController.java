package com.atypon.chessgame.controller;

import com.atypon.chessgame.controller.eventsemitter.EventsEmitter;
import com.atypon.chessgame.controller.eventscatcher.EventsCatcher;
import com.atypon.chessgame.controller.movevalidator.Move;
import com.atypon.chessgame.controller.movevalidator.IllegalMove;
import com.atypon.chessgame.controller.movevalidator.MoveValidator;
import com.atypon.chessgame.controller.moveexecutor.MoveExecutor;
import com.atypon.chessgame.model.GameModel;

public interface GameController {
    void setGameModel(GameModel gameModel);

    void setEventsEmitter(EventsEmitter eventsEmitter);

    void setEventsCatcher(EventsCatcher eventsCatcher);

    void setMoveValidator(MoveValidator moveValidator);

    void setMoveExecutor(MoveExecutor moveExecutor);

    void executeMoveIfLegal(Move move) throws IllegalMove;

    void handleEvents();
}
