package com.atypon.chessgame.controllers.eventshandler;

import com.atypon.chessgame.controllers.eventschecker.ChessEvent;
import com.atypon.chessgame.model.ChessGameModel;

import java.util.Collection;
import java.util.List;

public interface EventsHandler {
    <E extends ChessEvent> void addEventHandler(Class<E> eventClass, EventHandler eventHandler);

    <E extends ChessEvent> void addAllEventHandlers(Class<E> eventClass, Collection<EventHandler> eventHandlers);

    <E extends ChessEvent> void addAllEventHandlers(Class<E> eventClass, EventHandler... eventHandlers);

    void handleEvent(ChessEvent chessEvent, ChessGameModel chessGameModel);

    void handleEvents(List<ChessEvent> events, ChessGameModel chessGameModel);
}
