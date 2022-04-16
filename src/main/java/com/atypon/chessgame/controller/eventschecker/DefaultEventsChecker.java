package com.atypon.chessgame.controller.eventschecker;

import com.atypon.chessgame.model.GameModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DefaultEventsChecker implements EventsChecker {
    private final List<EventChecker> eventCheckers = new ArrayList<>();

    @Override
    public void addEventChecker(EventChecker eventChecker) {
        eventCheckers.add(eventChecker);
    }

    @Override
    public void addAllEventCheckers(Collection<EventChecker> eventCheckers) {
        this.eventCheckers.addAll(eventCheckers);
    }

    @Override
    public void addAllEventCheckers(EventChecker... eventCheckers) {
        this.eventCheckers.addAll(Arrays.asList(eventCheckers));
    }

    @Override
    public List<ChessEvent> getEvents(GameModel gameModel) {
        List<ChessEvent> chessEvents = new ArrayList<>();
        eventCheckers.forEach(eventChecker -> chessEvents.addAll(eventChecker.check(gameModel)));
        return chessEvents;
    }
}
