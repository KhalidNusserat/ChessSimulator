package com.atypon.chessgame;

import com.atypon.chessgame.utils.CachedLinkedHashSet;

import java.util.Map;

public interface ChessGameModel {
    void changeTurns();

    BoardState getCurrentState();

    CachedLinkedHashSet<BoardState> getBoardStates();

    boolean isDone();

    Player getWinner();

    Map<ChessColor, Player> getPlayers();

    Player getCurrentPlayer();

    void setWinner(Player winner);

    void setDone(boolean done);
}
