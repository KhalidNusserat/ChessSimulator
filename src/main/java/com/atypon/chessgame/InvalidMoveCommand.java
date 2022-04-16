package com.atypon.chessgame;

public class InvalidMoveCommand extends Exception {
    public InvalidMoveCommand(){
    }

    public InvalidMoveCommand(String moveCommand) {
        super(moveCommand + " is an illegal move command.");
    }
}
