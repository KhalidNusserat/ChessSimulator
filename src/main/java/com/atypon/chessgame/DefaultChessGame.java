package com.atypon.chessgame;

import com.atypon.chessgame.controllers.eventschecker.EventsChecker;
import com.atypon.chessgame.controllers.eventshandler.EventsHandler;
import com.atypon.chessgame.controllers.movechecker.DummyMoveChecker;
import com.atypon.chessgame.controllers.movechecker.MoveChecker;
import com.atypon.chessgame.model.ChessColor;
import com.atypon.chessgame.model.ChessGameModel;
import com.atypon.chessgame.model.DefaultChessGameModel;

public class DefaultChessGame {
    private final ChessGameModel chessGameModel;

    private final MoveParser moveParser;

    private final MoveChecker moveChecker;

    private EventsChecker eventsChecker;

    private EventsHandler eventsHandler;

    public DefaultChessGame(String whitePlayer, String blackPlayer) {
        chessGameModel = new DefaultChessGameModel(whitePlayer, blackPlayer);
        moveParser = new DefaultMoveParser();
        moveChecker = new DummyMoveChecker();
    }

    public void playWhite(String move) {
        try {
            moveParser.parse(move, ChessColor.WHITE);
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
        }
    }
}
