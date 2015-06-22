package ws.ami.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * Created by hp on 15-3-28.
 */
public class DemoMain {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("demo1");
        System.out.println("gurdian="+  system.guardian());
        System.out.println("gurdian parent="+  system.guardian().getParent());



        ActorRef actor1 = system.actorOf(Props.create(Greeter.class));
        ActorRef actor2 = system.actorOf(Props.create(HelloClient.class));
        actor1.tell("hello akka!!", actor2);
        system.shutdown();//
    }
}
