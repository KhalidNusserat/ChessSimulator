package com.atypon.chessgame;

import com.atypon.chessgame.controller.movechecker.Move;
import com.atypon.chessgame.model.ChessColor;

public interface MoveParser {
    Move parse(String move, ChessColor playerColor);
}
