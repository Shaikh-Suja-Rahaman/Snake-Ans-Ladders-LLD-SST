package Strategies;

import Interfaces.Dice;
import Interfaces.TurnStrategy;

public class EasyTurnStrategy implements TurnStrategy {
    @Override
    public int getMoves(Dice dice) {
        // Just roll the dice once
        return dice.roll();
    }
}
