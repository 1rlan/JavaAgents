package Tools;

import Data.Workers.Workers;
import LoadingRestaurantData.LoadDataException;
import LoadingRestaurantData.LoadingData;
import Data.Menu.Menu;
import Data.Stock.Stock;
import Orders.Orders;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.lang.reflect.Modifier;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JsonParser {
    final private String pathToLogsFolder = "src/out/logs";
    Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .excludeFieldsWithModifiers(Modifier.PRIVATE)
                    .create();
    final private HashMap<Class<? extends LoadingData>, String> fileForClass = new HashMap<>(
        Map.of(
            Menu.class, "/Menu.json",
            Stock.class, "/Stock.json",
            Orders.class, "/Orders.json",
            Workers.class, "/Workers.json"
        )
    );

    public <LoadingType extends LoadingData> LoadingType decode(Class<LoadingType> object) {
        InputStream inputStream = getClass().getResourceAsStream(fileForClass.get(object));
        LoadingType data = gson.fromJson(new InputStreamReader(inputStream), object);

        try {
            data.ValidateData();
        } catch (LoadDataException exception) {
            log.error(exception.getMessage());
            throw new RuntimeException();
        }

        return data;
    }

    public void encode(Object object) {
        String pathToWrite = createPath(object.getClass().getSimpleName());
        try (Writer writer = new FileWriter(pathToWrite)) {
            gson.toJson(object, writer);
        } catch (IOException exception) {
            log.error("Failed to record decoding log for class {}", object.getClass());
        }
    }

    private String createPath(String fileName) {
        return MessageFormat.format("{0}/{1}.json", pathToLogsFolder, fileName);
    }
}

