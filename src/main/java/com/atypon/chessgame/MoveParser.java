package com.atypon.chessgame;

import com.atypon.chessgame.model.ChessColor;

public interface MoveParser {
    Move parseMove(String move, ChessColor playerColor);
}
