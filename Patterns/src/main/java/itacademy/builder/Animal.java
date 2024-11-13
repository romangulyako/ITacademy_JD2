package itacademy.builder;

public class Animal {
    private String name;
    private int age;
    private  String color;
    private String gender;

    public Animal(String name, int age, String color, String gender) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.gender = gender;
    }

    public  static AnimalBuilder builder() {
        return new AnimalBuilder();
    }

    public static class AnimalBuilder {
        private String name;
        private int age;
        private String color;
        private String gender;

        public AnimalBuilder() {
        }

        public AnimalBuilder name(String name) {
            this.name = name;
            return this;
        }

        public AnimalBuilder age(int age) {
            this.age = age;
            return this;
        }

        public AnimalBuilder color(String color) {
            this.color = color;
            return this;
        }

        public AnimalBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Animal build() {
            return new Animal(this.name, this.age,this.color,this.gender);
        }
    }
}
