package com.atypon.chessgame.controller.eventscatcher;

import com.atypon.chessgame.controller.eventsemitter.CheckMateEvent;
import com.atypon.chessgame.controller.eventsemitter.ChessEvent;
import com.atypon.chessgame.model.GameModel;

public class CheckMateEventHandler implements EventHandler {
    @Override
    public void handle(ChessEvent chessEvent, GameModel gameModel) {
        gameModel.setDone(true);
        gameModel.setWinner(((CheckMateEvent) chessEvent).getWinnerColor());
    }
}
