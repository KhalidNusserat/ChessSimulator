package com.atypon.chessgame.controller.eventshandler;

import com.atypon.chessgame.controller.eventschecker.CheckMateEvent;
import com.atypon.chessgame.controller.eventschecker.ChessEvent;
import com.atypon.chessgame.model.GameModel;

public class CheckMateEventHandler implements EventHandler {
    @Override
    public void handle(ChessEvent chessEvent, GameModel gameModel) {
        gameModel.setDone(true);
        gameModel.setWinner(((CheckMateEvent) chessEvent).getWinnerColor());
    }
}
