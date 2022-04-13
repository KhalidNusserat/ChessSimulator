package com.atypon.chessgame.controllers.movechecker;

import com.atypon.chessgame.model.ChessGameModel;

import java.util.Collection;

public interface MoveChecker {
    void addRule(MoveRule moveRule);

    void addAllRules(Collection<MoveRule> moveRules);

    void addAllRules(MoveRule... moveRules);

    boolean checkMove(Move move, ChessGameModel defaultChessGameModel);
}
