package com.atypon.chessgame.model;

import java.util.Objects;

public record BoardPosition(String position) {
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
