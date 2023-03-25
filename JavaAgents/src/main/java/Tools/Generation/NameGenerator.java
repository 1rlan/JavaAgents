package Tools.Generation;

import java.text.MessageFormat;
import java.util.Random;

public class NameGenerator implements Generatable<String> {

    private static final String[] FIRST_NAMES = {"Oliver", "Emma", "Noah", "Ava", "William", "Sophia", "James", "Isabella", "Logan", "Mia"};
    private static final String[] LAST_NAMES = {"Smith", "Johnson", "Brown", "Davis", "Wilson", "Taylor", "Clark", "Thomas", "Hall", "King"};
    @Override
    public String generate() {
        String firstName = generatePart(namePart.firstName);
        String lastName = generatePart(namePart.lastName);
        String generatedString = MessageFormat.format("{0} {1}", firstName, lastName);

        try {
            validateGeneration(generatedString);
        } catch (GenerationException exception) {
            // tbd
        }

        return generatedString;
    }

    @Override
    public void validateGeneration(String toCheck) throws GenerationException {
        if (toCheck.isEmpty()) {
            throw new GenerationException("Generated name was null or empty");
        }
    }

    private String generatePart(namePart part) {
        switch (part) {
            case firstName -> {
                return FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
            }
            case lastName -> {
                return LAST_NAMES[random.nextInt(LAST_NAMES.length)];
            }
        }
        throw new IllegalStateException("Unknown name part");
    }

    private enum namePart {
        firstName, lastName
    }
}
