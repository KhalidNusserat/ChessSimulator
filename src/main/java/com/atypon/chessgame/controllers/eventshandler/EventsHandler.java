package com.atypon.chessgame.controllers.eventshandler;

import com.atypon.chessgame.controllers.eventschecker.ChessEvent;
import com.atypon.chessgame.model.ChessGameModel;

import java.util.List;

public interface EventsHandler {
    void handleEvents(List<ChessEvent> events, ChessGameModel chessGameModel);
}
