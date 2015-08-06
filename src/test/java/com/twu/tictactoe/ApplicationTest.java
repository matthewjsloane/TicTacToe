package com.twu.tictactoe;

import junit.framework.TestCase;
import junit.framework.TestResult;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by msloane on 8/6/15.
 */
public class ApplicationTest {

    @Test
    public void shouldDrawBoardWhenTicTacToeGameStarts() {

        PrintStream printStream = mock(PrintStream.class);
        TicTacToeGame game = mock(TicTacToeGame.class);
        Application app = new Application(game, printStream);

        app.startGame();

        verify(game).drawBoard();
    }


}