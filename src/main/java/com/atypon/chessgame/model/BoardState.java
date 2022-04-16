package com.atypon.chessgame.model;

import java.util.List;

public interface BoardState {
    interface IntermediateBoardState {
        BoardState at(BoardPosition boardPosition);
        BoardState swappedWith(BoardPosition otherBoardPosition);
    }

    ChessPiece getPieceAt(BoardPosition position);

    BoardState without(BoardPosition position);

    IntermediateBoardState with(ChessPiece chessPiece);

    IntermediateBoardState with(BoardPosition boardPosition);

    List<BoardPosition> getPositionsOf(ChessPieceType type);

    List<BoardPosition> getPositionsOf(ChessPiece piece);

    boolean contains(ChessPieceType type);

    boolean contains(ChessPiece piece);
}
