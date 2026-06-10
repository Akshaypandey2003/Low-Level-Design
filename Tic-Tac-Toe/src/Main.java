import java.util.Scanner;

import Entities.Game;
import Entities.Player;
import Entities.StandardRules;
import Enum.Symbol;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Tic-Tac-Toe! Invite your friends and enjoy the game.");

        // Create game with custom board size
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter board size (e.g., 3 for 3x3): ");
        int boardSize = scanner.nextInt();

        Game game = GameFactory.createGame(boardSize, new StandardRules());

        // Create players with custom symbols
        Player player1 = new Player(001, "Aditya", Symbol.X);
        Player player2 = new Player(002, "Harshita", Symbol.O);

        game.addPlayer(player1);
        game.addPlayer(player2);

        GameFactory.playGame(game);

        scanner.close();
    }
}