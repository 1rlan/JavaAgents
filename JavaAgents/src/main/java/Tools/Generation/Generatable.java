package Tools.Generation;

import LoadingRestaurantData.LoadDataException;

import java.util.Random;

public interface Generatable<T> {
    Random random = new Random();
    T generate();
    void validateGeneration(T toCheck) throws GenerationException;
}
