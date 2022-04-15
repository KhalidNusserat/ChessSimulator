package com.atypon.chessgame.controllers.eventshandler;

import com.atypon.chessgame.controllers.eventschecker.CheckMateEvent;
import com.atypon.chessgame.controllers.eventschecker.PawnPromotionEvent;

public class DummyEventsHandler extends DefaultEventsHandler {
    public DummyEventsHandler() {
        addEventHandler(PawnPromotionEvent.class, new DummyPawnPromotionEventHandler());
        addAllEventHandlers(CheckMateEvent.class, new CheckMateEventHandler());
    }
}
