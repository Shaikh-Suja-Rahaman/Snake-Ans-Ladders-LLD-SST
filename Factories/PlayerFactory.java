package Factories;

import Models.Player;

import java.util.LinkedList;
import java.util.Queue;

public class PlayerFactory {
    public static Queue<Player> createPlayers(int x) {
        Queue<Player> players = new LinkedList<>();
        for (int i = 1; i <= x; i++) {
            players.add(new Player("Player " + i));
        }
        return players;
    }
}
