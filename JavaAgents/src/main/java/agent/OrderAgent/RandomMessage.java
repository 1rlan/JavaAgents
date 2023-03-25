package agent.OrderAgent;

import agent.Message;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RandomMessage extends Message {
    private int min;
    private int max;
}
