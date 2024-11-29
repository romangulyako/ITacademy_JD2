package itacademy.strategy.ducks;

import itacademy.strategy.Duck;
import itacademy.strategy.fly_behaviors.FlyWithWings;
import itacademy.strategy.quack_behaviors.Quack;

public class MallardDuck extends Duck {
    public MallardDuck() {
        super.setFlyBehavior(new FlyWithWings());
        super.setQuackBehavior(new Quack());
    }

    @Override
    public void display() {
        System.out.println("I'm Mallard Duck");
    }
}
