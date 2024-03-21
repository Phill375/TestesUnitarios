package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HangmanGameTest {

    @Test
    void gameEndsWhenAttemptsExhausted() {
        HangmanGame game = new HangmanGame("test");

        for (int i = 0; i < HangmanGame.MAX_ATTEMPTS; i++) {
            assertFalse(game.isGameOver());
            game.guessCharacter('x');
        }
        assertTrue(game.isGameOver());
        assertEquals("_ _ _ _", game.getVisibleWord());
        assertEquals("test", game.getSecretWord());
    }

    @Test
    void gameDoesNotEndWhenAttemptsRemaining() {
        HangmanGame game = new HangmanGame("test");

        for (int i = 0; i < HangmanGame.MAX_ATTEMPTS - 1; i++) {
            assertFalse(game.isGameOver());
            game.guessCharacter('x');
        }
        assertFalse(game.isGameOver());
        assertEquals("_ _ _ _", game.getVisibleWord());
        assertEquals(null, game.getSecretWord());
    }

    @Test
    void guessCharacter() {
        HangmanGame game = new HangmanGame("test");

        assertTrue(game.guessCharacter('t'));
        assertEquals("t _ _ t", game.getVisibleWord());

        assertFalse(game.guessCharacter('x'));
        assertEquals("t _ _ t", game.getVisibleWord());

        assertTrue(game.guessCharacter('e'));
        assertEquals("t e _ t", game.getVisibleWord());

        assertFalse(game.guessCharacter('e'));
        assertEquals("t e _ t", game.getVisibleWord());

        assertFalse(game.guessCharacter('1'));
        assertEquals("t e _ t", game.getVisibleWord());
    }
}
