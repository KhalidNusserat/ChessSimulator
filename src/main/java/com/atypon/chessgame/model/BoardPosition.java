package com.atypon.chessgame.model;

import java.util.Objects;

public class BoardPosition{
    private final String position;

    public BoardPosition(String position) {
        if (position.matches("^[a-hA-H][1-8]$")) {
            this.position = position;
        } else {
            throw new IllegalArgumentException(position + " is not a valid chess position.");
        }
    }

    public static BoardPosition at(String position) {
        return new BoardPosition(position);
    }

    public char getRow() {
        return position.charAt(1);
    }

    public char getCol() {
        return position.charAt(0);
    }

    @Override
    public String toString() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardPosition position1 = (BoardPosition) o;
        return position.equalsIgnoreCase(position1.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position.toLowerCase());
    }
}
