package com.atypon.chessgame;

import com.atypon.chessgame.utils.CachedLinkedHashSet;

import java.util.Map;

public interface ChessGameModel {
    void changeTurns();

    BoardState getCurrentState();

    CachedLinkedHashSet<BoardState> getBoardStates();

    boolean isDone();

    void setDone(boolean done);

    Player getWinner();

    void setWinner(Player winner);

    Map<ChessColor, Player> getPlayers();

    Player getCurrentPlayer();
}
