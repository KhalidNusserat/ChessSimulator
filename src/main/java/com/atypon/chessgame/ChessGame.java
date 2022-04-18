package com.atypon.chessgame;

import com.atypon.chessgame.model.BoardState;

public interface ChessGame {
    BoardState getCurrentBoardState();

    void playWhite(String move);

    void playBlack(String move);

    boolean isDone();

    boolean isWhiteTurn();

    boolean isBlackTurn();

    void printWinnerName();

    void printCurrentBoard();
}
