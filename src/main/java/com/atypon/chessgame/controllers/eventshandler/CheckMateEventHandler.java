package com.atypon.chessgame.controllers.eventshandler;

import com.atypon.chessgame.controllers.eventschecker.ChessEvent;
import com.atypon.chessgame.model.ChessGameModel;

public class CheckMateEventHandler implements EventHandler {
    @Override
    public void handle(ChessEvent chessEvent, ChessGameModel chessGameModel) {
        chessGameModel.setDone(true);
    }
}
