package itacademy.factory.ingredient;

import itacademy.factory.PizzaIngredientFactory;
import itacademy.factory.ingredient.cheese.ReggianoCheese;
import itacademy.factory.ingredient.clams.FreshClams;
import itacademy.factory.ingredient.dough.ThinCrustDough;
import itacademy.factory.ingredient.pepperoni.SlicedPepperoni;
import itacademy.factory.ingredient.sauce.MarinaraSauce;
import itacademy.factory.ingredient.veggies.Garlic;
import itacademy.factory.ingredient.veggies.Mushroom;
import itacademy.factory.ingredient.veggies.Onion;
import itacademy.factory.ingredient.veggies.RedPepper;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FreshClams();
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[]{new Garlic(),
                new Mushroom(),
                new RedPepper()};
    }
}
