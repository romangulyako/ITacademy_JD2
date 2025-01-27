package itacademy.decorator.condiments;

import itacademy.decorator.Beverage;
import itacademy.decorator.CondimentDecorator;

public class Soy extends CondimentDecorator {
    private final Beverage beverage;

    public Soy(final Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    public double cost() {
        double add;

        if (Size.SMALL.equals(this.getSize())) {
            add = 0.15;
        } else if (Size.MIDDLE.equals(this.getSize())) {
            add = 0.25;
        } else {
            add = 0.35;
        }

        return beverage.cost() + add;
    }
}
