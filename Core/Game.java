package Core;

import Interfaces.Dice;
import Interfaces.TurnStrategy;
import Models.Board;
import Models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Game {
    private Board board;
    private Dice dice;
    private TurnStrategy turnStrategy;
    private Queue<Player> players;
    private List<Player> winners;

    public Game(Board board, Dice dice, TurnStrategy turnStrategy, Queue<Player> players) {
        this.board = board;
        this.dice = dice;
        this.turnStrategy = turnStrategy;
        this.players = players;
        this.winners = new ArrayList<>();
    }

    public void play() {
        System.out.println("=== Starting Snake & Ladder Game ===");
        System.out.println("Board Size: " + board.getSize());
        System.out.println("Players: ");
        for (Player p : players) {
            System.out.print(p.getName() + " ");
        }
        System.out.println("\n");

        while (players.size() >= 2) {
            Player currentPlayer = players.poll();
            System.out.println(currentPlayer.getName() + "'s turn. Current Position: " + currentPlayer.getPos());

            int moves = turnStrategy.getMoves(dice);
            System.out.println(currentPlayer.getName() + " rolled total moves: " + moves);

            int newPos = currentPlayer.getPos() + moves;

            if (newPos > board.getSize()) {
                System.out.println("Move invalid, needs exactly " + (board.getSize() - currentPlayer.getPos()) + " to win. Staying at " + currentPlayer.getPos() + "\n");
                players.offer(currentPlayer);
            } else if (newPos == board.getSize()) {
                System.out.println(currentPlayer.getName() + " reached the final cell and WON!\n");
                currentPlayer.setPos(newPos);
                winners.add(currentPlayer);
            } else {
                int finalPos = board.getFinalPos(newPos);
                System.out.println(currentPlayer.getName() + " moved to " + finalPos + "\n");
                currentPlayer.setPos(finalPos);
                
                if (finalPos == board.getSize()) {
                    System.out.println(currentPlayer.getName() + " reached the final cell and WON!\n");
                    winners.add(currentPlayer);
                } else {
                    players.offer(currentPlayer);
                }
            }
        }

        System.out.println("=== GAME OVER ===");
        System.out.println("Winners in order:");
        for (int i = 0; i < winners.size(); i++) {
            System.out.println((i + 1) + ". " + winners.get(i).getName());
        }
        if (!players.isEmpty()) {
            System.out.println("Loser: " + players.poll().getName());
        }
    }
}
