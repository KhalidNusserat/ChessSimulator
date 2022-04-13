package com.atypon.chessgame;

import com.atypon.chessgame.model.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StandardBoardTest {
    @Test
    public void testInitialBoard() {
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
