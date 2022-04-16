package com.atypon.chessgame;

import com.atypon.chessgame.controller.movevalidator.Move;
import com.atypon.chessgame.model.Color;

public interface MoveParser {
    Move parse(String moveCommand, Color playerColor) throws InvalidMoveCommand, InvalidBoardPosition;
}
