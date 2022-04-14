package com.atypon.chessgame.model;

import java.util.Collection;
import java.util.Stack;

public class DefaultChessGameModel implements ChessGameModel {
    private final Player whitePlayer;

    private final Player blackPlayer;

    private final Stack<BoardState> boardStates;

    private Player currentPlayer;

    private Player winner;

    private boolean isDone;

    public DefaultChessGameModel(String whitePlayerName, String blackPlayerName) {
        whitePlayer = new Player(whitePlayerName);
        blackPlayer = new Player(blackPlayerName);
        boardStates = new Stack<>();
        boardStates.add(new StandardChessBoard());
    }

    @Override
    public void changeTurns() {
        currentPlayer = (
                currentPlayer == whitePlayer
                        ? blackPlayer
                        : whitePlayer
        );
    }

    @Override
    public BoardState getCurrentState() {
        return boardStates.peek();
    }

    @Override
    public Collection<BoardState> getBoardStates() {
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
    public Player getWhitePlayer() {
        return whitePlayer;
    }

    @Override
    public Player getBlackPlayer() {
        return blackPlayer;
    }

    @Override
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
