package itacademy.decorator.condiments;

import itacademy.decorator.Beverage;
import itacademy.decorator.CondimentDecorator;

public class Mocha extends CondimentDecorator {
    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    public double cost() {
        double add;

        if (Size.SMALL.equals(this.getSize())) {
            add = 0.1;
        } else if (Size.MIDDLE.equals(this.getSize())) {
            add = 0.2;
        } else {
            add = 0.3;
        }

        return beverage.cost() + add;
    }
}
