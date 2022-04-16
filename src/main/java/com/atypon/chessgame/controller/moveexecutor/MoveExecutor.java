package com.atypon.chessgame.controller.moveexecutor;

import com.atypon.chessgame.controller.movevalidator.Move;
import com.atypon.chessgame.model.GameModel;

public interface MoveExecutor {
    void execute(Move move, GameModel gameModel);
}
