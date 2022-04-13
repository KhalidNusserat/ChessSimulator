package com.atypon.chessgame;

public interface ChessGame {
    boolean isDone();

    boolean isWhiteTurn();

    boolean isBlackTurn();

    void playBlack();

    void playWhite();

    void printWinnerName();
}
