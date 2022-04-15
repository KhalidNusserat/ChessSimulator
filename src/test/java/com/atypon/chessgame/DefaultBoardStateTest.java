package com.atypon.chessgame;

import com.atypon.chessgame.model.BoardPosition;
import com.atypon.chessgame.model.ChessColor;
import com.atypon.chessgame.model.ChessPiece;
import com.atypon.chessgame.model.ChessPieceType;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DefaultBoardStateTest {
    @Test
    public void testInitialBoard() {
        com.atypon.chessgame.model.DefaultBoardState chessBoard = new com.atypon.chessgame.model.DefaultBoardState();
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
        com.atypon.chessgame.model.DefaultBoardState chessBoard = new com.atypon.chessgame.model.DefaultBoardState();
        chessBoard = (com.atypon.chessgame.model.DefaultBoardState) chessBoard.withSwapped(BoardPosition.at("A2"), BoardPosition.at("A4"));
        assertNull(chessBoard.getPieceAt(BoardPosition.at("A2")));
        assertEquals(chessBoard.getPieceAt(BoardPosition.at("A4")).type(), ChessPieceType.PAWN);
        chessBoard = (com.atypon.chessgame.model.DefaultBoardState) chessBoard.withSwapped(BoardPosition.at("A3"), BoardPosition.at("A2"));
        assertNull(chessBoard.getPieceAt(BoardPosition.at("A3")));
        assertNull(chessBoard.getPieceAt(BoardPosition.at("A2")));
        chessBoard = (com.atypon.chessgame.model.DefaultBoardState) chessBoard.withSwapped(BoardPosition.at("A4"), BoardPosition.at("H1"));
        assertEquals(chessBoard.getPieceAt(BoardPosition.at("A4")).type(), ChessPieceType.ROOK);
        assertEquals(chessBoard.getPieceAt(BoardPosition.at("H1")).type(), ChessPieceType.PAWN);
    }

    @Test
    public void testWithout() {
        com.atypon.chessgame.model.DefaultBoardState chessBoard = new com.atypon.chessgame.model.DefaultBoardState();
        chessBoard = (com.atypon.chessgame.model.DefaultBoardState) chessBoard.without(BoardPosition.at("E8"));
        assertNull(chessBoard.getPieceAt(BoardPosition.at("E8")));
    }

    @Test
    public void testGetPositionOfType() {
        com.atypon.chessgame.model.DefaultBoardState chessBoard = new com.atypon.chessgame.model.DefaultBoardState();
        List<BoardPosition> positionsOfPawns = chessBoard.getPositionsOf(ChessPieceType.PAWN);
        assertEquals(positionsOfPawns.size(), 16);
    }

    @Test
    public void testGetPositionsOfPiece() {
        com.atypon.chessgame.model.DefaultBoardState chessBoard = new com.atypon.chessgame.model.DefaultBoardState();
        List<BoardPosition> positionsOfBlackRooks = chessBoard.getPositionsOf(
                new ChessPiece(ChessPieceType.ROOK, ChessColor.BLACK)
        );
        assertEquals(positionsOfBlackRooks.size(), 2);
        assertEquals(positionsOfBlackRooks.get(0), BoardPosition.at("A8"));
        assertEquals(positionsOfBlackRooks.get(1), BoardPosition.at("H8"));
    }

    @Test
    public void testContainsType() {
        com.atypon.chessgame.model.DefaultBoardState chessBoard = new com.atypon.chessgame.model.DefaultBoardState();
        assertTrue(chessBoard.contains(ChessPieceType.PAWN));
        List<BoardPosition> positionsOfPawns = chessBoard.getPositionsOf(ChessPieceType.PAWN);
        for (BoardPosition position : positionsOfPawns) {
            chessBoard = (com.atypon.chessgame.model.DefaultBoardState) chessBoard.without(position);
        }
        assertFalse(chessBoard.contains(ChessPieceType.PAWN));
    }

    @Test
    public void testContainsPiece() {
        com.atypon.chessgame.model.DefaultBoardState chessBoard = new com.atypon.chessgame.model.DefaultBoardState();
        ChessPiece whiteKing = new ChessPiece(ChessPieceType.KING, ChessColor.WHITE);
        assertTrue(chessBoard.contains(whiteKing));
        chessBoard = (com.atypon.chessgame.model.DefaultBoardState) chessBoard.without(chessBoard.getPositionsOf(whiteKing).get(0));
        assertFalse(chessBoard.contains(whiteKing));
    }

    @Test
    public void testWithPieceAt() {
        com.atypon.chessgame.model.DefaultBoardState chessBoard = new com.atypon.chessgame.model.DefaultBoardState();
        ChessPiece newWhiteKing = new ChessPiece(ChessPieceType.KING, ChessColor.BLACK);
        chessBoard = (com.atypon.chessgame.model.DefaultBoardState) chessBoard.withPieceAt(newWhiteKing, BoardPosition.at("D5"));
        assertEquals(chessBoard.getPieceAt(BoardPosition.at("D5")), newWhiteKing);
    }
}
