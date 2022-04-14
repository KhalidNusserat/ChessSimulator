package com.atypon.chessgame;

import com.atypon.chessgame.model.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

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

    @Test
    public void testWithSwapped() {
        StandardChessBoard chessBoard = new StandardChessBoard();
        chessBoard = (StandardChessBoard) chessBoard.withSwapped(BoardPosition.at("A2"), BoardPosition.at("A4"));
        assertNull(chessBoard.getPieceAt(BoardPosition.at("A2")));
        assertEquals(chessBoard.getPieceAt(BoardPosition.at("A4")).type(), ChessPieceType.PAWN);
        chessBoard = (StandardChessBoard) chessBoard.withSwapped(BoardPosition.at("A3"), BoardPosition.at("A2"));
        assertNull(chessBoard.getPieceAt(BoardPosition.at("A3")));
        assertNull(chessBoard.getPieceAt(BoardPosition.at("A2")));
        chessBoard = (StandardChessBoard) chessBoard.withSwapped(BoardPosition.at("A4"), BoardPosition.at("H1"));
        assertEquals(chessBoard.getPieceAt(BoardPosition.at("A4")).type(), ChessPieceType.ROOK);
        assertEquals(chessBoard.getPieceAt(BoardPosition.at("H1")).type(), ChessPieceType.PAWN);
    }

    @Test
    public void testWithout() {
        StandardChessBoard chessBoard = new StandardChessBoard();
        chessBoard = (StandardChessBoard) chessBoard.without(BoardPosition.at("E8"));
        assertNull(chessBoard.getPieceAt(BoardPosition.at("E8")));
    }

    @Test
    public void testGetPositionOfType() {
        StandardChessBoard chessBoard = new StandardChessBoard();
        List<BoardPosition> positionsOfPawns = chessBoard.getPositionsOf(ChessPieceType.PAWN);
        assertEquals(positionsOfPawns.size(), 16);
    }

    @Test
    public void testGetPositionsOfPiece() {
        StandardChessBoard chessBoard = new StandardChessBoard();
        List<BoardPosition> positionsOfBlackRooks = chessBoard.getPositionsOf(
                new ChessPiece(ChessPieceType.ROOK, ChessColor.BLACK)
        );
        assertEquals(positionsOfBlackRooks.size(), 2);
        assertEquals(positionsOfBlackRooks.get(0), BoardPosition.at("A8"));
        assertEquals(positionsOfBlackRooks.get(1), BoardPosition.at("H8"));
    }

    @Test
    public void testContainsType() {
        StandardChessBoard chessBoard = new StandardChessBoard();
        assertTrue(chessBoard.contains(ChessPieceType.PAWN));
        List<BoardPosition> positionsOfPawns = chessBoard.getPositionsOf(ChessPieceType.PAWN);
        for (BoardPosition position : positionsOfPawns) {
            chessBoard = (StandardChessBoard) chessBoard.without(position);
        }
        assertFalse(chessBoard.contains(ChessPieceType.PAWN));
    }

    @Test
    public void testContainsPiece() {
        StandardChessBoard chessBoard = new StandardChessBoard();
        ChessPiece whiteKing = new ChessPiece(ChessPieceType.KING, ChessColor.WHITE);
        assertTrue(chessBoard.contains(whiteKing));
        chessBoard = (StandardChessBoard) chessBoard.without(chessBoard.getPositionsOf(whiteKing).get(0));
        assertFalse(chessBoard.contains(whiteKing));
    }

    @Test
    public void testWithPieceAt() {
        StandardChessBoard chessBoard = new StandardChessBoard();
        ChessPiece newWhiteKing = new ChessPiece(ChessPieceType.KING, ChessColor.BLACK);
        chessBoard = (StandardChessBoard) chessBoard.withPieceAt(newWhiteKing, BoardPosition.at("D5"));
        assertEquals(chessBoard.getPieceAt(BoardPosition.at("D5")), newWhiteKing);
    }
}
