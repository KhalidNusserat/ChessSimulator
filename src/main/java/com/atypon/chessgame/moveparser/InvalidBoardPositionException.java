package com.atypon.chessgame.moveparser;

public class InvalidBoardPositionException extends Exception {
    public InvalidBoardPositionException() {
    }

    public InvalidBoardPositionException(String boardPosition) {
        super(boardPosition + " is not a valid board position.");
    }
}
