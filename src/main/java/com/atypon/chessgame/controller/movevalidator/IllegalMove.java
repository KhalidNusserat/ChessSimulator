package com.atypon.chessgame.controller.movevalidator;

public class IllegalMove extends Exception {
    public IllegalMove() {
    }

    public IllegalMove(String message) {
        super(message);
    }

    public IllegalMove(ChessMove chessMove) {
        super(chessMove + " is an illegal move.");
    }
}