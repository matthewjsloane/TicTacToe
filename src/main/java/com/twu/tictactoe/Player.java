package com.twu.tictactoe;

/**
 * Created by msloane on 8/6/15.
 */
public class Player {

    private char playerName;

    public Player(char x) {
        playerName = x;
    }

    public String toString() {
        return Character.toString(playerName);
    }
}
