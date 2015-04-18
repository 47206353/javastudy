package ws.ami.akka;

import akka.actor.UntypedActor;

/**
 * Created by hp on 15-3-28.
 */
public class Chirldren extends UntypedActor {



    @Override
    public void onReceive(Object message) throws Exception {

        System.out.println("children : ");

    }
}
