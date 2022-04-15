package com.atypon.chessgame.controller.moveexecutor;

import com.atypon.chessgame.controller.movechecker.Move;
import com.atypon.chessgame.model.ChessGameModel;

public interface MoveExecutor {
    void execute(Move move, ChessGameModel chessGameModel);
}
