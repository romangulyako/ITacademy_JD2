package itacademy.factory.pizza_store;

import itacademy.factory.Pizza;
import itacademy.factory.PizzaIngredientFactory;
import itacademy.factory.PizzaStore;
import itacademy.factory.ingredient.NYPizzaIngredientFactory;
import itacademy.factory.pizza.CheesePizza;
import itacademy.factory.pizza.ClamPizza;

public class NYStylePizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        if (type.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory, "NY Cheese pizza");
        }  else if (type.equals("clam")) {
            pizza = new ClamPizza(ingredientFactory, "NY Clam pizza");
        }

        return pizza;
    }
}
