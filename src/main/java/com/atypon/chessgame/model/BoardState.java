package com.atypon.chessgame.model;

import java.util.List;

public interface BoardState {
    ChessPiece getPieceAt(BoardPosition position);

    BoardState without(BoardPosition position);

    BoardState withSwapped(BoardPosition firstPosition, BoardPosition secondPosition);

    BoardState withPieceAt(ChessPiece chessPiece, BoardPosition position);

    List<BoardPosition> getPositionsOf(ChessPieceType type);

    List<BoardPosition> getPositionsOf(ChessPiece piece);

    boolean contains(ChessPieceType type);

    boolean contains(ChessPiece piece);
}
