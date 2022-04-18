package com.atypon.chessgame;

import com.atypon.chessgame.controller.movevalidator.Move;
import com.atypon.chessgame.model.Color;
import com.atypon.chessgame.model.Position;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultMoveParser implements MoveParser {
    private static final String commandPattern = "^ *move +(\\S+) +(\\S+) *$";

    private static final String boardPositionPattern = "^[a-hA-H][1-8]$";

    private void validateBoardPositions(String... boardPositions) throws InvalidBoardPositionException {
        for (String boardPosition : boardPositions) {
            if (!boardPosition.matches(boardPositionPattern)) {
                throw new InvalidBoardPositionException(boardPosition);
            }
        }
    }

    @Override
    public Move parse(String moveCommand, Color playerColor) throws InvalidMoveCommandException, InvalidBoardPositionException {
        Matcher matcher = Pattern.compile(commandPattern).matcher(moveCommand);
        if (!matcher.matches()) {
            throw new InvalidMoveCommandException(moveCommand);
        }
        String from = matcher.group(1);
        String to = matcher.group(2);
        validateBoardPositions(from, to);
        return new Move(
                playerColor,
                Position.at(from),
                Position.at(to)
        );
    }
}
