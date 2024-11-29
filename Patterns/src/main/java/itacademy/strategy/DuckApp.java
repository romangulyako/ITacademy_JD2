package itacademy.strategy;

import itacademy.strategy.ducks.MallardDuck;
import itacademy.strategy.ducks.ModelDuck;
import itacademy.strategy.fly_behaviors.FlyRocketPowered;

public class DuckApp {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.performFly();
        mallardDuck.performQuack();
        mallardDuck.display();

        Duck modelDuck = new ModelDuck();
        modelDuck.performFly();
        modelDuck.setFlyBehavior(new FlyRocketPowered());
        modelDuck.performFly();
    }
}
