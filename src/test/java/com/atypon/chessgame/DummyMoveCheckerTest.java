package com.atypon.chessgame;

import static org.junit.jupiter.api.Assertions.*;

import com.atypon.chessgame.controllers.movechecker.DummyMoveChecker;
import com.atypon.chessgame.model.ChessColor;
import com.atypon.chessgame.model.ChessGameModel;
import com.atypon.chessgame.model.DefaultChessGameModel;
import org.junit.jupiter.api.Test;

public class DummyMoveCheckerTest {
    @Test
    void checkMoves() {
        ChessGameModel chessGameModel = new DefaultChessGameModel("Khalid", "Bin Hatem");
        DummyMoveChecker dummyMoveChecker = new DummyMoveChecker();
        MoveParser parser = new DefaultMoveParser();
        assertTrue(
                dummyMoveChecker.checkMove(
                        parser.parseMove("move B1 B2", ChessColor.WHITE),
                        chessGameModel
                )
        );
    }
}
