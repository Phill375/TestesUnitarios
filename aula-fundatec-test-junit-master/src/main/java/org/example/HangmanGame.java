package org.example;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HangmanGame {
    public static final int MAX_ATTEMPTS = 6;
    private Set<String> words;
    private String secretWord;
    private StringBuilder currentGuess;
    private int attemptsLeft;
    private Set<Character> guessedLetters;

    public HangmanGame() {
        words = new HashSet<>();
        words.add("java");
        words.add("jogador");
        words.add("vitória");
        words.add("derrota");
        words.add("empate");
        words.add("luis");
        words.add("arena");
        words.add("gremio");
        words.add("mundial");
        words.add("libertadores");
        initializeGame();
    }

    public HangmanGame(String word) {
        words = new HashSet<>();
        words.add(word);

        initializeGame();
    }

    private void initializeGame() {
        Random random = new Random();
        int index = random.nextInt(words.size());
        secretWord = (String) words.toArray()[index];
        currentGuess = new StringBuilder("_".repeat(secretWord.length()));
        attemptsLeft = MAX_ATTEMPTS;
        guessedLetters = new HashSet<>();
    }

    public String getCurrentGuess() {
        return currentGuess.toString();
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public boolean isGameOver() {
        return attemptsLeft <= 0 || !currentGuess.toString().contains("_");
    }

    public String getVisibleWord() {
        return currentGuess.toString().replace("", " ").trim();
    }

    public boolean guessCharacter(char c) {
        if (guessedLetters.contains(c)) {
            System.out.println("Letra já foi utilizada.");
            return false;
        }

        boolean found = false;
        guessedLetters.add(c);
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == c && currentGuess.charAt(i) == '_') {
                currentGuess.setCharAt(i, c);
                found = true;
            }
        }
        if (!found) {
            attemptsLeft--;
        }
        return found;
    }

    public String getSecretWord() {
        if (isGameOver() && attemptsLeft <= 0) {
            return secretWord;
        }
        return null;
    }
}
