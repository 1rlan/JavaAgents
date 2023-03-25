package Agents.Operation;

import Tools.LocalDateExtension;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicBoolean;

public class Operation {
    public static int number = 0;

    public Operation(int id, String item, String cookerName) {
        this.id = id;
        this.item = item;
        this.cookerName = cookerName;
        this.start = LocalDateTime.now().toString();
    }

    public int id;
    public String item;
    public String start;

    public String finish;
    public String cookerName;
}

