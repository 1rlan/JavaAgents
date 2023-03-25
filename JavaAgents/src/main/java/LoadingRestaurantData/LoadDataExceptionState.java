package LoadingRestaurantData;

import java.text.MessageFormat;

public enum LoadDataExceptionState {
    noFile,
    invalidQuantity,
    invalidData;

    public String ExceptionMessage(String file) {
        String placeToCheck = toCheck(file);
        switch (this) {
            case noFile -> {
                return MessageFormat.format("Invalid file to read JSON. {0}", placeToCheck);
            }
            case invalidQuantity -> {
                return MessageFormat.format("Invalid quantity of parameters in JSON file. {0}", placeToCheck);
            }
            case invalidData -> {
                return MessageFormat.format("Invalid data in json file. {0}", placeToCheck);
            }
        }
        throw new IllegalStateException("Unknown load state");
    }

    private String toCheck(String file) {
        return MessageFormat.format("Check file {0} manually", file);
    }
}
