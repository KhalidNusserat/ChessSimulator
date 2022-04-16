package com.atypon.chessgame.model;

import java.util.Collection;

public interface GameModel {
    void changeTurns();

    BoardState getCurrentBoardState();

    void setCurrentBoardState(BoardState boardState);

    Collection<BoardState> getBoardStates();

    boolean isDone();

    void setDone(boolean done);

    Player getWinner();

    void setWinner(Player winner);

    void setWinner(Color winnerColor);

    Player getWhitePlayer();

    Player getBlackPlayer();

    Player getCurrentPlayer();
}
