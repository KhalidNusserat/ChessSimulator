package com.atypon.chessgame;

public class InvalidBoardPosition extends Exception {
    public InvalidBoardPosition() {
    }

    public InvalidBoardPosition(String boardPosition) {
        super(boardPosition + " is not a valid board position.");
    }
}
