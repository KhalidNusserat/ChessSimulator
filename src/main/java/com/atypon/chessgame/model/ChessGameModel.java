package com.atypon.chessgame.model;

import java.util.Collection;

public interface ChessGameModel {
    void changeTurns();

    BoardState getCurrentState();

    Collection<BoardState> getBoardStates();

    boolean isDone();

    void setDone(boolean done);

    Player getWinner();

    void setWinner(Player winner);

    Player getWhitePlayer();

    Player getBlackPlayer();

    Player getCurrentPlayer();
}
