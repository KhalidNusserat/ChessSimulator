package com.atypon.chessgame.controller.eventshandler;

import com.atypon.chessgame.controller.eventschecker.ChessEvent;
import com.atypon.chessgame.model.GameModel;

import java.util.List;

public interface EventsHandler {
    <E extends ChessEvent> void addEventHandler(Class<E> eventClass, EventHandler eventHandler);

    void handleEvent(ChessEvent chessEvent, GameModel gameModel);

    void handleEvents(List<ChessEvent> events, GameModel gameModel);
}
