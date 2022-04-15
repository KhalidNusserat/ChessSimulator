package com.atypon.chessgame.controller.eventshandler;

import com.atypon.chessgame.controller.eventschecker.CheckMateEvent;
import com.atypon.chessgame.controller.eventschecker.PawnPromotionEvent;

public class DummyEventsHandler extends DefaultEventsHandler {
    public DummyEventsHandler() {
        addEventHandler(PawnPromotionEvent.class, new DummyPawnPromotionEventHandler());
        addEventHandler(CheckMateEvent.class, new CheckMateEventHandler());
    }
}
