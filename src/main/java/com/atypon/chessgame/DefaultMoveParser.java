package com.atypon.chessgame;

import com.atypon.chessgame.controller.movechecker.ChessMove;
import com.atypon.chessgame.model.BoardPosition;
import com.atypon.chessgame.model.ChessColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultMoveParser implements MoveParser {
    private static final String pattern = "^ *move +([a-hA-H][1-8]) +([a-hA-H][1-8]) *$";

    @Override
    public ChessMove parse(String moveCommand, ChessColor playerColor) throws InvalidMoveCommand {
        Pattern startWithMove = Pattern.compile(pattern);
        Matcher matcher = startWithMove.matcher(moveCommand);
        if (matcher.matches()) {
            String from = matcher.group(1);
            String to = matcher.group(2);
            return new ChessMove(
                    playerColor,
                    BoardPosition.at(from),
                    BoardPosition.at(to)
            );
        }
        throw new InvalidMoveCommand(moveCommand);
    }
}
