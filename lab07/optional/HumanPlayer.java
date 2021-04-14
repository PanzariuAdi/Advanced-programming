package lab07;

import java.util.Scanner;

public class HumanPlayer extends Player {

    @Override
    public void playGame() {
        if (!this.getBoard().getTokens().isEmpty()) {
            this.getBoard().stringBoard();

            if (this.getChoosedTokens().size() > 0)
                System.out.println("\nYour tokens : " + playerTokens());

        }
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\nEnter first number : ");
        int firstNumber = keyboard.nextInt();
        System.out.println("Enter second number : ");
        int secondNumber = keyboard.nextInt();

        try {
            getToken(firstNumber * secondNumber - 1);
        } catch (Exception e) {
            System.out.println("Index out of bounds !");
        }
    }
}
