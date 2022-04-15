package com.atypon.chessgame.controllers.eventshandler;

import com.atypon.chessgame.controllers.eventschecker.ChessEvent;
import com.atypon.chessgame.model.ChessGameModel;

public interface EventHandler {
    void handle(ChessEvent chessEvent, ChessGameModel chessGameModel);
}
