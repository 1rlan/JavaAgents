package Data.Stock;

import LoadingRestaurantData.LoadDataException;
import LoadingRestaurantData.LoadingData;

public class Stock implements LoadingData {
    Stock(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }

    public Ingredient[] ingredients;

    public void ValidateData() throws LoadDataException {
        // tbd
    }
}
