import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

// simple custom exception
class InvalidChoiceException extends Exception {
    InvalidChoiceException(String msg) {
        super(msg);
    }
}

public class SnakeLadderExceptions {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int pos = 0;

        System.out.println("----- Snake & Ladder Game -----");
        System.out.println("Reach 100 to Win!\n");

        while (pos < 100) {

            System.out.print("Press 1 to roll dice : ");

            int ch = 0;

            try {
                ch = sc.nextInt();

                // custom exception usage
                if (ch != 1) {
                    throw new InvalidChoiceException("You must press 1 only.");
                }

                int dice = r.nextInt(6) + 1;
                System.out.println("Dice : " + dice);

                pos += dice;

                // ladders
                if (pos == 4)  pos = 25;
                if (pos == 33) pos = 49;
                if (pos == 50) pos = 69;

                // snakes
                if (pos == 99) pos = 54;
                if (pos == 70) pos = 55;
                if (pos == 52) pos = 42;

                if (pos > 100) {
                    pos -= dice;
                    System.out.println("Need exact number to reach 100.");
                }

                System.out.println("Current Position : " + pos);
                System.out.println("------------------------------");
            }

            catch (InputMismatchException e) {
                System.out.println("Only numbers allowed!");
                sc.nextLine();  // clear wrong input
                continue;
            }

            catch (InvalidChoiceException ice) {
                System.out.println(ice.getMessage());
                continue;
            }

            catch (Exception e) {
                // general unexpected error
                System.out.println("Something went wrong! " + e);
                break;
            }
        }

        if (pos == 100) {
            System.out.println("\nYou Won the Game 🎉");
        }
    }
}
