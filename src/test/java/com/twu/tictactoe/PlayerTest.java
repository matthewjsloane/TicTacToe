package com.twu.tictactoe;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by msloane on 8/6/15.
 */
public class PlayerTest {

    @Test
    public void shouldReturnPlayerNameWhenToStringCalled() {

        Player p1 = new Player('X');
        assertEquals("X", p1.toString());
    }
}