package com.atypon.chessgame;

import com.atypon.chessgame.controllers.movechecker.Move;
import com.atypon.chessgame.model.BoardPosition;
import com.atypon.chessgame.model.ChessColor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DefaultMoveParserTest {
    @Test
    void parsing() {
        DefaultMoveParser parser = new DefaultMoveParser();
        assertEquals(
                parser.parseMove("move A1 B2", ChessColor.WHITE),
                new Move(ChessColor.WHITE, BoardPosition.at("A1"), BoardPosition.at("B2"))
        );
        assertEquals(
                parser.parseMove("move  B1  C4 ", ChessColor.BLACK),
                new Move(ChessColor.BLACK, BoardPosition.at("B1"), BoardPosition.at("C4"))
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> parser.parseMove("mv a1 b2", ChessColor.BLACK)
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> parser.parseMove("move a1 b2 a3", ChessColor.BLACK)
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> parser.parseMove("move a1 ", ChessColor.BLACK)
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> parser.parseMove("move a1 j2", ChessColor.BLACK)
        );
    }
}
