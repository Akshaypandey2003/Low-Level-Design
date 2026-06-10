package Entities;

import java.util.*;

public class Game {
    private Board board;
    private Deque<Player> players;
    private Rules rule;
    Scanner scanner;

    public Game(int boardSize, Rules rule) {
        this.board = new Board(boardSize);
        this.players = new LinkedList<>();
        this.rule = rule;
        this.scanner = new Scanner(System.in);
    }

    public void addPlayer(Player player) {
        players.offer(player);
    }

    public void playGame() {
        if (players.size() < 2) {
            System.out.println("Need at least 2 players!");
            return;
        }

        while (true) {

            Player currentPlayer = players.peekFirst();
            board.displayBoard();

            System.out.print(currentPlayer.getName() + " (" + currentPlayer.getSymbol() + ") - Enter row and column: ");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (rule.isValidMove(board, row, col)) {
                board.makeMove(row, col, currentPlayer.getSymbol());
                if (board.getMovesCount() >= board.getSize() && rule.checkWin(board, currentPlayer)) {
                    System.out.println(currentPlayer.getName() + " wins!");
                    break;
                } else if (board.isBoardFull()) {
                    System.out.println("It's a draw!");
                    break;
                }

                players.removeFirst();
                players.addLast(currentPlayer);

            } else {
                System.out.println("Invalid move. Try again.");
            }

        }
    }
}
