package com.atypon.chessgame;

import com.atypon.chessgame.model.BoardPosition;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class BoardPositionTest {
    @Test
    public void shouldValidatePosition() {
        assertThrows(
                IllegalArgumentException.class,
                () -> BoardPosition.at("A12")
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> BoardPosition.at("I1")
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> BoardPosition.at("A 1")
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> BoardPosition.at(" a1")
        );
    }
}
