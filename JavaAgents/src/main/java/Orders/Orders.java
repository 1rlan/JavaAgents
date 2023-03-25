package Orders;

import Data.Menu.Menu;
import LoadingRestaurantData.LoadDataException;
import LoadingRestaurantData.LoadDataExceptionState;
import LoadingRestaurantData.LoadingData;
import Tools.Generation.Generatable;
import Tools.Generation.GenerationException;
import Tools.Generation.NameGenerator;
import Tools.LocalDateExtension;
import lombok.extern.slf4j.Slf4j;
import Tools.Loggable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
public class Orders implements LoadingData, Loggable, Generatable<List<Order>> {
    public Orders(Menu menu) {
        this.menu = menu;
        orders = generate();
    }

    public List<Order> orders;
    // private final RestaurantData data = RestaurantData.shared();
    private final NameGenerator nameGenerator = new NameGenerator();
    private final Menu menu;

    @Override
    public void logToFile() {
        parser.encode(orders);
    }

    @Override
    public List<Order> generate() {
        double visitorsCoefficient = LocalDateExtension.GetVisitorsCoefficient();
        int amountVisitors = (int) (10 * visitorsCoefficient);
        List<Order> generatedOrders = Stream.generate(this::generateOrder)
                .limit(amountVisitors).toList();

        try {
            validateGeneration(generatedOrders);
        } catch (GenerationException exception) {
            log.error(exception.getMessage());
            throw new RuntimeException();
        }

        return generatedOrders;
    }

    @Override
    public void validateGeneration(List<Order> toCheck) throws GenerationException {
        if (toCheck.isEmpty()) {
            throw new GenerationException("List of orders cant be empty");
        }
    }

    private Order generateOrder() {
        String visitorName = nameGenerator.generate();
        int numberOfDishes = random.nextInt(1, 5);
        String[] generatedOrders = Stream.generate(this::takeRandomDish).limit(numberOfDishes).toArray(String[]::new);
        return new Order(visitorName, generatedOrders);
    }

    private String takeRandomDish() {
        int menuLength = menu.items.size();
        return menu.items.get(random.nextInt(menuLength)).name;
    }

    @Override
    public void ValidateData() throws LoadDataException {
        if (orders.isEmpty()) {
            throw new LoadDataException("Orders list is empty.", LoadDataExceptionState.invalidQuantity);
        }

        if (orders.stream().anyMatch(item -> item.dishes.length == 0)) {
            throw new LoadDataException("No disher in order", LoadDataExceptionState.invalidData);
        }

        if (orders.stream().anyMatch(items -> items.visitorName.isEmpty())) {
            throw new LoadDataException("Visistors name is empty", LoadDataExceptionState.invalidData);
        }
    }
}
