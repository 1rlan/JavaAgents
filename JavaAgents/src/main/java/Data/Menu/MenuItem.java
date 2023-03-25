package Data.Menu;

import Data.RestaurantData;
import lombok.Getter;

public class MenuItem {
    public MenuItem(String[] ingredients, String name, int waitingTime, int price) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.waitingTime = waitingTime;
    }

    private RestaurantData data = RestaurantData.shared();

    @Getter
    final public int price;

    final public String name;
    final public int waitingTime;
    final public String[] ingredients;

    public boolean isAvailable() {
        throw new IllegalStateException();
    }
}
