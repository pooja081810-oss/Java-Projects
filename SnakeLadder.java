import java.util.Random;
import java.util.Scanner;

public class SnakeLadder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int position = 0;

        System.out.println("Snake & Ladder Game Started!");

        while (position < 100) {
            System.out.print("Press 1 to Roll Dice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                int dice = rand.nextInt(6) + 1;
                System.out.println("You rolled: " + dice);

                position = position + dice;

                // Snakes
                if (position == 99) position = 54;
                if (position == 70) position = 55;
                if (position == 52) position = 42;

                // Ladders
                if (position == 4) position = 25;
                if (position == 33) position = 49;
                if (position == 50) position = 69;

                if (position > 100) {
                    position -= dice;
                    System.out.println("Cannot move, try again!");
                }

                System.out.println("Current Position: " + position);
            }
        }

        System.out.println("Congratulations ! You won the game");
    }
}
