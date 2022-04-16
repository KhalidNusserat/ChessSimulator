package com.atypon.chessgame.controller.eventsemitter;

import com.atypon.chessgame.model.GameModel;

import java.util.Collection;
import java.util.List;

public interface EventsEmitter {
    void addEventRule(EventRule eventRule);

    void addAllEventRules(Collection<EventRule> eventsCheckers);

    void addAllEventRules(EventRule... eventRules);

    List<ChessEvent> getEvents(GameModel gameModel);
}
