import Core.Game;
import Factories.GameFactory;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Snake & Ladder!");
        
        System.out.print("Enter board dimension (n for n*n board): ");
        int n = scanner.nextInt();

        System.out.print("Enter number of players (x): ");
        int x = scanner.nextInt();

        System.out.print("Enter difficulty level (easy/hard): ");
        String diff = scanner.next();

        // Use GameFactory to initialize everything based on inputs
        Game game = GameFactory.createGame(n, x, diff);

        // Start the engine
        game.play();

        scanner.close();
    }
}
