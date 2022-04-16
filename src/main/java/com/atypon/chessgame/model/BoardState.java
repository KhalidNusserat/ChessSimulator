package com.atypon.chessgame.model;

import java.util.List;
import java.util.Optional;

public interface BoardState {
    interface IntermediateBoardState {
        BoardState at(BoardPosition boardPosition);
        BoardState swappedWith(BoardPosition otherBoardPosition);
    }

    Piece getPieceAt(BoardPosition position);

    BoardState without(BoardPosition position);

    IntermediateBoardState with(Piece piece);

    IntermediateBoardState with(BoardPosition boardPosition);

    List<BoardPosition> getPositionsOf(PieceType type);

    List<BoardPosition> getPositionsOf(Piece piece);

    boolean contains(PieceType type);

    boolean contains(Piece piece);

    Optional<BoardPosition> getWhiteKingPosition();

    Optional<BoardPosition> getBlackKingPosition();
}
