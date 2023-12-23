package Java_Programming;
import java.util.Scanner;
import java.util.Random;


public class NumberGuessingGame {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            boolean playAgain = true;
            int totalAttempts = 0;
            int roundsWon = 0;


            while (playAgain) {
                System.out.println("Welcome to the Number Guessing Game!");
                int attempts = 0;
                int secretNumber = random.nextInt(100)+ 1;
                final int maxAttempts = 6;


                while(attempts < maxAttempts){
                    System.out.println("Guess the number (Attempt " + (attempts + 1) + "): ");
                    int userGuess = scanner.nextInt();
                    attempts++;

                    if(userGuess < secretNumber) {
                        System.out.println("Too low! Try a higher number.");
                    }
                    else if(userGuess > secretNumber){
                        System.out.println("Too high! Try a lower number.");
                    }
                    else{
                        System.out.println("Congratulations! You have gussed the number " + secretNumber + " correctly in" + attempts + "attempts!");
                        totalAttempts += attempts;
                        roundsWon++;
                        break;
                    }
                }

                if(attempts == maxAttempts){
                    System.out.println("Sorry, You have used all your attempts. The number was " + secretNumber + ".");
                }


                System.out.println("Do you want to play again? (yes/no): ");
                String playAgainInput = scanner.next();
                if(!playAgainInput.equalsIgnoreCase("yes")){
                    playAgain = false;
                }
                
            }

            System.out.println("ThanKs for playing! Rounds won:" + roundsWon + ".Average attempts per round: " + (totalAttempts / (double) roundsWon));
        }


    }
}
