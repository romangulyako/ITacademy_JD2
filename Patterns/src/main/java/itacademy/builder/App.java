package itacademy.builder;

public class App {
    public static void main(String[] args) {
        Animal dog = Animal.builder()
                .age(23)
                .name("Dog")
                .color("Grey")
                .gender("Male")
                .build();
    }
}
