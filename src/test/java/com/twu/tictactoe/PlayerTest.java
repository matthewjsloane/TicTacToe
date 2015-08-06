package com.twu.tictactoe;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {

    Player p1;

    @Before
    public void setUp(){
        p1 = new Player('X');
    }

    @Test
    public void shouldReturnPlayerNameWhenToStringCalled() {
        assertEquals("X", p1.toString());
    }

    @Test public void shouldReturnFalseWhenPlayerHasNotWon() {
        p1.addMove(1);
        p1.addMove(2);
        assertFalse(p1.hasWon());
        p1.addMove(5);
        p1.addMove(7);
        assertFalse(p1.hasWon());
    }

    @Test public void shouldReturnTrueWhenPlayerHasWon() {

        p1.addMove(1);
        p1.addMove(2);
        p1.addMove(5);
        p1.addMove(9);
        p1.addMove(8);
        assertTrue(p1.hasWon());
    }
}