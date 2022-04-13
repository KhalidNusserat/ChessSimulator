package com.atypon.chessgame;

import com.atypon.chessgame.utils.CachedLinkedHashSet;

public class ChessGameModel {
    private final Player[] players;

    private final CachedLinkedHashSet<BoardState> boardStates;

    private Player currentPlayer;

    private Player winner;

    private boolean isDone;

    public ChessGameModel(String whitePlayer, String blackPlayer) {
        players = new Player[]{
                new Player(whitePlayer, ChessColor.WHITE),
                new Player(blackPlayer, ChessColor.BLACK)
        };
        currentPlayer = players[0];
        boardStates = new CachedLinkedHashSet<>();
        boardStates.add(new BoardState());
    }

    public void changeTurns() {
        currentPlayer = (currentPlayer == players[0] ? players[1] : players[0]);
    }

    public BoardState getCurrentState() {
        return boardStates.getLast();
    }

    public CachedLinkedHashSet<BoardState> getBoardStates() {
        return boardStates;
    }

    public boolean isDone() {
        return isDone;
    }

    public Player getWinner() {
        return winner;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
