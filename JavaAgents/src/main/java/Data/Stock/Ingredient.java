package Data.Stock;

public class Ingredient {
    public Ingredient(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public int amount;
    public String name;

    public boolean isAvailable() {
        return amount > 0;
    }
}
