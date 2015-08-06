package com.twu.tictactoe;

public class Main {

    public static void main(String[] args) {

        TicTacToeGame game = new TicTacToeGame();
        Application app = new Application(game, System.out);

        app.startGame();
    }
}
