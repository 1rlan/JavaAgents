package Tools;

import lombok.experimental.UtilityClass;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class LocalDateExtension {
    final private LocalDate localDate = LocalDate.now();
    final private HashMap<DayOfWeek, Double> coefficients = new HashMap<>(
        Map.of(
            DayOfWeek.MONDAY, 0.7,
            DayOfWeek.TUESDAY, 0.8,
            DayOfWeek.WEDNESDAY, 0.9,
            DayOfWeek.THURSDAY, 0.9,
            DayOfWeek.FRIDAY, 1.5,
            DayOfWeek.SATURDAY, 1.2,
            DayOfWeek.SUNDAY, 0.8
        )
    );

    public static String nowDateToString() {
        return localDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String DayOfWeekString() {
        return localDate.getDayOfWeek().name();
    }

    public static double GetVisitorsCoefficient() {
        return coefficients.get(localDate.getDayOfWeek());
    }
}