package com.atypon.chessgame.model;

import java.util.Collection;
import java.util.Stack;

public class DefaultChessGameModel implements ChessGameModel {
    private final ChessPlayer whiteChessPlayer;

    private final ChessPlayer blackChessPlayer;

    private final Stack<BoardState> boardStates;

    private ChessPlayer currentChessPlayer;

    private ChessPlayer winner;

    private boolean isDone;

    public DefaultChessGameModel(String whitePlayerName, String blackPlayerName) {
        whiteChessPlayer = new ChessPlayer(whitePlayerName);
        blackChessPlayer = new ChessPlayer(blackPlayerName);
        boardStates = new Stack<>();
        boardStates.add(new DefaultBoardState());
    }

    @Override
    public void changeTurns() {
        currentChessPlayer = (
                currentChessPlayer == whiteChessPlayer
                        ? blackChessPlayer
                        : whiteChessPlayer
        );
    }

    @Override
    public BoardState getCurrentBoardState() {
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
    public ChessPlayer getWinner() {
        return winner;
    }

    @Override
    public void setWinner(ChessPlayer winner) {
        this.winner = winner;
    }

    @Override
    public ChessPlayer getWhitePlayer() {
        return whiteChessPlayer;
    }

    @Override
    public ChessPlayer getBlackPlayer() {
        return blackChessPlayer;
    }

    @Override
    public ChessPlayer getCurrentPlayer() {
        return currentChessPlayer;
    }

    @Override
    public void setCurrentBoardState(BoardState boardState) {
        boardStates.push(boardState);
    }
}
