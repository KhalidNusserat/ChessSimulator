package com.atypon.chessgame.controllers.eventschecker;

import com.atypon.chessgame.model.ChessGameModel;

import java.util.Collection;

public interface EventChecker {
    Collection<ChessEvent> check(ChessGameModel chessGameModel);
}
