package com.atypon.chessgame.controller.eventschecker;

import com.atypon.chessgame.model.GameModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DefaultEventsEmitter implements EventsEmitter {
    private final List<EventRule> eventRules = new ArrayList<>();

    @Override
    public void addEventRule(EventRule eventRule) {
        eventRules.add(eventRule);
    }

    @Override
    public void addAllEventRules(Collection<EventRule> eventRules) {
        this.eventRules.addAll(eventRules);
    }

    @Override
    public void addAllEventRules(EventRule... eventRules) {
        this.eventRules.addAll(Arrays.asList(eventRules));
    }

    @Override
    public List<ChessEvent> getEvents(GameModel gameModel) {
        List<ChessEvent> chessEvents = new ArrayList<>();
        eventRules.forEach(eventRule -> chessEvents.addAll(eventRule.check(gameModel)));
        return chessEvents;
    }
}
