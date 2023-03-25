package org.example;

import Agents.Operation.AgentOperation;
import Agents.Operation.Operation;
import Data.RestaurantData;
import Data.Workers.Cooker;
import Data.Workers.Workers;
import Orders.Order;
import Tools.LocalDateExtension;
import agent.Agent;
import agent.OrderAgent.OrderAgent;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

// НЕДОДЕЛАНО :))

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.debug("Program started to work ");
        RestaurantData restaurantData = RestaurantData.shared();
        AgentOperation agentOperation = new AgentOperation();
        List<OrderAgent> orderAgents = Stream.generate(OrderAgent::new)
                                       .limit(restaurantData.workers.cookers.size())
                                       .toList();

        orderAgents.forEach(Agent::start);

        while (!restaurantData.orders.orders.isEmpty()) {
            Order order = restaurantData.orders.orders.remove(restaurantData.orders.orders.size() - 1);
            for (int i = 0; i < order.dishes.length; i++) {
                Cooker cooker = restaurantData.workers.cookers.stream().filter(x -> x.isActive.get()).findFirst().orElse(null);
                Operation operation = new Operation(Operation.number++, order.dishes[i], cooker.name);
                int finalI = i;
                orderAgents.stream().findFirst().get().registerMessage(
                       restaurantData.menu.items.stream().filter(x -> Objects.equals(x.name, order.dishes[finalI])).findFirst().get()
                );
                orderAgents.stream().findFirst().get().run();

                operation.finish = LocalDateTime.now().toString();
                agentOperation.operations.add(operation);
            }
        }

        orderAgents.forEach(Agent::stop);
        agentOperation.logToFile();
    }
}