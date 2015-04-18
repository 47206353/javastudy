package ws.ami.akka;

import akka.actor.UntypedActor;

/**
 * Created by hp on 15-3-28.
 */
public class Greeter extends UntypedActor {

    public static enum Msg {
        GREET, DONE
    }

    @Override
    public void onReceive(Object msg) {
        System.out.println("on recieve msg = "+msg);
        if (msg == Msg.GREET) {
            System.out.println("Hello World!");
            getSender().tell(Msg.DONE, getSelf());
        } else {
            unhandled(msg);
        }
    }
}
