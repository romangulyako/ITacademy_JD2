package itacademy.decorator.beverages;

import itacademy.decorator.Beverage;

public class DarkRoast extends Beverage {
    public DarkRoast() {
        super.setDescription("Dark Roast");
    }

    public double cost() {
        if (Size.SMALL.equals(this.getSize())) {
            return 1.0;
        } else if (Size.MIDDLE.equals(this.getSize())) {
            return 1.5;
        } else {
            return 2.0;
        }
    }
}
