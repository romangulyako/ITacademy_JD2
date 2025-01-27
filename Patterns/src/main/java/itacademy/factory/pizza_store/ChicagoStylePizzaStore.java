package itacademy.factory.pizza_store;

import itacademy.factory.Pizza;
import itacademy.factory.PizzaIngredientFactory;
import itacademy.factory.PizzaStore;
import itacademy.factory.ingredient.ChicagoPizzaIngredientFactory;
import itacademy.factory.pizza.CheesePizza;
import itacademy.factory.pizza.ClamPizza;

public class ChicagoStylePizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory, "Chicago cheese pizza");
        } else if (type.equals("clam")) {
            pizza = new ClamPizza(ingredientFactory, "Chicago Clam pizza");
        }

        return pizza;
    }
}
