package itacademy.singleton;

public class ChocolateBoiler {
    private volatile static ChocolateBoiler chocolateBoiler;
    private boolean empty;
    private boolean boiled;

    private ChocolateBoiler() {
        this.empty = true;
        this.boiled = false;
    }

    public static synchronized ChocolateBoiler getInstance() {
        if (chocolateBoiler == null) {
            synchronized (ChocolateBoiler.class) {
                if (chocolateBoiler == null) {
                    chocolateBoiler = new ChocolateBoiler();
                }
            }
        }

        return chocolateBoiler;
    }

    public void fill() {
        if (isEmpty()) {
            this.empty = false;
            this.boiled = false;
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            this.empty = true;
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            this.boiled = true;
        }
    }

    public boolean isEmpty() {
        return this.empty;
    }

    public boolean isBoiled() {
        return this.boiled;
    }
}
