package com.atypon.chessgame.controller.eventshandler;

import com.atypon.chessgame.controller.eventschecker.ChessEvent;
import com.atypon.chessgame.model.ChessGameModel;

public interface EventHandler {
    void handle(ChessEvent chessEvent, ChessGameModel chessGameModel);
}
