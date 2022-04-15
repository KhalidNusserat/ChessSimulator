package com.atypon.chessgame.controller.moveexecutor;

import com.atypon.chessgame.controller.movechecker.ChessMove;
import com.atypon.chessgame.model.ChessGameModel;
import com.atypon.chessgame.model.ChessPiece;
import com.atypon.chessgame.model.ChessPieceType;

import java.util.List;
import java.util.Set;

public class DefaultMoveExecutor implements MoveExecutor {
    @Override
    public void execute(ChessMove chessMove, ChessGameModel chessGameModel) {
        ChessPiece firstPiece = chessGameModel.getCurrentBoardState().getPieceAt(chessMove.from());
        ChessPiece secondPiece = chessGameModel.getCurrentBoardState().getPieceAt(chessMove.to());
        if (firstPiece != null && secondPiece != null && firstPiece.color() == secondPiece.color()) {
            Set<ChessPieceType> pieceTypes = Set.of(firstPiece.type(), secondPiece.type());
            if (pieceTypes.containsAll(List.of(ChessPieceType.ROOK, ChessPieceType.KING))) {
                chessGameModel.setCurrentBoardState(
                        chessGameModel.getCurrentBoardState().withSwapped(chessMove.from(), chessMove.to())
                );
            }
        } else {
            chessGameModel.setCurrentBoardState(
                    chessGameModel.getCurrentBoardState()
                            .withPieceAt(firstPiece, chessMove.to())
                            .without(chessMove.from())
            );
        }
    }
}
