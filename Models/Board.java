package Models;

import java.util.Map;

public class Board {
    private int size;
    private Map<Integer, Jump> snakes;
    private Map<Integer, Jump> ladders;

    public Board(int size, Map<Integer, Jump> snakes, Map<Integer, Jump> ladders) {
        this.size = size; // e.g., 100
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int getSize() {
        return size;
    }

    public int getFinalPos(int pos) {
        int currentPos = pos;
        
        while (true) {
            if (snakes.containsKey(currentPos)) {
                System.out.println("Swallowed by snake at " + currentPos + ", going down to " + snakes.get(currentPos).getEnd());
                currentPos = snakes.get(currentPos).getEnd();
            } else if (ladders.containsKey(currentPos)) {
                System.out.println("Climbed ladder at " + currentPos + ", going up to " + ladders.get(currentPos).getEnd());
                currentPos = ladders.get(currentPos).getEnd();
            } else {
                break;
            }
        }
        return currentPos;
    }
}
