package com.atypon.chessgame;

import com.atypon.chessgame.controller.movechecker.ChessMove;
import com.atypon.chessgame.model.BoardPosition;
import com.atypon.chessgame.model.ChessColor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class DefaultChessMoveParserTest {
    @Test
    public void shouldParse() {
        DefaultMoveParser parser = new DefaultMoveParser();
        assertEquals(
                parser.parse("move A1 B2", ChessColor.WHITE),
                new ChessMove(ChessColor.WHITE, BoardPosition.at("A1"), BoardPosition.at("B2"))
        );
        assertEquals(
                parser.parse("move  B1  C4 ", ChessColor.BLACK),
                new ChessMove(ChessColor.BLACK, BoardPosition.at("B1"), BoardPosition.at("C4"))
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> parser.parse("mv a1 b2", ChessColor.BLACK)
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> parser.parse("move a1 b2 a3", ChessColor.BLACK)
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> parser.parse("move a1 ", ChessColor.BLACK)
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> parser.parse("move a1 j2", ChessColor.BLACK)
        );
    }
}