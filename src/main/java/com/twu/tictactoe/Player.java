package com.twu.tictactoe;

import java.util.Arrays;
import java.util.HashSet;

public class Player {

    private char playerName;
    private HashSet<Integer> moves;

    public Player(char x) {
        playerName = x;
        moves = new HashSet<>();
    }

    public String toString() {
        return Character.toString(playerName);
    }

    public void addMove(int x) {
        moves.add(x);
    }

    public boolean hasWon() {
        // v. inefficient but wanted to finish implementation
        return (moves.containsAll(Arrays.asList(1, 2, 3)) ||
                moves.containsAll(Arrays.asList(4, 5, 6)) ||
                moves.containsAll(Arrays.asList(7, 8, 9)) ||
                moves.containsAll(Arrays.asList(1, 4, 7)) ||
                moves.containsAll(Arrays.asList(2, 5, 8)) ||
                moves.containsAll(Arrays.asList(3, 6, 9)) ||
                moves.containsAll(Arrays.asList(1, 5, 9)) ||
                moves.containsAll(Arrays.asList(7, 5, 3)));

    }
}
