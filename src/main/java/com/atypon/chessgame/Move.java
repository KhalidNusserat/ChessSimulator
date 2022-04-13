package com.atypon.chessgame;

public record Move(ChessColor playerColor, BoardPosition from, BoardPosition to) {
}
