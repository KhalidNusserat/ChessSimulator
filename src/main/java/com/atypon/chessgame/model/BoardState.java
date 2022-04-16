package com.atypon.chessgame.model;

import java.util.List;
import java.util.Optional;

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

    Optional<BoardPosition> getWhiteKingPosition();

    Optional<BoardPosition> getBlackKingPosition();
}
