package com.atypon.chessgame;

import com.atypon.chessgame.controller.movechecker.ChessMove;
import com.atypon.chessgame.model.BoardPosition;
import com.atypon.chessgame.model.Color;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultMoveParser implements MoveParser {
    private static final String commandPattern = "^ *move +(\\S+) +(\\S+) *$";

    private static final String boardPositionPattern = "^[a-hA-H][1-8]$";

    private void validateBoardPositions(String... boardPositions) throws InvalidBoardPosition {
        for (String boardPosition : boardPositions) {
            if (!boardPosition.matches(boardPositionPattern)) {
                throw new InvalidBoardPosition(boardPosition);
            }
        }
    }

    @Override
    public ChessMove parse(String moveCommand, Color playerColor) throws InvalidMoveCommand, InvalidBoardPosition {
        if (!moveCommand.matches(commandPattern)) {
            throw new InvalidMoveCommand(moveCommand);
        }
        Matcher matcher = Pattern.compile(commandPattern).matcher(moveCommand);
        String from = matcher.group(1);
        String to = matcher.group(2);
        validateBoardPositions(from, to);
        return new ChessMove(
                playerColor,
                BoardPosition.at(from),
                BoardPosition.at(to)
        );
    }
}
