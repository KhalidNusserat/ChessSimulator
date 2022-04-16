package com.atypon.chessgame;

import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ChessGame chessGame = new DummyChessGame("Phoenix", "Maya");
        chessGame.printCurrentBoard();
        while (!chessGame.isDone()) {
            System.out.print(" >> ");
            if (chessGame.isWhiteTurn()) {
                chessGame.playWhite(scanner.nextLine());
            } else {
                chessGame.playBlack(scanner.nextLine());
            }
            chessGame.printCurrentBoard();
        }
        chessGame.printWinnerName();
        scanner.close();
    }
}
