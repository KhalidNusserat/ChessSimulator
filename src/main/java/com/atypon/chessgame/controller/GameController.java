package com.atypon.chessgame.controller;

import com.atypon.chessgame.controller.eventschecker.EventsEmitter;
import com.atypon.chessgame.controller.eventshandler.EventsCatcher;
import com.atypon.chessgame.controller.movechecker.ChessMove;
import com.atypon.chessgame.controller.movechecker.IllegalMove;
import com.atypon.chessgame.controller.movechecker.MoveValidator;
import com.atypon.chessgame.controller.moveexecutor.MoveExecutor;
import com.atypon.chessgame.model.GameModel;

public interface GameController {
    void setGameModel(GameModel gameModel);

    void setEventsEmitter(EventsEmitter eventsEmitter);

    void setEventsCatcher(EventsCatcher eventsCatcher);

    void setMoveValidator(MoveValidator moveValidator);

    void setMoveExecutor(MoveExecutor moveExecutor);

    void executeMoveIfLegal(ChessMove chessMove) throws IllegalMove;

    void handleEvents();
}
