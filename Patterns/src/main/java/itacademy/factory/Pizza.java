package itacademy.factory;

import itacademy.factory.ingredient.Cheese;
import itacademy.factory.ingredient.Clams;
import itacademy.factory.ingredient.Dough;
import itacademy.factory.ingredient.Pepperoni;
import itacademy.factory.ingredient.Sauce;
import itacademy.factory.ingredient.Veggies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Pizza {
    private String name;
    private Dough dough;
    private Sauce sauce;
    private Veggies[] veggies;
    private Cheese cheese;
    private Pepperoni pepperoni;
    private Clams clam;
    private final List<String> toppings = new ArrayList<>();

    public abstract void prepare();

    public void bake() {
        System.out.println("Baking for 25 minutes at 350");
    }
    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }
    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setVeggies(Veggies[] veggies) {
        this.veggies = veggies;
    }

    public void setCheese(Cheese cheese) {
        this.cheese = cheese;
    }

    public void setPepperoni(Pepperoni pepperoni) {
        this.pepperoni = pepperoni;
    }

    public void setClam(Clams clam) {
        this.clam = clam;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", dough='" + dough + '\'' +
                ", sauce='" + sauce + '\'' +
                ", veggies=" + Arrays.toString(veggies) +
                ", cheese=" + cheese +
                ", pepperoni=" + pepperoni +
                ", clam=" + clam +
                ", toppings=" + toppings +
                '}';
    }
}
