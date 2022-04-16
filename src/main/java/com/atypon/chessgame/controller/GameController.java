package com.atypon.chessgame.controller;

import com.atypon.chessgame.controller.eventschecker.EventsChecker;
import com.atypon.chessgame.controller.eventshandler.EventsHandler;
import com.atypon.chessgame.controller.movechecker.ChessMove;
import com.atypon.chessgame.controller.movechecker.IllegalMove;
import com.atypon.chessgame.controller.movechecker.MoveChecker;
import com.atypon.chessgame.controller.moveexecutor.MoveExecutor;
import com.atypon.chessgame.model.GameModel;

public interface GameController {
    void setChessGameModel(GameModel gameModel);

    void setEventsChecker(EventsChecker eventsChecker);

    void setEventsHandler(EventsHandler eventsHandler);

    void setMoveChecker(MoveChecker moveChecker);

    void setMoveExecutor(MoveExecutor moveExecutor);

    void executeMoveIfLegal(ChessMove chessMove) throws IllegalMove;

    void handleEvents();
}
