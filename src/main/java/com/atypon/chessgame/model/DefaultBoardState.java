package com.atypon.chessgame.model;

import java.util.*;

public class DefaultBoardState implements BoardState {
    private final Map<Position, Piece> board = new HashMap<>();

    private DefaultBoardState(DefaultBoardState other) {
        board.putAll(other.board);
    }

    public DefaultBoardState() {
        initializePlayer(Color.WHITE, "2", "1");
        initializePlayer(Color.BLACK, "7", "8");
    }

    private void initializePlayer(Color color, String pawnsLevel, String otherPiecesLevel) {
        for (int i = 0; i < 8; i++) {
            board.put(
                    Position.at((char) ('A' + i) + pawnsLevel),
                    new Piece(PieceType.PAWN, color)
            );
        }
        board.put(Position.at("A" + otherPiecesLevel), new Piece(PieceType.ROOK, color));
        board.put(Position.at("H" + otherPiecesLevel), new Piece(PieceType.ROOK, color));
        board.put(Position.at("B" + otherPiecesLevel), new Piece(PieceType.KNIGHT, color));
        board.put(Position.at("G" + otherPiecesLevel), new Piece(PieceType.KNIGHT, color));
        board.put(Position.at("C" + otherPiecesLevel), new Piece(PieceType.BISHOP, color));
        board.put(Position.at("F" + otherPiecesLevel), new Piece(PieceType.BISHOP, color));
        board.put(Position.at("D" + otherPiecesLevel), new Piece(PieceType.QUEEN, color));
        board.put(Position.at("E" + otherPiecesLevel), new Piece(PieceType.KING, color));
    }

    private BoardState withPieceAt(Piece piece, Position position) {
        DefaultBoardState newBoardState = new DefaultBoardState(this);
        if (piece != null) {
            newBoardState.board.put(position, piece);
        } else {
            newBoardState.board.remove(position);
        }
        return newBoardState;
    }

    private BoardState withSwapped(Position firstPosition, Position secondPosition) {
        Piece firstPiece = board.get(firstPosition);
        Piece secondPiece = board.get(secondPosition);
        return this
                .with(secondPiece).at(firstPosition)
                .with(firstPiece).at(secondPosition);
    }

    @Override
    public Optional<Piece> getPieceAt(Position position) {
        Piece piece = board.get(position);
        if (piece == null) {
            return Optional.empty();
        } else {
            return Optional.of(piece);
        }
    }

    @Override
    public BoardState without(Position position) {
        DefaultBoardState newBoardState = new DefaultBoardState(this);
        newBoardState.board.remove(position);
        return newBoardState;
    }

    @Override
    public IntermediateBoardStateAt with(Piece piece) {
        return new DefaultIntermediateBoardStateAt(piece, this);
    }

    @Override
    public IntermediateBoardStateSwappedWith with(Position position) {
        return new DefaultIntermediateBoardStateSwappedWith(position, this);
    }

    @Override
    public List<Position> getPositionsOf(PieceType type) {
        return board.keySet().stream()
                .filter(boardPosition -> board.get(boardPosition).type() == type)
                .toList();
    }

    @Override
    public List<Position> getPositionsOf(Piece piece) {
        return board.keySet().stream()
                .filter(boardPosition -> board.get(boardPosition).equals(piece))
                .toList();
    }

    @Override
    public boolean contains(PieceType type) {
        return !getPositionsOf(type).isEmpty();
    }

    @Override
    public boolean contains(Piece piece) {
        return !getPositionsOf(piece).isEmpty();
    }

    @Override
    public Optional<Position> getWhiteKingPosition() {
        Piece whiteKing = Piece.getWhite(PieceType.KING);
        if (!board.containsValue(whiteKing)) {
            return Optional.empty();
        }
        return Optional.of(getPositionsOf(whiteKing).get(0));
    }

    @Override
    public Optional<Position> getBlackKingPosition() {
        Piece blackKing = Piece.getBlack(PieceType.KING);
        if (!board.containsValue(blackKing)) {
            return Optional.empty();
        }
        return Optional.of(getPositionsOf(blackKing).get(0));
    }

    @Override
    public DefaultBoardStateIterator iterator() {
        return new DefaultBoardStateIterator();
    }

    private record DefaultIntermediateBoardStateAt(Piece piece,
                                                   DefaultBoardState boardState) implements IntermediateBoardStateAt {
        @Override
        public BoardState at(Position position) {
            return boardState.withPieceAt(piece, position);
        }
    }

    private record DefaultIntermediateBoardStateSwappedWith(Position position,
                                                            DefaultBoardState boardState)
            implements IntermediateBoardStateSwappedWith {
        @Override
        public BoardState swappedWith(Position otherPosition) {
            return boardState.withSwapped(position, otherPosition);
        }
    }

    private class DefaultBoardStateIterator implements Iterator<List<Optional<Piece>>> {
        private int row = 8;

        @Override
        public boolean hasNext() {
            return row != 0;
        }

        @Override
        public List<Optional<Piece>> next() {
            List<Optional<Piece>> pieces = new ArrayList<>();
            for (char col = 'A'; col <= 'H'; col++) {
                String position = String.format("%c%d", col, row);
                pieces.add(getPieceAt(Position.at(position)));
            }
            row--;
            return pieces;
        }
    }
}
