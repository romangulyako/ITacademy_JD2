package itacademy.decorator;

public abstract class Beverage {
    public enum Size {SMALL, MIDDLE, BIG }
    private Size size = Size.SMALL;
    private String description = "Unknown Beverage";

    public Beverage() {}

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public abstract double cost();
}
