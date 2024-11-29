package itacademy.strategy.ducks;

import itacademy.strategy.Duck;
import itacademy.strategy.fly_behaviors.FlyNoWay;
import itacademy.strategy.quack_behaviors.Quack;

public class ModelDuck extends Duck {
    public ModelDuck() {
        super.setFlyBehavior(new FlyNoWay());
        super.setQuackBehavior(new Quack());
    }

    @Override
    public void display() {
        System.out.println("I'm Model Duck");
    }
}
