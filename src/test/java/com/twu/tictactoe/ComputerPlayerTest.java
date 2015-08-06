package com.twu.tictactoe;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;

public class ComputerPlayerTest {

    @Test
    public void shouldChooseEmptyLocationWhenMakingMove() {

        ComputerPlayer cp = new ComputerPlayer('X');
        TicTacToeGame game = mock(TicTacToeGame.class);
        List<Integer> computerMoves = new ArrayList<>();
        for (int x = 0; x < 9; x++) {
            computerMoves.add(cp.makeMove());
        }
        HashSet<Integer> set = new HashSet<>(computerMoves);
        assertFalse(computerMoves.size() > set.size());

    }
}