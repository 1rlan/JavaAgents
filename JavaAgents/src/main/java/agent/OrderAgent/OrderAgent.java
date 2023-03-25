package agent.OrderAgent;

import Data.Menu.MenuItem;
import agent.Agent;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class OrderAgent extends Agent<RandomMessage> {
    @Override
    protected void proceed(MenuItem item) throws InterruptedException {
        Thread.sleep(item.waitingTime * 100);
    }
}
