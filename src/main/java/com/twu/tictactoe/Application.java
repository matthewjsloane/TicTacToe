package com.twu.tictactoe;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Application {

    private PrintStream printStream;
    private BufferedReader reader;
    private TicTacToeGame game;
    private Player p1;
    private Player p2;

    public Application(TicTacToeGame game, PrintStream printStream, BufferedReader reader, Player p1, Player p2) {

        this.printStream = printStream;
        this.game = game;
        this.reader = reader;
        this.p1 = p1;
        this.p2 = p2;
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

    public void printMakeMove(Player player) {
        printStream.println("It is " + player.toString() + "'s turn. Please make a move:");
    }

    public void runGame () {
        startGame();
        printMakeMove(p1);
        executeInput(enterMove(), p1);
        printMakeMove(p2);
        executeInput(enterMove(), p2);

    }

    public void executeInput(int s, Player player) {
        printStream.println(game.redrawBoard(s, player));
    }

    public void printInstructions() {
        printStream.println("Welcome to the Tic-Tac-Toe game. Moves are submitted via"
                            + " numbers corresponding to each spot, 1-9, left to right.");
    }
}
