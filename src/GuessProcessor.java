import java.util.Arrays;
import java.util.List;
import java.util.Random;

//This class is meant to decide the state of the game
public class GuessProcessor {

    Random rand = new Random(); //instance of random class

    //instance variables
    private String word; //word user has to guess
    private String[] guess;//users guess
    private int guessesLeft = 6; //number guesses left, defaults to 6

    /**
     * constructor
     * @param listOfWords list of words for the game to pick from
     */

    public GuessProcessor(List<String> listOfWords) {
        //generate random values from 0- the size of the list
        int upperbound = listOfWords.size();
        int randomInt = rand.nextInt(upperbound);

        //pick a word
        word = listOfWords.get(randomInt).toLowerCase();
        guess = new String[word.length()]; //initilize guess array to the length of the word
        Arrays.fill(guess, "_"); //fill the guess array with underscores
    }

    public String getWord() {
        return this.word;
    }

    //returns true if game continues, false to start game over
    public boolean continueGame(String input) {
        input = input.toLowerCase();
        //if the input is a letter, the program checks to see if the letter is in that word
        if(input.length() == 1) {
            //If the word contains the letter, the program substitutes the letter for the underscore, which represents the letters in the word,
            // and prints the underscores with the letter.
            if (word.contains(input)) {
                int index = word.indexOf(input); //find index of letter in word
                //while we keep finding the letter in word, keep looping
                while (index >= 0) {
                    guess[index] = input; //replace underscore with letter
                    index = word.indexOf(input, index + 1); //keeps looking through the remainder of word
                }
                //If all underscores are filled (word is guessed, the game is won
                if (String.join("", guess).equals(word)) {
                    //all underscores are filled
                    System.out.println("Congratulations! You won!");
                    return false;
                } else {
                    //keep asking for new letters if the word is not guessed
                    System.out.println("The word contains the letter, result " + String.join("", guess));
                }
            } else {
                //If the word does not contain the letter, the program says “the word does not contain this letter” and tells the user how many guesses are left (subtracts 1 from the number of guesses)
                //decrement guesses
                guessesLeft--;
                if (guessesLeft == 0) {
                    System.out.println("Sorry, your guess is wrong and you have no guesses left. game over!");
                    return false;
                } else {
                    //If you still have guesses left, ask for another letter.
                    System.out.println("Sorry, the word does not contain this letter, you have " + guessesLeft + " guesses left");
                }
            }
        } else {
            //If the input is a word, the program checks to see if it is correct
            if(word.equals(input)) {
                //If the word is correct, the program says “Congratulations, you guessed correctly” and starts over
                System.out.println("You guessed correctly! Congratulations!");
                return false;
            } else {
                //decrement guesses
                guessesLeft--;
                if(guessesLeft == 0) {
                    System.out.println("Sorry, your guess is wrong and you have no guesses left. game over!");
                    return false;
                } else {
                    //If the word is not correct, the program says “sorry, you guessed incorrectly” and tells the user how many guesses are left
                    System.out.println("Sorry, your guess is wrong, you have " + guessesLeft + "guesses left");
                }
            }
        }
        //if we got here that means the game continues
        return true;
    }
}

