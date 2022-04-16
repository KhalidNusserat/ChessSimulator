package com.atypon.chessgame.controller.movechecker;

import com.atypon.chessgame.model.GameModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DefaultMoveValidator implements MoveValidator {
    private final List<MoveRule> moveRules = new ArrayList<>();

    @Override
    public void addRule(MoveRule moveRule) {
        moveRules.add(moveRule);
    }

    @Override
    public void addAllRules(Collection<MoveRule> moveRules) {
        this.moveRules.addAll(moveRules);
    }

    @Override
    public void addAllRules(MoveRule... moveRules) {
        for (MoveRule moveRule : moveRules) {
            addRule(moveRule);
        }
    }

    @Override
    public boolean check(ChessMove chessMove, GameModel gameModel) {
        return moveRules.stream().allMatch(moveRule -> moveRule.checkMove(chessMove, gameModel));
    }
}