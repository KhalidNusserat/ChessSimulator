package com.atypon.chessgame;

public class InvalidMoveCommandException extends Exception {
    public InvalidMoveCommandException() {
    }

    public InvalidMoveCommandException(String moveCommand) {
        super(moveCommand + " is an illegal move command.");
    }
}
