package com.atypon.chessgame.controller.movevalidator;

import com.atypon.chessgame.model.GameModel;

import java.util.Collection;

public interface MoveValidator {
    void addRule(MoveRule moveRule);

    void addAllRules(Collection<MoveRule> moveRules);

    void addAllRules(MoveRule... moveRules);

    boolean check(ChessMove chessMove, GameModel defaultGameModel);
}
