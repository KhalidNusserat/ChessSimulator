package com.atypon.chessgame.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultBoardState implements BoardState {
    private final Map<BoardPosition, ChessPiece> board = new HashMap<>();

    private DefaultBoardState(DefaultBoardState other) {
        board.putAll(other.board);
    }

    public DefaultBoardState() {
        initializePlayer(ChessColor.WHITE, "2", "1");
        initializePlayer(ChessColor.BLACK, "7", "8");
    }

    private void initializePlayer(ChessColor color, String pawnsLevel, String otherPiecesLevel) {
        for (int i = 0; i < 8; i++) {
            board.put(
                    BoardPosition.at((char) ('A' + i) + pawnsLevel),
                    new ChessPiece(ChessPieceType.PAWN, color)
            );
        }
        board.put(BoardPosition.at("A" + otherPiecesLevel), new ChessPiece(ChessPieceType.ROOK, color));
        board.put(BoardPosition.at("H" + otherPiecesLevel), new ChessPiece(ChessPieceType.ROOK, color));
        board.put(BoardPosition.at("B" + otherPiecesLevel), new ChessPiece(ChessPieceType.KNIGHT, color));
        board.put(BoardPosition.at("G" + otherPiecesLevel), new ChessPiece(ChessPieceType.KNIGHT, color));
        board.put(BoardPosition.at("C" + otherPiecesLevel), new ChessPiece(ChessPieceType.BISHOP, color));
        board.put(BoardPosition.at("F" + otherPiecesLevel), new ChessPiece(ChessPieceType.BISHOP, color));
        board.put(BoardPosition.at("D" + otherPiecesLevel), new ChessPiece(ChessPieceType.QUEEN, color));
        board.put(BoardPosition.at("E" + otherPiecesLevel), new ChessPiece(ChessPieceType.KING, color));
    }

    private BoardState withPieceAt(ChessPiece chessPiece, BoardPosition position) {
        DefaultBoardState newBoardState = new DefaultBoardState(this);
        if (chessPiece != null) {
            newBoardState.board.put(position, chessPiece);
        } else {
            newBoardState.board.remove(position);
        }
        return newBoardState;
    }

    @Override
    public ChessPiece getPieceAt(BoardPosition position) {
        return board.get(position);
    }

    @Override
    public BoardState without(BoardPosition position) {
        DefaultBoardState newBoardState = new DefaultBoardState(this);
        newBoardState.board.remove(position);
        return newBoardState;
    }

    @Override
    public BoardState withSwapped(BoardPosition firstPosition, BoardPosition secondPosition) {
        DefaultBoardState newBoardState = new DefaultBoardState(this);
        ChessPiece firstPiece = board.get(firstPosition);
        ChessPiece secondPiece = board.get(secondPosition);
        if (secondPiece != null) {
            newBoardState.board.put(firstPosition, secondPiece);
        } else {
            newBoardState.board.remove(firstPosition);
        }
        if (firstPiece != null) {
            newBoardState.board.put(secondPosition, firstPiece);
        } else {
            newBoardState.board.remove(secondPosition);
        }
        return newBoardState;
    }

    @Override
    public IntermediateBoardState with(ChessPiece chessPiece) {
        return new DefaultIntermediateBoardState(chessPiece, this);
    }

    @Override
    public List<BoardPosition> getPositionsOf(ChessPieceType type) {
        return board.keySet().stream()
                .filter(board::containsKey)
                .filter(position -> board.get(position).type().equals(type))
                .toList();
    }

    @Override
    public List<BoardPosition> getPositionsOf(ChessPiece piece) {
        return board.keySet().stream()
                .filter(board::containsKey)
                .filter(position -> board.get(position).equals(piece))
                .toList();
    }

    @Override
    public boolean contains(ChessPieceType type) {
        return !getPositionsOf(type).isEmpty();
    }

    @Override
    public boolean contains(ChessPiece piece) {
        return !getPositionsOf(piece).isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder boardString = new StringBuilder();
        for (int row = 8; row >= 1; row--) {
            boardString.append(row).append(": ");
            for (char col = 'A'; col <= 'H'; col++) {
                String position = String.format("%c%d", col, row);
                ChessPiece chessPiece = board.get(BoardPosition.at(position));
                if (chessPiece != null) {
                    boardString.append(chessPiece).append(" ");
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

    static class DefaultIntermediateBoardState implements IntermediateBoardState {
        private final ChessPiece chessPiece;

        private final DefaultBoardState boardState;

        public DefaultIntermediateBoardState(ChessPiece chessPiece, DefaultBoardState boardState) {
            this.chessPiece = chessPiece;
            this.boardState = boardState;
        }

        @Override
        public BoardState at(BoardPosition boardPosition) {
            return boardState.withPieceAt(chessPiece, boardPosition);
        }
    }
}
