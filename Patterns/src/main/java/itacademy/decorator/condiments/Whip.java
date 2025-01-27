package itacademy.decorator.condiments;

import itacademy.decorator.Beverage;
import itacademy.decorator.CondimentDecorator;

public class Whip extends CondimentDecorator {
    private final Beverage beverage;

    public Whip(final Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    public double cost() {
        double add;

        if (Size.SMALL.equals(this.getSize())) {
            add = 0.3;
        } else if (Size.MIDDLE.equals(this.getSize())) {
            add = 0.4;
        } else {
            add = 0.5;
        }

        return beverage.cost() + add;
    }
}
