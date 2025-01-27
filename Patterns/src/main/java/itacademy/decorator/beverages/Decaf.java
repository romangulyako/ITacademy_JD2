package itacademy.decorator.beverages;

import itacademy.decorator.Beverage;

public class Decaf extends Beverage {
    public Decaf() {
        super.setDescription("Decaf");
    }

    public double cost() {
        if (Size.SMALL.equals(this.getSize())) {
            return 0.7;
        } else if (Size.MIDDLE.equals(this.getSize())) {
            return 1.0;
        } else {
            return 1.3;
        }
    }
}
