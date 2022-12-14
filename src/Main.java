import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Hardcoded list of words for the program to choose from
        ArrayList<String> listOfWords = new ArrayList<String>();
        listOfWords.add("hi");
        listOfWords.add("hello");
        listOfWords.add("word");
        listOfWords.add("world");
        listOfWords.add("Zebra");
        listOfWords.add("christmas");
        listOfWords.add("computer");
        listOfWords.add("book");
        listOfWords.add("phone");
        listOfWords.add("school");
        listOfWords.add("project");
        listOfWords.add("snowflake");
        listOfWords.add("lamp");
        listOfWords.add("pool");
        listOfWords.add("clock");
        listOfWords.add("glasses");


        //scanner to read users input
        Scanner scanner = new Scanner(System.in);

        //initialize guess processor object with a list of words
        GuessProcessor guessProcessor = new GuessProcessor(listOfWords);

        //Let the user know how many letters the word has and asks to either guess a letter, whole word, or quit game
        System.out.println("Welcome to Hangman! Your word has "+guessProcessor.getWord().length()+" letters.  Guess your first letter or the whole word.  Type quit to quit.");
        //Read user input
        String input = scanner.nextLine();
        //until the user quits, keep going
        while (!input.equalsIgnoreCase("quit")) {
            //if the game continues, ask user to guess again
            if(guessProcessor.continueGame(input)) {
                System.out.println("Please guess again");
            } else {
                //Game over, initialize a new guess processor
                guessProcessor = new GuessProcessor(listOfWords);
                //ask user to guess again
                System.out.println("Your new word has "+guessProcessor.getWord().length()+" letters.  Guess your first letter or the whole word.  Type quit to quit.");
            }
            input = scanner.nextLine();
        }
    }

}