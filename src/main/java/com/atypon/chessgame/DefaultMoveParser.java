package com.atypon.chessgame;

import com.atypon.chessgame.controller.movechecker.ChessMove;
import com.atypon.chessgame.model.BoardPosition;
import com.atypon.chessgame.model.ChessColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultMoveParser implements MoveParser {
    private static final String commandPattern = "^ *move +(\\S+) +(\\S+) *$";

    private static final String boardPositionPattern = "^[a-hA-H][1-8]$";

    private void validateBoardPosition(String boardPosition) throws InvalidBoardPosition {
        if (!boardPosition.matches(boardPositionPattern)) {
            throw new InvalidBoardPosition(boardPosition);
        }
    }

    @Override
    public ChessMove parse(String moveCommand, ChessColor playerColor) throws InvalidMoveCommand, InvalidBoardPosition {
        Pattern startWithMove = Pattern.compile(commandPattern);
        Matcher matcher = startWithMove.matcher(moveCommand);
        if (!matcher.matches()) {
            throw new InvalidMoveCommand(moveCommand);
        }
        String from = matcher.group(1);
        String to = matcher.group(2);
        validateBoardPosition(from);
        validateBoardPosition(to);
        return new ChessMove(
                playerColor,
                BoardPosition.at(from),
                BoardPosition.at(to)
        );
    }
}
