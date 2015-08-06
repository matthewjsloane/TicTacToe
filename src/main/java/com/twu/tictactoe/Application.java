package com.twu.tictactoe;


import java.io.PrintStream;

public class Application {

    private PrintStream printStream;
    private TicTacToeGame game;

    public Application(TicTacToeGame game, PrintStream printStream) {

        this.printStream = printStream;
        this.game = game;
    }

    public void startGame() {
        printStream.println(game.drawBoard());
    }
}
