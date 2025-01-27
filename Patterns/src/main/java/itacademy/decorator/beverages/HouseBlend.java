package itacademy.decorator.beverages;

import itacademy.decorator.Beverage;

public class HouseBlend extends Beverage {
    public HouseBlend() {
        super.setDescription("House Blend");
    }

    public double cost() {
        if (Size.SMALL.equals(this.getSize())) {
            return 0.6;
        } else if (Size.MIDDLE.equals(this.getSize())) {
            return 0.9;
        } else {
            return 1.2;
        }
    }
}
