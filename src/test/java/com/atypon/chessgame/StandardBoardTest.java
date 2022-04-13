package com.atypon.chessgame;

import com.atypon.chessgame.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StandardBoardTest {
    @Test
    void testInitialBoard() {
        StandardChessBoard chessBoard = new StandardChessBoard();
        for (int i = 0; i < 8; i++) {
            assertEquals(
                    chessBoard.getPieceAt(BoardPosition.at((char) ('A' + i) + "2")),
                    new ChessPiece(ChessPieceType.PAWN, ChessColor.WHITE)
            );
        }
        assertEquals(
                chessBoard.getPieceAt(BoardPosition.at("A1")),
                new ChessPiece(ChessPieceType.ROOK, ChessColor.WHITE)
        );
    }
}
