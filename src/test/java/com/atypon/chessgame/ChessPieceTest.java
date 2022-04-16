package com.atypon.chessgame;

import com.atypon.chessgame.model.ChessPiece;
import com.atypon.chessgame.model.ChessPieceType;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChessPieceTest {
    @Test
    public void testToString() {
        assertEquals(ChessPiece.getWhite(ChessPieceType.BISHOP).toString(), "WB");
        assertEquals(ChessPiece.getBlack(ChessPieceType.KING).toString(), "BK");
    }
}
