package com.atypon.chessgame.controllers.eventshandler;

import com.atypon.chessgame.controllers.eventschecker.ChessEvent;
import com.atypon.chessgame.model.ChessGameModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultEventsHandler implements EventsHandler {
    private final Map<Class<? extends ChessEvent>, EventHandler> eventHandlers = new HashMap<>();

    @Override
    public <E extends ChessEvent> void addEventHandler(Class<E> eventClass, EventHandler eventHandler) {
        eventHandlers.put(eventClass, eventHandler);
    }

    @Override
    public void handleEvent(ChessEvent chessEvent, ChessGameModel chessGameModel) {
        eventHandlers.get(chessEvent.getClass()).handle(chessEvent, chessGameModel);
    }

    @Override
    public void handleEvents(List<ChessEvent> chessEvents, ChessGameModel chessGameModel) {
        for (ChessEvent chessEvent : chessEvents) {
            eventHandlers.get(chessEvent.getClass()).handle(chessEvent, chessGameModel);
        }
    }
}
