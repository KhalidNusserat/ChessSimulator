package com.atypon.chessgame.controller.eventscatcher;

import com.atypon.chessgame.controller.eventsemitter.ChessEvent;
import com.atypon.chessgame.model.GameModel;

public interface EventHandler {
    void handle(ChessEvent chessEvent, GameModel gameModel);
}
