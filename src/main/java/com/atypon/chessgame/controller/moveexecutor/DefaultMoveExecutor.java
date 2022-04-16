package com.atypon.chessgame.controller.moveexecutor;

import com.atypon.chessgame.controller.movechecker.ChessMove;
import com.atypon.chessgame.model.GameModel;
import com.atypon.chessgame.model.Piece;
import com.atypon.chessgame.model.PieceType;

import java.util.List;
import java.util.Set;

public class DefaultMoveExecutor implements MoveExecutor {
    @Override
    public void execute(ChessMove chessMove, GameModel gameModel) {
        Piece firstPiece = gameModel.getCurrentBoardState().getPieceAt(chessMove.from());
        Piece secondPiece = gameModel.getCurrentBoardState().getPieceAt(chessMove.to());
        if (firstPiece != null && secondPiece != null && firstPiece.color() == secondPiece.color()) {
            Set<PieceType> pieceTypes = Set.of(firstPiece.type(), secondPiece.type());
            if (pieceTypes.containsAll(List.of(PieceType.ROOK, PieceType.KING))) {
                gameModel.setCurrentBoardState(
                        gameModel.getCurrentBoardState().with(chessMove.from()).swappedWith(chessMove.to())
                );
            }
        } else {
            gameModel.setCurrentBoardState(
                    gameModel.getCurrentBoardState()
                            .with(firstPiece)
                            .at(chessMove.to())
                            .without(chessMove.from())
            );
        }
    }
}
