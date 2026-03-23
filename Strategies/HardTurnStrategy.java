package Strategies;

import Interfaces.Dice;
import Interfaces.TurnStrategy;

public class HardTurnStrategy implements TurnStrategy {
    @Override
    public int getMoves(Dice dice) {
        // In hard strategy, if you roll a 6, you roll again (up to 3 times)
        int totalMoves = 0;
        int rolls = 0;
        while (rolls < 3) {
            int currentRoll = dice.roll();
            totalMoves += currentRoll;
            rolls++;
            if (currentRoll != 6) {
                break;
            }
        }
        if (rolls == 3 && totalMoves == 18) {
            // If you rolled three 6s in a row, it resets to 0 (common rule version)
            return 0;
        }
        return totalMoves;
    }
}
