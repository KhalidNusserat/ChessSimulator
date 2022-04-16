package com.atypon.chessgame.controller.movevalidator;

public class IllegalMove extends Exception {
    public IllegalMove() {
    }

    public IllegalMove(String message) {
        super(message);
    }

    public IllegalMove(Move move) {
        super(move + " is an illegal move.");
    }
}
