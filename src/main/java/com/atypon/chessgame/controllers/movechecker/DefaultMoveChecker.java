package com.atypon.chessgame.controllers.movechecker;

import com.atypon.chessgame.Move;
import com.atypon.chessgame.model.ChessGameModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DefaultMoveChecker implements MoveChecker {
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
    public boolean checkMove(Move move, ChessGameModel chessGameModel) {
        return moveRules.stream().allMatch(moveRule -> moveRule.checkMove(move, chessGameModel));
    }
}