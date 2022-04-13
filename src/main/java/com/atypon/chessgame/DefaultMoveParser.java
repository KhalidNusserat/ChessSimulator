package com.atypon.chessgame;

import com.atypon.chessgame.model.BoardPosition;
import com.atypon.chessgame.model.ChessColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultMoveParser implements MoveParser {
    private static final String pattern = "^move +([a-hA-H][1-8]) +([a-hA-H][1-8]) *$";

    @Override
    public Move parseMove(String move, ChessColor playerColor) {
        Pattern startWithMove = Pattern.compile(pattern);
        Matcher matcher = startWithMove.matcher(move);
        if (matcher.matches()) {
            String from = matcher.group(1);
            String to = matcher.group(2);
            return new Move(
                    playerColor,
                    BoardPosition.at(from),
                    BoardPosition.at(to)
            );
        }
        throw new IllegalArgumentException(move + " is not a recognised chess command");
    }
}
