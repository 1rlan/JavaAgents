package Data.Workers;

import LoadingRestaurantData.LoadDataExceptionState;
import LoadingRestaurantData.LoadingData;
import LoadingRestaurantData.LoadDataException;

import java.util.Arrays;
import java.util.List;

public class Workers implements LoadingData {
    Workers(List<Cooker> cookers) {
        this.cookers = cookers;
    }

    public List<Cooker> cookers;

    public void ValidateData() throws LoadDataException {
        if (cookers.isEmpty()) {
            throw new LoadDataException("The list of workers is empty.", LoadDataExceptionState.invalidQuantity);
        }

        if (cookers.stream().anyMatch(cooker -> cooker.name.isEmpty())) {
            throw new LoadDataException("Invalid name of cooker", LoadDataExceptionState.invalidData);
        }

        if (cookers.stream().anyMatch(cooker -> !cooker.isActive.get())) {
            throw new LoadDataException("Cooker have to be ready for work", LoadDataExceptionState.invalidData);
        }

    }
}
