package Data;
import Data.Workers.Workers;
import Orders.Orders;
import lombok.extern.slf4j.Slf4j;
import Tools.JsonParser;
import Data.Menu.Menu;
import Data.Stock.Stock;

@Slf4j
public class RestaurantData {
    private static RestaurantData instance;
    private JsonParser jsonParser = new JsonParser();
    public Menu menu;
    public Stock stock;
    public Workers workers;

    public Orders orders;


    private RestaurantData() {
        menu = jsonParser.decode(Menu.class);
        stock = jsonParser.decode(Stock.class);
        orders = jsonParser.decode(Orders.class);
        workers = jsonParser.decode(Workers.class);
    }

    public static RestaurantData shared() {
        if (instance == null) {
            instance = new RestaurantData();
        }
        return instance;
    }
}

