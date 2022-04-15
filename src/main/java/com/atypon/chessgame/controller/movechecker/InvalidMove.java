package com.atypon.chessgame.controller.movechecker;

public class InvalidMove extends Exception {
    public InvalidMove() {
    }

    public InvalidMove(String message) {
        super(message);
    }

    public InvalidMove(ChessMove chessMove) {
        super(chessMove + " is an illegal move.");
    }
}
