package com.atypon.chessgame;

import com.atypon.chessgame.controller.movechecker.DummyMoveChecker;
import com.atypon.chessgame.model.ChessColor;
import com.atypon.chessgame.model.ChessGameModel;
import com.atypon.chessgame.model.DefaultChessGameModel;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class DummyChessMoveCheckerTest {
    @Test
    public void shouldCheckMoves() {
        ChessGameModel chessGameModel = new DefaultChessGameModel("Khalid", "Bin Hatem");
        DummyMoveChecker dummyMoveChecker = new DummyMoveChecker();
        MoveParser parser = new DefaultMoveParser();
        try {
            assertTrue(
                    dummyMoveChecker.check(
                            parser.parse("move B1 B2", ChessColor.WHITE),
                            chessGameModel
                    )
            );
        } catch (InvalidMoveCommand e) {
            fail();
        }
    }
}
