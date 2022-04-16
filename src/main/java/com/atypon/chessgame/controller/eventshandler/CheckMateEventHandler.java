package com.atypon.chessgame.controller.eventshandler;

import com.atypon.chessgame.controller.eventschecker.CheckMateEvent;
import com.atypon.chessgame.controller.eventschecker.ChessEvent;
import com.atypon.chessgame.model.ChessGameModel;

public class CheckMateEventHandler implements EventHandler {
    @Override
    public void handle(ChessEvent chessEvent, ChessGameModel chessGameModel) {
        chessGameModel.setDone(true);
        chessGameModel.setWinner(((CheckMateEvent) chessEvent).getWinnerColor());
    }
}
