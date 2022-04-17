package com.atypon.chessgame.model;

import java.util.Collection;
import java.util.Optional;

public interface GameModel {
    void changeTurns();

    BoardState getCurrentBoardState();

    void updateCurrentBoardState(BoardState boardState);

    Collection<BoardState> getBoardStates();

    boolean isDone();

    void setDone(boolean done);

    Optional<Player> getWinner();

    void setWinner(Player winner);

    void setWinner(Color winnerColor);

    Player getWhitePlayer();

    Player getBlackPlayer();

    Player getCurrentPlayer();
}
