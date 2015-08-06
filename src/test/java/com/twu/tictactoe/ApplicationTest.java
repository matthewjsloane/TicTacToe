package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by msloane on 8/6/15.
 */
public class ApplicationTest {

    private PrintStream printStream;
    private TicTacToeGame game;
    private BufferedReader reader;
    private Application app;

    @Before
    public void setUp() {

        printStream = mock(PrintStream.class);
        game = mock(TicTacToeGame.class);
        reader = mock(BufferedReader.class);
        app = new Application(game, printStream, reader);
    }

    @Test
    public void shouldCallDrawBoardWhenTicTacToeGameStarts() {

        app.startGame();
        verify(game).drawBoard();
    }

    @Test
    public void shouldReturnUserInputWhenInput() throws IOException {

        when(reader.readLine()).thenReturn("1");
        int input = app.enterMove();

        assertThat(input, is(Integer.parseInt(reader.readLine())));
    }

    @Test
    public void shouldRedrawBoardWhenInputExecuted() {

        app.executeInput(1);
        verify(game).redrawBoard(anyInt());
    }

    @Test
    public void shouldPrintMakeMoveWhenUserTurn() {

        app.printMakeMove();
        verify(printStream).println(contains("turn"));
    }


}