package Orders;

import Data.RestaurantData;
import LoadingRestaurantData.LoadDataException;
import LoadingRestaurantData.LoadingData;

public class Order implements LoadingData {
    public Order(String visitorName, String[] dishes) {
        this.visitorName = visitorName;
        this.dishes = dishes;
    }

    final private RestaurantData data = RestaurantData.shared();

    public String visitorName;
    public String[] dishes;

    @Override
    public void ValidateData() throws LoadDataException {

    }
}
