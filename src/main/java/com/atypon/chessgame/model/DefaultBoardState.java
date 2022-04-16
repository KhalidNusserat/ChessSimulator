package com.atypon.chessgame.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public Piece getPieceAt(Position position) {
        return board.get(position);
    }

    @Override
    public BoardState without(Position position) {
        DefaultBoardState newBoardState = new DefaultBoardState(this);
        newBoardState.board.remove(position);
        return newBoardState;
    }

    @Override
    public IntermediateBoardState with(Piece piece) {
        return new DefaultIntermediateBoardState(piece, this);
    }

    @Override
    public IntermediateBoardState with(Position position) {
        return new DefaultIntermediateBoardState(position, this);
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
    public String toString() {
        StringBuilder boardString = new StringBuilder();
        for (int row = 8; row >= 1; row--) {
            boardString.append(row).append(": ");
            for (char col = 'A'; col <= 'H'; col++) {
                String position = String.format("%c%d", col, row);
                Piece piece = board.get(Position.at(position));
                if (piece != null) {
                    boardString.append(piece).append(" ");
                } else {
                    boardString.append("__ ");
                }
            }
            boardString.append("\n");
        }
        boardString.append("   ");
        for (char col = 'A'; col <= 'H'; col++) {
            boardString.append(col).append("  ");
        }
        return boardString.toString();
    }

    private static class DefaultIntermediateBoardState implements IntermediateBoardState {
        private Piece piece = null;

        private final DefaultBoardState boardState;

        private Position position = null;

        public DefaultIntermediateBoardState(Piece piece, DefaultBoardState boardState) {
            this.piece = piece;
            this.boardState = boardState;
        }

        public DefaultIntermediateBoardState(Position position, DefaultBoardState boardState) {
            this.position = position;
            this.boardState = boardState;
        }

        @Override
        public BoardState at(Position position) {
            return boardState.withPieceAt(piece, position);
        }

        @Override
        public BoardState swappedWith(Position otherPosition) {
            return boardState.withSwapped(position, otherPosition);
        }
    }
}
