package com.atypon.chessgame.controller.movechecker;

import com.atypon.chessgame.model.BoardPosition;
import com.atypon.chessgame.model.ChessColor;

public record Move(ChessColor playerColor, BoardPosition from, BoardPosition to) {
}
