package com.atypon.chessgame;

import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ChessGame chessGame = new DummyChessGame("Phoenix", "Maya");
        while (!chessGame.isDone()) {
            if (chessGame.isWhiteTurn()) {
                chessGame.playWhite(scanner.nextLine());
            }
            else {
                chessGame.playBlack(scanner.nextLine());
            }
        }
        chessGame.printWinnerName();
        scanner.close();
    }
}
