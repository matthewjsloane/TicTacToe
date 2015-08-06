package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ApplicationTest {

    private PrintStream printStream;
    private TicTacToeGame game;
    private BufferedReader reader;
    private Application app;
    private Player p1;
    private Player p2;

    @Before
    public void setUp() {

        printStream = mock(PrintStream.class);
        game = mock(TicTacToeGame.class);
        reader = mock(BufferedReader.class);
        p1 = mock(Player.class);
        p2 = mock(Player.class);
        app = new Application(game, printStream, reader, p1, p2);
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

        app.executeInput(1, p1);
        verify(game).redrawBoard(anyInt(), (Player) anyObject());
    }

    @Test
    public void shouldPrintMakeMoveWhenUserTurn() {

        app.printMakeMove(p1);
        verify(printStream).println(contains("turn"));
    }

    @Test
    public void shouldPrintInstructionsWhenGameStarts() {

        app.printInstructions();
        verify(printStream).println(contains("Welcome"));
    }

}