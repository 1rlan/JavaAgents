package Agents.Operation;

import Tools.Loggable;

import java.util.ArrayList;
import java.util.List;

public class AgentOperation implements Loggable {
    public List<Operation> operations = new ArrayList<>();


    public void logToFile() {
        parser.encode(this);
    }
}
