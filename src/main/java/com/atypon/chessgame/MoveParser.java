package com.atypon.chessgame;

public interface MoveParser {
    Move parseMove(String move, ChessColor playerColor);
}
