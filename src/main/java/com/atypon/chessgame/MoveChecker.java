package com.atypon.chessgame;

import java.util.Collection;

public interface MoveChecker {
    void addRule(MoveRule moveRule);

    void addAllRules(Collection<MoveRule> moveRules);

    boolean checkMove(Move move, ChessGameModel defaultChessGameModel);
}
