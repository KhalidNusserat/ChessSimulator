package com.atypon.chessgame;

public interface ChessGame {
    void playWhite(String move);

    void playBlack(String move);

    boolean isDone();

    boolean isWhiteTurn();

    boolean isBlackTurn();

    void printWinnerName();

    void printCurrentBoard();
}
