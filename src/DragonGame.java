import java.util.Random;
import java.util.Scanner;

public class DragonGame {

    private int dragonHealth;

    private int playerHealth;

    private Scanner scan;

    public static void introduceGame() {
        System.out.println("\033[0;33mWelcome to the Dragon Game!\033[0m");
        System.out.println("\033[0;33mYou find yourself in a dark cave...\033[0m");
    }

    public static int chooseCave() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\033[0;33mWhich cave will you enter? (1 or 2)");
        return scanner.nextInt();
    }



    private void exploreCave(int chosenCave) {
        System.out.println("\033[0;34mYou approach the cave...\033[0m");
        System.out.println("\033[0;34mIt's dark and spooky...\033[0m");
        System.out.println("\033[0;34mA large dragon jumps out in front of you and opens its jaws wide.\033[0m");
        System.out.println("\033[0;34mIt breathes fire! What will you do?\033[0m (1. Attack, 2. Run away)");

        Scanner scanner = new Scanner(System.in);
        int playerChoice = scanner.nextInt();

        if (playerChoice == 1) {
            attackDragon();
        } else if (playerChoice == 2) {
            runAway();
        } else {
            System.out.println("\033[0;31mInvalid choice. The dragon attacks you!\033[0m");
            dragonAttack();
        }
    }

    private void attackDragon() {
        int damage = new Random().nextInt(20) + 1;
        dragonHealth -= damage;

        System.out.println("You attack the dragon and deal " + damage + " damage!");
        displayDragonStatus();

        if (dragonHealth <= 0) {
            System.out.println("\033[0;32mCongratulations! You defeated the dragon!\033[0m");
        } else {
            dragonAttack();
        }
        System.out.println("Attack again? y / n");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("y")) {
            attackDragon();
        }
    }

    private void runAway() {
        System.out.println("\033[0;35mYou run away from the dragon. Safe for now!\033[0m");
    }

    private void dragonAttack() {
        int damage = new Random().nextInt(15) + 1;
        int rand = (int) (Math.random() * 10);
        if (rand < 5) {
            System.out.println("\033[0;32mYou dodged the dragon's attack!\033[0m");
        } else {
            System.out.println("\033[0;31mThe dragon counterattacks and deals " + damage + " damage!\033[0m");
            playerHealth -= damage;
        }
        displayDragonStatus();
        displayPlayerStatus();
    }

    private void displayDragonStatus() {
        System.out.println("Dragon's Health: " + "\033[0;32m" + dragonHealth + "\033[0m");
    }

    private void displayPlayerStatus() {
        System.out.println("Player's Health: " + "\033[0;32m" + playerHealth + "\033[0m");
    }

    public void playGame(int health) {
        scan = new Scanner(System.in);
        dragonHealth = health;
        playerHealth = 100;
        introduceGame();
        int chosenCave = chooseCave();
        exploreCave(chosenCave);
    }
}

