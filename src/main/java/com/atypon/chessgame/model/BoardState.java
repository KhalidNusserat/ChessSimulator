package com.atypon.chessgame.model;

import java.util.List;
import java.util.Optional;

public interface BoardState {
    interface IntermediateBoardState {
        BoardState at(Position position);
        BoardState swappedWith(Position otherPosition);
    }

    Piece getPieceAt(Position position);

    BoardState without(Position position);

    IntermediateBoardState with(Piece piece);

    IntermediateBoardState with(Position position);

    List<Position> getPositionsOf(PieceType type);

    List<Position> getPositionsOf(Piece piece);

    boolean contains(PieceType type);

    boolean contains(Piece piece);

    Optional<Position> getWhiteKingPosition();

    Optional<Position> getBlackKingPosition();
}
