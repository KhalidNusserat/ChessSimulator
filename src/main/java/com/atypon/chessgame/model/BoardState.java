package com.atypon.chessgame.model;

import java.util.List;
import java.util.Optional;

public interface BoardState extends Iterable<List<Optional<Piece>>> {
    Optional<Piece> getPieceAt(Position position);

    BoardState without(Position position);

    IntermediateBoardStateAt with(Piece piece);

    IntermediateBoardStateSwappedWith with(Position position);

    List<Position> getPositionsOf(PieceType type);

    List<Position> getPositionsOf(Piece piece);

    boolean contains(PieceType type);

    boolean contains(Piece piece);

    Optional<Position> getWhiteKingPosition();

    Optional<Position> getBlackKingPosition();

    interface IntermediateBoardStateAt {
        BoardState at(Position position);
    }

    interface IntermediateBoardStateSwappedWith {
        BoardState swappedWith(Position otherPosition);
    }
}
