package com.atypon.chessgame.rendering;

import com.atypon.chessgame.model.BoardState;
import com.atypon.chessgame.model.Color;
import com.atypon.chessgame.model.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DefaultBoardRenderer implements BoardRenderer {
    private PieceStringifier pieceStringifier;

    public List<String> getRowPieces(List<Optional<Piece>> pieces) {
        List<String> row = new ArrayList<>();
        for (Optional<Piece> piece : pieces) {
            String pieceAsString = "";
            if (piece.isPresent()) {
                if (piece.get().color() == Color.WHITE) {
                    pieceAsString += TerminalColors.WHITE_TEXT;
                } else {
                    pieceAsString += TerminalColors.BLACK_TEXT;
                }
                pieceAsString += pieceStringifier.getString(piece.get());
                pieceAsString += TerminalColors.RESET;
            } else {
                pieceAsString += " ";
            }
            row.add(pieceAsString);
        }
        return row;
    }

    @Override
    public void setPieceStringifier(PieceStringifier pieceStringifier) {
        this.pieceStringifier = pieceStringifier;
    }

    @Override
    public void drawBoard(BoardState boardState) {
        for (List<Optional<Piece>> row : boardState) {
            for (String piece : getRowPieces(row)) {
                System.out.print(piece);
            }
            System.out.println();
        }
    }
}
