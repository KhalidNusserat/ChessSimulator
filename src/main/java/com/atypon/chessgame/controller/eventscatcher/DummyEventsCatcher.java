package com.atypon.chessgame.controller.eventscatcher;

import com.atypon.chessgame.controller.eventsemitter.CheckMateEvent;
import com.atypon.chessgame.controller.eventsemitter.PawnPromotionEvent;

public class DummyEventsCatcher extends DefaultEventsCatcher {
    public DummyEventsCatcher() {
        addEventHandler(PawnPromotionEvent.class, new DummyPawnPromotionEventHandler());
        addEventHandler(CheckMateEvent.class, new CheckMateEventHandler());
    }
}
