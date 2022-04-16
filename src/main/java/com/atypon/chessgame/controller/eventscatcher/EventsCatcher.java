package com.atypon.chessgame.controller.eventscatcher;

import com.atypon.chessgame.controller.eventsemitter.ChessEvent;
import com.atypon.chessgame.model.GameModel;

import java.util.List;

public interface EventsCatcher {
    <E extends ChessEvent> void addEventHandler(Class<E> eventClass, EventHandler eventHandler);

    void handleEvent(ChessEvent chessEvent, GameModel gameModel);

    void catchEvents(List<ChessEvent> events, GameModel gameModel);
}
