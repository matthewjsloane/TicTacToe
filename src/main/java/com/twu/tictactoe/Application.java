package com.twu.tictactoe;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Application {

    private PrintStream printStream;
    private BufferedReader reader;
    private TicTacToeGame game;

    public Application(TicTacToeGame game, PrintStream printStream, BufferedReader reader) {

        this.printStream = printStream;
        this.game = game;
        this.reader = reader;
    }

    public void startGame() {
        printStream.println(game.drawBoard());
    }

    public int enterMove() {
        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            printStream.println("There was an error processing your input.");
            return -1;
        }
    }

    public void printMakeMove() {
        printStream.println("It is your turn. Please make a move:");
    }

    public void runGame () {
        startGame();
        printMakeMove();
        executeInput(enterMove());
    }

    public void executeInput(int s) {
        printStream.println(game.redrawBoard(s));
    }
}
