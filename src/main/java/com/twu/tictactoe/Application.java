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
            boolean validMove = false;
            int move = 0;
            while(!validMove) {
                move = Integer.parseInt(reader.readLine());
                if (game.isValidMove(move)) {
                    validMove = true;
                } else {
                    printInvalidMove();
                }
            }
            return move;
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
        Player currentPlayer = p1;

        while (!(game.boardIsFull() || game.playerHasWon())) {
            printMakeMove(currentPlayer);
            executeInput(enterMove(), currentPlayer);
            if (game.playerHasWon()){
                printWin(currentPlayer);
            }
            else if (currentPlayer.equals(p1)) {
                currentPlayer = p2;
            } else {
                currentPlayer = p1;
            }
        }

        if (game.boardIsFull()) {
            printDraw();
        }
    }

    public void executeInput(int s, Player player) {
        printStream.println(game.redrawBoard(s, player));
    }

    public void printInstructions() {
        printStream.println("Welcome to the Tic-Tac-Toe game. Moves are submitted via"
                            + " numbers corresponding to each spot, 1-9, left to right.");
    }

    public void printInvalidMove() {
        printStream.println("Location already taken. Please try again!");
    }

    public void printDraw() {
        printStream.println("Game over! It is a draw!");
    }

    public void printWin(Player p) {
        printStream.println("Game over! Player '" + p.toString() + "' has won the game!");
    }
}
