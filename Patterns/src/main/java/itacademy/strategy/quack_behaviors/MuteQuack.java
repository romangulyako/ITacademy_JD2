package itacademy.strategy.quack_behaviors;

import itacademy.strategy.api.QuackBehavior;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<<Silence>>");
    }
}
