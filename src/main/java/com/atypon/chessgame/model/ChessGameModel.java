package com.atypon.chessgame.model;

import com.atypon.chessgame.utils.CachedLinkedHashSet;

public interface ChessGameModel {
    void changeTurns();

    BoardState getCurrentState();

    CachedLinkedHashSet<BoardState> getBoardStates();

    boolean isDone();

    void setDone(boolean done);

    Player getWinner();

    void setWinner(Player winner);

    Player getWhitePlayer();

    Player getBlackPlayer();

    Player getCurrentPlayer();
}
