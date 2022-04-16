package com.atypon.chessgame.controller.eventshandler;

import com.atypon.chessgame.controller.eventschecker.ChessEvent;
import com.atypon.chessgame.model.GameModel;

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
    public void handleEvent(ChessEvent chessEvent, GameModel gameModel) {
        eventHandlers.get(chessEvent.getClass()).handle(chessEvent, gameModel);
    }

    @Override
    public void handleEvents(List<ChessEvent> chessEvents, GameModel gameModel) {
        for (ChessEvent chessEvent : chessEvents) {
            eventHandlers.get(chessEvent.getClass()).handle(chessEvent, gameModel);
        }
    }
}
