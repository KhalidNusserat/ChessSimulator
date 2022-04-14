package com.atypon.chessgame.controllers.eventschecker;

import com.atypon.chessgame.model.ChessGameModel;

import java.util.*;

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
    public List<ChessEvent> getEvents(ChessGameModel chessGameModel) {
        return eventCheckers.stream()
                .map(eventChecker -> eventChecker.check(chessGameModel))
                .filter(Objects::nonNull)
                .toList();
    }
}
