package com.atypon.chessgame.controller.movechecker;

import com.atypon.chessgame.model.ChessGameModel;

public interface MoveRule {
    boolean checkMove(ChessMove chessMove, ChessGameModel chessGameModel);
}
