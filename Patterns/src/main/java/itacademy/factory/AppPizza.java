package itacademy.factory;

import itacademy.factory.pizza_store.ChicagoStylePizzaStore;
import itacademy.factory.pizza_store.NYStylePizzaStore;

public class AppPizza {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYStylePizzaStore();
        PizzaStore chicagoStore = new ChicagoStylePizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");
        System.out.println(pizza);

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
        System.out.println(pizza);
    }
}
