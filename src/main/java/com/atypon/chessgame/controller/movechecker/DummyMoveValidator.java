package com.atypon.chessgame.controller.movechecker;

public class DummyMoveValidator extends DefaultMoveValidator {
    public DummyMoveValidator() {
        addRule(
                (move, chessGameModel) -> true
        );
    }
}
