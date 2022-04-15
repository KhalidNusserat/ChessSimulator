package com.atypon.chessgame.controller.movechecker;

import com.atypon.chessgame.model.ChessGameModel;

import java.util.Collection;

public interface MoveChecker {
    void addRule(MoveRule moveRule);

    void addAllRules(Collection<MoveRule> moveRules);

    void addAllRules(MoveRule... moveRules);

    boolean check(ChessMove chessMove, ChessGameModel defaultChessGameModel);
}
