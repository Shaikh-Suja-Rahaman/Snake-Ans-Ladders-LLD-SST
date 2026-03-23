package Factories;

import Models.Jump;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LadderFactory {
    // Generate n ladders where end > start
    public static Map<Integer, Jump> generate(int numLadders, int boardSize, Map<Integer, Jump> existingSnakes) {
        Map<Integer, Jump> ladders = new HashMap<>();
        Random random = new Random();

        while (ladders.size() < numLadders) {
            int start = random.nextInt(boardSize - 2) + 1; // 1 to boardSize-2
            int end = random.nextInt(boardSize - start) + start + 1; // start+1 to boardSize
            
            // To prevent cycle trivially: ensure ladder start is not a snake head
            // and maybe no loops like ladder end -> snake head -> ladder start.
            // A simple prevention to keep no obvious cycles:
            if (!existingSnakes.containsKey(start) && !ladders.containsKey(start)) {
                ladders.put(start, new Jump(start, end));
            }
        }
        return ladders;
    }
}
