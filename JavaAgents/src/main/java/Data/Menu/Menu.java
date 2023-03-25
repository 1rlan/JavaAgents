package Data.Menu;

import LoadingRestaurantData.LoadDataException;
import LoadingRestaurantData.LoadDataExceptionState;
import LoadingRestaurantData.LoadingData;

import java.util.List;

public class Menu implements LoadingData {
    Menu(List<MenuItem> items) {
        this.items = items;
    }

    public List<MenuItem> items;

    public void ValidateData() throws LoadDataException {
        if (items.isEmpty()) {
            throw new LoadDataException("The menu is empty.", LoadDataExceptionState.invalidQuantity);
        }

        if (items.stream().anyMatch(item -> item.ingredients.length == 0)) {
            throw new LoadDataException("One of ingredient list is empty", LoadDataExceptionState.invalidData);
        }

        if (items.stream().anyMatch(items -> items.price < 0 || items.waitingTime < 0)) {
            throw new LoadDataException("Price or waiting time of menu item cant be less than zero", LoadDataExceptionState.invalidData);
        }

        if (items.stream().anyMatch(items -> items.name.isEmpty())) {
            throw new LoadDataException("Invalid name for menu item", LoadDataExceptionState.invalidData);
        }
    }
}
