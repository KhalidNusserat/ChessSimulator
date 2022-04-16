package com.atypon.chessgame.controller.eventshandler;

import com.atypon.chessgame.controller.eventschecker.ChessEvent;
import com.atypon.chessgame.model.GameModel;

public interface EventHandler {
    void handle(ChessEvent chessEvent, GameModel gameModel);
}
