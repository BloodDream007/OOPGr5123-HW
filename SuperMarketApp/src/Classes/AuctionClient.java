package Classes;

import Interfaces.*;

public class AuctionClient extends Actor implements iReturnOrder {
    private String auctionName;
    private long id;
    private static int participants = 2;

    public AuctionClient(String name, String auctionName, long id) {
        super(name);
        this.auctionName = auctionName;
        this.id = id;
    }


    @Override
    public boolean isTakeOrder() {
        return super.isTakeOrder;
    }

    @Override
    public boolean isMakeOrder() {
        return super.isMakeOrder;
    }

    @Override
    public void setTakeOrder(boolean take) {
        super.isTakeOrder = take;
    }

    @Override
    public void setMakeOrder(boolean make) {
        super.isMakeOrder = make;
    }

    @Override
    public Actor getActor() {
        return this;
    }

    @Override
    public void setName(String name) {
        super.name = name;
    }

    @Override
    public String getName() {
        return super.name;
    }

    public static int getParticipants() {
        return participants;
    }

    public String getAuctionName() {
        return auctionName;
    }

    public void setAuctionName(String auctionName) {
        this.auctionName = auctionName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static void setParticipants(int participants) {
        AuctionClient.participants = participants;
    }

    @Override
    public boolean haveCheck() {
        return false;
    }

    @Override
    public boolean returnable() {
        return false;
    }
}
