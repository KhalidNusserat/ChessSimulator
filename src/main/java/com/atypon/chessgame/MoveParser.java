package com.atypon.chessgame;

import com.atypon.chessgame.controller.movevalidator.ChessMove;
import com.atypon.chessgame.model.Color;

public interface MoveParser {
    ChessMove parse(String moveCommand, Color playerColor) throws InvalidMoveCommand, InvalidBoardPosition;
}
