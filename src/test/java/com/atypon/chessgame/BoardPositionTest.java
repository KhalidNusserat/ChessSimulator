package com.atypon.chessgame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoardPositionTest {
    @Test
    void validPositions() {
        assertDoesNotThrow(() -> BoardPosition.at("A1"));
        assertDoesNotThrow(() -> BoardPosition.at("H3"));
        assertDoesNotThrow(() -> BoardPosition.at("C8"));
        assertDoesNotThrow(() -> BoardPosition.at("b2"));
        assertDoesNotThrow(() -> BoardPosition.at("e4"));
    }

    @Test
    void invalidPositions() {
        assertThrows(
                IllegalArgumentException.class,
                () -> BoardPosition.at("I1")
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> BoardPosition.at("A9")
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> BoardPosition.at("C10")
        );
    }
}
