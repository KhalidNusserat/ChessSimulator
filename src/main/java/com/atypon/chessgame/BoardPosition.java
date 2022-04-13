package com.atypon.chessgame;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record BoardPosition(String position) {
    public static BoardPosition at(String position) {
        return new BoardPosition(position);
    }

    public BoardPosition(String position) {
        Pattern chessBoardPositionPattern = Pattern.compile("^[a-hA-H][1-8]$");
        Matcher matcher = chessBoardPositionPattern.matcher(position);
        if (matcher.matches()) {
            this.position = position;
        }
        else {
            throw new IllegalArgumentException(position + " is not a valid chess board position.");
        }
    }
}
