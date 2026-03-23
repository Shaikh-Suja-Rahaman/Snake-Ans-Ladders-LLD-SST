package Factories;

import Models.Jump;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SnakeFactory {
    // Generate n snakes where head > tail
    // Do not use extreme ends if possible, though strict requirement is just head > tail.
    public static Map<Integer, Jump> generate(int numSnakes, int boardSize) {
        Map<Integer, Jump> snakes = new HashMap<>();
        Random random = new Random();

        while (snakes.size() < numSnakes) {
            int head = random.nextInt(boardSize - 1) + 2; // 2 to boardSize
            int tail = random.nextInt(head - 1) + 1;      // 1 to head-1
            
            if (!snakes.containsKey(head)) {
                snakes.put(head, new Jump(head, tail));
            }
        }
        return snakes;
    }
}
