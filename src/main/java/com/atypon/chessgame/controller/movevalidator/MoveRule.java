package com.atypon.chessgame.controller.movevalidator;

import com.atypon.chessgame.model.GameModel;

public interface MoveRule {
    boolean checkMove(Move move, GameModel gameModel);
}
