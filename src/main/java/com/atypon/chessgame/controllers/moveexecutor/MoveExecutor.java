package com.atypon.chessgame.controllers.moveexecutor;

import com.atypon.chessgame.controllers.movechecker.Move;
import com.atypon.chessgame.model.ChessGameModel;

public interface MoveExecutor {
    void execute(Move move, ChessGameModel chessGameModel);
}
