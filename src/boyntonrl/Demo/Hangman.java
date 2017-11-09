/*
    SE1011
    Fall 2017
    Class Exercise -- Hangman
    William Retert
    11/7/17
 */
package boyntonrl.Demo;

import java.util.ArrayList;

/**
 * A Hangman game handles a single play-through of the pencil-
 * and-paper game "hangman".
 *
 * In hangman, a secret word is chosen, and blanks are drawn for
 * each letter in the word.  A miniature gallows is also drawn.
 * The player then starts guessing letters.  Each guess is either
 * in the word, at which point it is added to all blanks where the
 * letter occurs, or it is not.  For each guess which is wrong (not
 * in the word), an additional part of a stick figure is drawn on
 * the gallows.  The game ends when either the word is completely
 * revealed (Victory!) or the stick figure is completed (Defeat!)
 */
public class Hangman {
    /**
     * The character used to "cover up" (replace) letters
     * which the player has yet to guess.
     */
    public static final char HIDDEN_LETTER = '*';

    /**
     * Number of incorrect guesses until the user loses
     * head, body, right arm, left arm, right leg, left leg
     */
    public static final int MAX_WRONG_GUESSES = 6;

    private ArrayList<Character> secretWord;
    private ArrayList<Character> shownToUser;

    private int wrongGuesses;

    /**
     * Initialize a Hangman game using the provided secret word.
     * @param word The secret word the user is trying to guess.
     */
    public Hangman(String word){
        word = word.toLowerCase();
        secretWord = new ArrayList<>();
        shownToUser = new ArrayList<>();
        //TODO Initialize secretWord to contain the letters of word and
        for (int i = 0; i < word.length(); ++i){
            secretWord.add(word.charAt(i));
            //     shownToUser to contain that many HIDDEN_LETTERs
            shownToUser.add(HIDDEN_LETTER);
        }
        wrongGuesses = 0;
    }

    /**
     * Has the user made too many incorrect guesses?
     * @return true iff the user has reached MAX_WRONG_GUESSES
     */
    public boolean hasLost(){
        return wrongGuesses >= MAX_WRONG_GUESSES;
    }

    /**
     * Has the player guessed all letters in the word?
     * @return true iff all letters were correctly guessed.
     */
    public boolean hasWon(){
        return !shownToUser.contains(HIDDEN_LETTER);
    }

    /**
     * A Hangman displays as the secret word with HIDDEN_LETTER
     * replacing any letter which has not been guessed yet.
     * @return  The secret word, with unguessed letters occluded.
     */
    public String toString(){
        StringBuilder shownWord = new StringBuilder();
        // TODO Use a for-each loop to append each letter of shownToUser to shownWord
        for (Character letter : shownToUser){
            shownWord.append(letter);
        }
        return shownWord.toString();
    }

    /**
     * Guess whether the secret word contains a given letter.
     * @param letter The letter which is being guessed
     * @return true iff the guess was correct
     */
    public boolean makeGuess(char letter){
        letter = Character.toLowerCase(letter);
        int index = secretWord.indexOf(letter);
        if(index == -1 || hasLost()){
            ++wrongGuesses;
            return false; // guess failed
        } else {
            // TODO loop through the word shown to the user
            for (int i = 0; i < shownToUser.size(); ++i) {
                //      replacing hidden letters with the correct letter.
                if (secretWord.get(i) == letter){
                    shownToUser.set(i, letter);
                }
            }
            return true; // guess was correct
        }
    }
}
