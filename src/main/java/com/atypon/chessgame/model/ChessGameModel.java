package com.atypon.chessgame.model;

import java.util.Collection;

public interface ChessGameModel {
    void changeTurns();

    BoardState getCurrentBoardState();

    void setCurrentBoardState(BoardState boardState);

    Collection<BoardState> getBoardStates();

    boolean isDone();

    void setDone(boolean done);

    ChessPlayer getWinner();

    void setWinner(ChessPlayer winner);

    void setWinner(ChessColor winnerColor);

    ChessPlayer getWhitePlayer();

    ChessPlayer getBlackPlayer();

    ChessPlayer getCurrentPlayer();
}
