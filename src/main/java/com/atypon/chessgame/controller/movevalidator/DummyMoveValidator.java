package com.atypon.chessgame.controller.movevalidator;

public class DummyMoveValidator extends DefaultMoveValidator {
    public DummyMoveValidator() {
        addRule(
                (move, chessGameModel) -> true
        );
    }
}
