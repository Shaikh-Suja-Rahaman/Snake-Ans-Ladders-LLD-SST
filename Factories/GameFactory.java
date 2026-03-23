package Factories;

import Core.Game;
import Interfaces.Dice;
import Interfaces.TurnStrategy;
import Models.Board;
import Models.Jump;
import Models.Player;
import Strategies.StandardDice;

import java.util.Map;
import java.util.Queue;

public class GameFactory {
    public static Game createGame(int n, int x, String diff) {
        int boardSize = n * n;
        
        // Factories handle generation
        Map<Integer, Jump> snakes = SnakeFactory.generate(n, boardSize);
        Map<Integer, Jump> ladders = LadderFactory.generate(n, boardSize, snakes);
        
        Board board = new Board(boardSize, snakes, ladders);
        Dice dice = new StandardDice(1, 6);
        TurnStrategy turnStrategy = StratFactory.getStrategy(diff);
        Queue<Player> players = PlayerFactory.createPlayers(x);
        
        return new Game(board, dice, turnStrategy, players);
    }
}
