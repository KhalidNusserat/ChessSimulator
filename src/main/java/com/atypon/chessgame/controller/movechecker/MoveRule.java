package com.atypon.chessgame.controller.movechecker;

import com.atypon.chessgame.model.ChessGameModel;

public interface MoveRule {
    boolean checkMove(Move move, ChessGameModel chessGameModel);
}
