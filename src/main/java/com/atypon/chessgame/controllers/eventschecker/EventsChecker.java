package com.atypon.chessgame.controllers.eventschecker;

import com.atypon.chessgame.model.ChessGameModel;

import java.util.List;

public interface EventsChecker {
    List<ChessEvent> getEvents(ChessGameModel chessGameModel);
}
