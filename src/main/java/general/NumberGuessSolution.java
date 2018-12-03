package general;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessSolution {

    public static void main(String[] args) {

        Random rnd = new Random();
        int numberToGuess = rnd.nextInt(1000) + 1;
        int numberOfTries = 0;
        int guess;
        PrintStream out = creatOut();
        InputStream in = createIn();
        Scanner scanner = new Scanner(in);

        boolean win = false;

        while (!win) {
            out.println("Guess a number between 1 and 1000");

            try {
                guess = scanner.nextInt();
                numberOfTries++;

                if (guess == numberToGuess) {
                    win = true;
                } else if (guess < numberToGuess) {
                    out.println("Your guess is too low");
                } else if (guess > numberToGuess) {
                    out.println("Your guess is too high");
                }
            } catch (InputMismatchException e) {
                out.println("You did not enter a number");
                scanner.skip(".*");
            }
        }

        out.println("You win!");
        out.println("The number was " + numberToGuess);
        out.println("It took you " + numberOfTries + " tries");
    }


    private static PrintStream creatOut() {
        try {
            return getOut();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static InputStream createIn() {
        try {
            return getIn();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static PrintStream getOut() throws IOException {
        return System.out;
    }

    private static InputStream getIn() throws IOException {
        return System.in;
    }
}
