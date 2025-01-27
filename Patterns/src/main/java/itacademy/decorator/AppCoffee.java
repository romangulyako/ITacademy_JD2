package itacademy.decorator;

import itacademy.decorator.beverages.DarkRoast;
import itacademy.decorator.beverages.Espresso;
import itacademy.decorator.beverages.HouseBlend;
import itacademy.decorator.condiments.Mocha;
import itacademy.decorator.condiments.Soy;
import itacademy.decorator.condiments.Whip;

public class AppCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        beverage.setSize(Beverage.Size.BIG);
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage1 = new DarkRoast();
        beverage1.setSize(Beverage.Size.MIDDLE);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Whip(beverage1);
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());

        Beverage beverage2 = new HouseBlend();
        beverage2.setSize(Beverage.Size.BIG);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Soy(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
    }
}
