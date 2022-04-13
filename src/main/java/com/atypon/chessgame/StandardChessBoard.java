package com.atypon.chessgame;

public class StandardChessBoard extends BoardState {
    public StandardChessBoard() {
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
}
