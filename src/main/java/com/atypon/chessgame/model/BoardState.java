package com.atypon.chessgame.model;

import java.util.List;

public interface BoardState {
    interface IntermediateBoardState {
        BoardState at(BoardPosition boardPosition);
    }

    ChessPiece getPieceAt(BoardPosition position);

    BoardState without(BoardPosition position);

    BoardState withSwapped(BoardPosition firstPosition, BoardPosition secondPosition);

    IntermediateBoardState with(ChessPiece chessPiece);

    List<BoardPosition> getPositionsOf(ChessPieceType type);

    List<BoardPosition> getPositionsOf(ChessPiece piece);

    boolean contains(ChessPieceType type);

    boolean contains(ChessPiece piece);
}
