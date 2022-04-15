package com.atypon.chessgame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
