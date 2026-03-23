package Factories;

import Interfaces.TurnStrategy;
import Strategies.EasyTurnStrategy;
import Strategies.HardTurnStrategy;

public class StratFactory {
    public static TurnStrategy getStrategy(String diff) {
        if (diff.equalsIgnoreCase("hard")) {
            return new HardTurnStrategy();
        }
        return new EasyTurnStrategy();
    }
}
