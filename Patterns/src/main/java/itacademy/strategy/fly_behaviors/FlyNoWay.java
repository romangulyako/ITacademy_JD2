package itacademy.strategy.fly_behaviors;

import itacademy.strategy.api.FlyBehavior;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
