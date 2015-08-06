package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        TicTacToeGame game = new TicTacToeGame();
        Application app = new Application(game, System.out, new BufferedReader(new InputStreamReader(System.in)),
                          new Player('X'), new Player('O'));

        app.runGame();
    }
}
