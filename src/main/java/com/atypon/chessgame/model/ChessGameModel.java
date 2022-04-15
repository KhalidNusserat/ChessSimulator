package com.atypon.chessgame.model;

import java.util.Collection;

public interface ChessGameModel {
    void changeTurns();

    BoardState getCurrentBoardState();

    Collection<BoardState> getBoardStates();

    boolean isDone();

    void setDone(boolean done);

    ChessPlayer getWinner();

    void setWinner(ChessPlayer winner);

    ChessPlayer getWhitePlayer();

    ChessPlayer getBlackPlayer();

    ChessPlayer getCurrentPlayer();

    void setCurrentBoardState(BoardState boardState);
}
