import java.util.Random;
import java.util.Scanner;

// Player class (Encapsulation)
class Player {

    private int position;

    Player() {
        position = 0;
    }

    int getPosition() {
        return position;
    }

    void setPosition(int p) {
        position = p;
    }

    void move(int steps) {
        position += steps;
    }
}

// Parent Board Class (Polymorphism base)
class Board {

    // this method will be overridden in child class
    int checkPosition(int pos) {
        return pos;
    }
}

// Child Class (Polymorphism - Method Overriding)
class SnakeLadderBoard extends Board {

    //overriding
    int checkPosition(int pos) {

        // snakes
        if (pos == 99) return 54;
        if (pos == 70) return 55;
        if (pos == 52) return 42;

        // ladders
        if (pos == 4)  return 25;
        if (pos == 33) return 49;
        if (pos == 50) return 69;

        return pos;
    }
}

// Game class (Uses OOPS concepts)
class Game {

    private Player player;
    private Random rand;
    private Board board;

    Game() {
        player  = new Player();
        rand    = new Random();

        // Polymorphism used here:
        board   = new SnakeLadderBoard();  // parent ref → child object
    }

    void start() {

        Scanner sc = new Scanner(System.in);

        System.out.println("---- Snake & Ladder Game (OOPS + Polymorphism) ----\n");

        while (player.getPosition() < 100) {

            System.out.print("Press 1 to roll dice: ");
            int opt = sc.nextInt();

            if (opt == 1) {

                int dice = rand.nextInt(6) + 1;
                System.out.println("Dice: " + dice);

                player.move(dice);

                int pos = player.getPosition();

                // apply snakes & ladders (polymorphism call)
                int newPos = board.checkPosition(pos);

                if (newPos != pos) {
                    System.out.println("Jump! " + pos + " -> " + newPos);
                }

                player.setPosition(newPos);

                // exact win rule
                if (player.getPosition() > 100) {
                    player.setPosition(pos);
                    System.out.println("You need exact number to win!");
                }

                System.out.println("Current Position : " + player.getPosition());
            }
        }

        System.out.println("\nYou reached 100 and you won");
    }
}

// main class
public class SnakeLadderWithOops {

    public static void main(String[] args) {

        Game g = new Game();
        g.start(); // calling method
    }
}
