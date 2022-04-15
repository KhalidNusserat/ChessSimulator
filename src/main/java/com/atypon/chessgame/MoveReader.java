package com.atypon.chessgame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MoveReader {
    public static String readMove() {
        String input = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            input = reader.readLine();
            reader.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return input;
    }
}
