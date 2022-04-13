package com.atypon.chessgame;

public interface MoveRule {
    boolean checkMove(Move move, ChessGameModel chessGameModel);
}
