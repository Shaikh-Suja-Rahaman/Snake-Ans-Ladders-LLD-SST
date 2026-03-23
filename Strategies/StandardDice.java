package Strategies;

import Interfaces.Dice;

public class StandardDice implements Dice {
    private int min;
    private int max;

    public StandardDice(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public int roll() {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
