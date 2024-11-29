package itacademy.strategy.quack_behaviors;

import itacademy.strategy.api.QuackBehavior;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
