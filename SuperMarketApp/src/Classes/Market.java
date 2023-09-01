package Classes;

import Interfaces.iActorBehaviour;
import Interfaces.iMarketBehaviour;
import Interfaces.iQueueBehaviour;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static Util.Logger.LOGGER;

public class Market implements iMarketBehaviour, iQueueBehaviour {
    private int clientCount = 0;

    private List<iActorBehaviour> queue;

    public Market() {
        this.queue = new ArrayList<>();
    }

    @Override
    public void acceptToMarket(iActorBehaviour actor) {
        takeInQueue(actor);
        LOGGER.info("Client : " + actor.getActor().getName() + " has been added");

        if (actor.getActor() instanceof AuctionClient) {
            LOGGER.info("Add Auction Client");
            clientCount++;
            LOGGER.info(clientCount + " = Auction Clients");

            if (clientCount > AuctionClient.getParticipants()) {
                LOGGER.warning("Превышено кол-во участников в акции");
            }
        }
    }

    @Override
    public void takeInQueue(iActorBehaviour actor) {
        this.queue.add(actor);
        LOGGER.info(actor.getActor().getName() + " клиент добавлен в очередь");
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            LOGGER.info(actor.getName() + "  клиент ушел из магазина ");
            queue.remove(actor);
        }
    }

    @Override
    public void update() {
        takeOrder();
        giveOrder();
        releaseFromQueue();
    }

    @Override
    public void giveOrder() {
        for (iActorBehaviour actor : queue) {
            if (actor.isMakeOrder()) {
                actor.setTakeOrder(true);
                LOGGER.info(actor.getActor().getName() + "  клиент получил свой заказ ");
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> releaseActors = new ArrayList<>();
        for (iActorBehaviour actor : queue) {
            if (actor.isTakeOrder()) {
                releaseActors.add(actor.getActor());
                LOGGER.info(actor.getActor().getName() + "  клиент ушел из очереди ");
            }
        }
        releaseFromMarket(releaseActors);
    }

    @Override
    public void takeOrder() {
        for (iActorBehaviour actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                LOGGER.info(actor.getActor().getName() + "  клиент сделал заказ ");
            }
        }
    }
}
