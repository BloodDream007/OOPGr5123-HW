import Classes.*;
import Interfaces.iActorBehaviour;
import Util.Logger;

public class App {
    public static void main(String[] args) {
        Logger.startLogging();

        Market magnit = new Market();

        iActorBehaviour client1 = new OrdinaryClient("boris");
        iActorBehaviour client2 = new SpecialClient("prezident", 1);
        iActorBehaviour client3 = new TaxInspector();
        iActorBehaviour client4 = new AuctionClient("Jimmy", "BLACK FRIDAY", 33);
        iActorBehaviour client5 = new AuctionClient("Jimmy2", "BLACK FRIDAY", 34);
        iActorBehaviour client6 = new AuctionClient("Jimmy3", "BLACK FRIDAY", 35);
        iActorBehaviour client7 = new AuctionClient("Jimmy4", "BLACK FRIDAY", 36);

        magnit.acceptToMarket(client1);
        magnit.acceptToMarket(client2);
        magnit.acceptToMarket(client3);
        magnit.acceptToMarket(client4);
        magnit.acceptToMarket(client5);
        magnit.acceptToMarket(client6);
        magnit.acceptToMarket(client7);

        magnit.update();
    }
}
