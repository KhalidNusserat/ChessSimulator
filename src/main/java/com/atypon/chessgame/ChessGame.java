package com.atypon.chessgame;

public interface ChessGame {
    void playWhite(String moveCommand);

    void playBlack(String moveCommand);

    boolean isDone();

    boolean isWhiteTurn();

    boolean isBlackTurn();

    void printWinnerName();
}
