package Data.Workers;

import java.util.concurrent.atomic.AtomicBoolean;

public class Cooker {
    public Cooker(String name) {
        this.name = name;
        this.isActive = new AtomicBoolean(true);
    }

    public String name;
    public AtomicBoolean isActive;
}
