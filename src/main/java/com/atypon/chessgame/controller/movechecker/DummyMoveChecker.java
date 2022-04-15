package com.atypon.chessgame.controller.movechecker;

public class DummyMoveChecker extends DefaultMoveChecker {
    public DummyMoveChecker() {
        addRule(
                (move, chessGameModel) -> true
        );
    }
}
