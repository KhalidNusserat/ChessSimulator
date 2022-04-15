package com.atypon.chessgame;

import com.atypon.chessgame.controller.movechecker.DummyMoveChecker;
import com.atypon.chessgame.model.ChessColor;
import com.atypon.chessgame.model.ChessGameModel;
import com.atypon.chessgame.model.DefaultChessGameModel;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DummyMoveCheckerTest {
    @Test
    public void shouldCheckMoves() {
        ChessGameModel chessGameModel = new DefaultChessGameModel("Khalid", "Bin Hatem");
        DummyMoveChecker dummyMoveChecker = new DummyMoveChecker();
        MoveParser parser = new DefaultMoveParser();
        assertTrue(
                dummyMoveChecker.check(
                        parser.parse("move B1 B2", ChessColor.WHITE),
                        chessGameModel
                )
        );
    }
}
