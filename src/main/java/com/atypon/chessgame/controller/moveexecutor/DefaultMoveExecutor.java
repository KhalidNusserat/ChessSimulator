package com.atypon.chessgame.controller.moveexecutor;

import com.atypon.chessgame.controller.movevalidator.Move;
import com.atypon.chessgame.model.GameModel;
import com.atypon.chessgame.model.Piece;
import com.atypon.chessgame.model.PieceType;

import java.util.List;
import java.util.Set;

public class DefaultMoveExecutor implements MoveExecutor {
    @Override
    public void execute(Move move, GameModel gameModel) {
        Piece firstPiece = gameModel.getCurrentBoardState().getPieceAt(move.from());
        Piece secondPiece = gameModel.getCurrentBoardState().getPieceAt(move.to());
        if (firstPiece != null && secondPiece != null && firstPiece.color() == secondPiece.color()) {
            Set<PieceType> pieceTypes = Set.of(firstPiece.type(), secondPiece.type());
            if (pieceTypes.containsAll(List.of(PieceType.ROOK, PieceType.KING))) {
                gameModel.setCurrentBoardState(
                        gameModel.getCurrentBoardState().with(move.from()).swappedWith(move.to())
                );
            }
        } else {
            gameModel.setCurrentBoardState(
                    gameModel.getCurrentBoardState()
                            .with(firstPiece)
                            .at(move.to())
                            .without(move.from())
            );
        }
    }
}
