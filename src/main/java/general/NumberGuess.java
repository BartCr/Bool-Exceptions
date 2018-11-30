package general;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class NumberGuess {

    public static void main(String[] args) {

        Random rnd = new Random();
        int numberToGuess = rnd.nextInt(1000) + 1;
        int numberOfTries = 0;
        int guess;
        PrintStream out = null;
        try {
            out = getOut();
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStream in = null;
        try {
            in = getIn();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(in);
        boolean win = false;

        while (!win) {
            out.println("Guess a number between 1 and 1000");

            guess = scanner.nextInt();
            numberOfTries++;

            if (guess == numberToGuess) {
                win = true;
            } else if (guess < numberToGuess) {
                out.println("Your guess is too low");
            } else if (guess > numberToGuess) {
                out.println("Your guess is too high");
            }
        }

        out.println("You win!");
        out.println("The number was " + numberToGuess);
        out.println("It took you " + numberOfTries + " tries");
    }

    private static PrintStream getOut() throws IOException {
        return System.out;
    }

    private static InputStream getIn() throws IOException {
        return System.in;
    }
}
