package com.atypon.chessgame.rendering;

import com.atypon.chessgame.model.BoardState;

public interface BoardRenderer {
    void setPieceStringifier(PieceStringifier pieceStringifier);

    void drawBoard(BoardState boardState);
}
