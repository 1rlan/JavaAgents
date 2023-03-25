package LoadingRestaurantData;

public class LoadDataException extends Exception {
    final private LoadDataExceptionState exceptionState;

    public LoadDataException(String file, LoadDataExceptionState state) {
        super(state.ExceptionMessage(file));
        this.exceptionState = state;
    }

    public LoadDataExceptionState getExceptionState() {
        return exceptionState;
    }
}

