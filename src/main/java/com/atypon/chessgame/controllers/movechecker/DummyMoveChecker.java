package com.atypon.chessgame.controllers.movechecker;

public class DummyMoveChecker extends DefaultMoveChecker {
    public DummyMoveChecker() {
        addRule(
                (move, chessGameModel) -> true
        );
    }
}
