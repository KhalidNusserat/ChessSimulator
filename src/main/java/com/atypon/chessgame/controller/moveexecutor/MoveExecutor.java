package com.atypon.chessgame.controller.moveexecutor;

import com.atypon.chessgame.controller.movevalidator.ChessMove;
import com.atypon.chessgame.model.GameModel;

public interface MoveExecutor {
    void execute(ChessMove chessMove, GameModel gameModel);
}
