package itacademy.strategy.fly_behaviors;

import itacademy.strategy.api.FlyBehavior;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying!!!");
    }
}
