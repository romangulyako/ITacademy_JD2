package itacademy.factory;

import itacademy.factory.ingredient.Cheese;
import itacademy.factory.ingredient.Clams;
import itacademy.factory.ingredient.Dough;
import itacademy.factory.ingredient.Pepperoni;
import itacademy.factory.ingredient.Sauce;
import itacademy.factory.ingredient.Veggies;

public interface PizzaIngredientFactory {
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Pepperoni createPepperoni();
    Clams createClams();
    Veggies[] createVeggies();
}
