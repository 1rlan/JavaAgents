package Tools;

import Tools.JsonParser;

public interface Loggable {
    JsonParser parser = new JsonParser();

    void logToFile();
}
