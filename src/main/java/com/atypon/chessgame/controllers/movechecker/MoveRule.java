package com.atypon.chessgame.controllers.movechecker;

import com.atypon.chessgame.Move;
import com.atypon.chessgame.model.ChessGameModel;

public interface MoveRule {
    boolean checkMove(Move move, ChessGameModel chessGameModel);
}
