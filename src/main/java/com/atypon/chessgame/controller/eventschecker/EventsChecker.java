package com.atypon.chessgame.controller.eventschecker;

import com.atypon.chessgame.model.GameModel;

import java.util.Collection;
import java.util.List;

public interface EventsChecker {
    void addEventChecker(EventChecker eventChecker);

    void addAllEventCheckers(Collection<EventChecker> eventsCheckers);

    void addAllEventCheckers(EventChecker... eventCheckers);

    List<ChessEvent> getEvents(GameModel gameModel);
}
