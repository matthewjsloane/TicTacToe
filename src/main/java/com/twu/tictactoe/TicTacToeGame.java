package com.twu.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;

/*
 * This Java source file was auto generated by running 'gradle buildInit --type java-library'
 * by 'msloane' at '8/6/15 1:19 PM' with Gradle 2.5
 *
 * @author msloane, @date 8/6/15 1:19 PM
 */
public class TicTacToeGame {

    private String horizontalDivider = "---------\n";
    private ArrayList<String> moves;

    public TicTacToeGame () {
        moves = new ArrayList<>();
        moves.add("   |   |   \n");
        moves.add("   |   |   \n");
        moves.add("   |   |   \n");
    }

    public String drawBoard() {
        return moves.get(0) + horizontalDivider + moves.get(1) + horizontalDivider + moves.get(2);
    }

    public String redrawBoard(int x, Player player) {
        StringBuilder newRow = new StringBuilder(moves.get(getRow(x)));
        newRow.setCharAt(getColStringLocation(x), player.toString().charAt(0));
        moves.set(getRow(x), newRow.toString());
        return drawBoard();
    }

    private int getRow(int x) {
        if (x > 6){
            return 2;
        } else if (x > 3) {
            return 1;
        } else {
            return 0;
        }
    }

    private int getColStringLocation(int x) {
        if (x % 3 == 0) {
            return 9;
        } else if (x % 3 == 2) {
            return 5;
        } else {
            return 1;
        }
    }



}
