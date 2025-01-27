package itacademy.decorator.beverages;

import itacademy.decorator.Beverage;

public class Espresso extends Beverage {
    public Espresso() {
        super.setDescription("Espresso");
    }

    public double cost() {
        if (Size.SMALL.equals(this.getSize())) {
            return 0.9;
        } else if (Size.MIDDLE.equals(this.getSize())) {
            return 1.3;
        } else {
            return 1.7;
        }
    }
}
