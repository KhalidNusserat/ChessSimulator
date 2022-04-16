package com.atypon.chessgame.controller.eventschecker;

import com.atypon.chessgame.model.GameModel;

import java.util.Collection;

public interface EventRule {
    Collection<ChessEvent> check(GameModel gameModel);
}
