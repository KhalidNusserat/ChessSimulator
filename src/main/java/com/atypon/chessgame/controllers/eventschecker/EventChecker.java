package com.atypon.chessgame.controllers.eventschecker;

import com.atypon.chessgame.model.ChessGameModel;

public interface EventChecker {
    ChessEvent check(ChessGameModel chessGameModel);
}
