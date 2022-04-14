package com.atypon.chessgame;

import com.atypon.chessgame.model.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StandardBoardTest {
    @Test
    public void testInitialBoard() {
        DefaultBoardState chessBoard = new DefaultBoardState();
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
        DefaultBoardState chessBoard = new DefaultBoardState();
        chessBoard = (DefaultBoardState) chessBoard.withSwapped(BoardPosition.at("A2"), BoardPosition.at("A4"));
        assertNull(chessBoard.getPieceAt(BoardPosition.at("A2")));
        assertEquals(chessBoard.getPieceAt(BoardPosition.at("A4")).type(), ChessPieceType.PAWN);
        chessBoard = (DefaultBoardState) chessBoard.withSwapped(BoardPosition.at("A3"), BoardPosition.at("A2"));
        assertNull(chessBoard.getPieceAt(BoardPosition.at("A3")));
        assertNull(chessBoard.getPieceAt(BoardPosition.at("A2")));
        chessBoard = (DefaultBoardState) chessBoard.withSwapped(BoardPosition.at("A4"), BoardPosition.at("H1"));
        assertEquals(chessBoard.getPieceAt(BoardPosition.at("A4")).type(), ChessPieceType.ROOK);
        assertEquals(chessBoard.getPieceAt(BoardPosition.at("H1")).type(), ChessPieceType.PAWN);
    }

    @Test
    public void testWithout() {
        DefaultBoardState chessBoard = new DefaultBoardState();
        chessBoard = (DefaultBoardState) chessBoard.without(BoardPosition.at("E8"));
        assertNull(chessBoard.getPieceAt(BoardPosition.at("E8")));
    }

    @Test
    public void testGetPositionOfType() {
        DefaultBoardState chessBoard = new DefaultBoardState();
        List<BoardPosition> positionsOfPawns = chessBoard.getPositionsOf(ChessPieceType.PAWN);
        assertEquals(positionsOfPawns.size(), 16);
    }

    @Test
    public void testGetPositionsOfPiece() {
        DefaultBoardState chessBoard = new DefaultBoardState();
        List<BoardPosition> positionsOfBlackRooks = chessBoard.getPositionsOf(
                new ChessPiece(ChessPieceType.ROOK, ChessColor.BLACK)
        );
        assertEquals(positionsOfBlackRooks.size(), 2);
        assertEquals(positionsOfBlackRooks.get(0), BoardPosition.at("A8"));
        assertEquals(positionsOfBlackRooks.get(1), BoardPosition.at("H8"));
    }

    @Test
    public void testContainsType() {
        DefaultBoardState chessBoard = new DefaultBoardState();
        assertTrue(chessBoard.contains(ChessPieceType.PAWN));
        List<BoardPosition> positionsOfPawns = chessBoard.getPositionsOf(ChessPieceType.PAWN);
        for (BoardPosition position : positionsOfPawns) {
            chessBoard = (DefaultBoardState) chessBoard.without(position);
        }
        assertFalse(chessBoard.contains(ChessPieceType.PAWN));
    }

    @Test
    public void testContainsPiece() {
        DefaultBoardState chessBoard = new DefaultBoardState();
        ChessPiece whiteKing = new ChessPiece(ChessPieceType.KING, ChessColor.WHITE);
        assertTrue(chessBoard.contains(whiteKing));
        chessBoard = (DefaultBoardState) chessBoard.without(chessBoard.getPositionsOf(whiteKing).get(0));
        assertFalse(chessBoard.contains(whiteKing));
    }

    @Test
    public void testWithPieceAt() {
        DefaultBoardState chessBoard = new DefaultBoardState();
        ChessPiece newWhiteKing = new ChessPiece(ChessPieceType.KING, ChessColor.BLACK);
        chessBoard = (DefaultBoardState) chessBoard.withPieceAt(newWhiteKing, BoardPosition.at("D5"));
        assertEquals(chessBoard.getPieceAt(BoardPosition.at("D5")), newWhiteKing);
    }
}
