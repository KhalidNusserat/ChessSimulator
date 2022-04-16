package com.atypon.chessgame;

import com.atypon.chessgame.controller.movechecker.ChessMove;
import com.atypon.chessgame.model.ChessColor;

public interface MoveParser {
    ChessMove parse(String moveCommand, ChessColor playerColor);
}
