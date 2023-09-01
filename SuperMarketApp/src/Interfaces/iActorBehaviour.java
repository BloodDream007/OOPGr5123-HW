package Interfaces;

import Classes.Actor;

public interface iActorBehaviour {
    boolean isTakeOrder();
    boolean isMakeOrder();
    void setTakeOrder(boolean take);
    void setMakeOrder(boolean make);
    Actor getActor();
}
