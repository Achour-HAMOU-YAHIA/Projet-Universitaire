package findmyword;

import java.util.ArrayList;

public class Game {

    private static final int MAX_ATTEMPTS = 6;
    private static final int WORD_LENGTH = 5;

    private Word secretWord;
    private ArrayList<Word> attempts;
    private ArrayList<ArrayList<String>> results; 
    private String playerName;

    public Game(String playerName, WordRepository repository) {
        this.playerName = playerName;
        this.secretWord = repository.getWord();
        this.attempts = new ArrayList<Word>();
        this.results = new ArrayList<ArrayList<String>>(); 
    }

    public ArrayList<String> addAttempt(Word attempt) {
        ArrayList<String> result = this.analyze(attempt);  
        this.attempts.add(attempt);
        this.results.add(result);                          
        return result;
    }

    private ArrayList<String> analyze(Word attempt) {
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < WORD_LENGTH; i++) {
            String letter = attempt.getLetterAt(i);
            if (letter.equals(this.secretWord.getLetterAt(i))) {
                result.add("OK");
            } else if (this.secretWord.containsLetter(letter)) {
                result.add("PRESENT");
            } else {
                result.add("ABSENT");
            }
        }
        return result;
    }

    public boolean isWon() {
        if (this.attempts.isEmpty()) return false;
        Word lastAttempt = this.attempts.get(this.attempts.size() - 1);
        return lastAttempt.equals(this.secretWord);
    }

    public boolean isOver() {
        return this.isWon() || this.attempts.size() >= MAX_ATTEMPTS;
    }

    public int getScore() {
        if (!this.isWon()) return 0;
        return MAX_ATTEMPTS - this.attempts.size() + 1;
    }

    public String getPlayerName() { return this.playerName; }
    public int getNbAttempts() { return this.attempts.size(); }
    public ArrayList<Word> getAttempts() { return this.attempts; }
    public ArrayList<ArrayList<String>> getResults() { return this.results; }  
    public Word getSecretWord() { return this.secretWord; }
}