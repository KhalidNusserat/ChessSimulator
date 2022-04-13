package com.atypon.chessgame;

import com.atypon.chessgame.utils.CachedLinkedHashSet;

import java.util.HashMap;
import java.util.Map;

public class DefaultChessGameModel implements ChessGameModel {
    private final Map<ChessColor, Player> players = new HashMap<>();

    private final CachedLinkedHashSet<BoardState> boardStates;

    private Player currentPlayer;

    private Player winner;

    private boolean isDone;

    public DefaultChessGameModel(String whitePlayer, String blackPlayer) {
        players.put(ChessColor.WHITE, new Player(whitePlayer));
        players.put(ChessColor.BLACK, new Player(blackPlayer));
        currentPlayer = players.get(ChessColor.WHITE);
        boardStates = new CachedLinkedHashSet<>();
        boardStates.add(new StandardChessBoard());
    }

    @Override
    public void changeTurns() {
        currentPlayer = (
                currentPlayer == players.get(ChessColor.WHITE)
                        ? players.get(ChessColor.BLACK)
                        : players.get(ChessColor.WHITE)
        );
    }

    @Override
    public BoardState getCurrentState() {
        return boardStates.getLast();
    }

    @Override
    public CachedLinkedHashSet<BoardState> getBoardStates() {
        return boardStates;
    }

    @Override
    public boolean isDone() {
        return isDone;
    }

    @Override
    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public Player getWinner() {
        return winner;
    }

    @Override
    public void setWinner(Player winner) {
        this.winner = winner;
    }

    @Override
    public Map<ChessColor, Player> getPlayers() {
        return players;
    }

    @Override
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
