package ws.ami.akka;


import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;


/**
 * Created by hp on 15-3-28.
 */

class HelloClient  extends UntypedActor {

    @Override
    public void preStart() {
        final ActorRef greeter =
                getContext().actorOf(Props.create(Greeter.class), "greeter");
        greeter.tell(Greeter.Msg.GREET, getSelf());
    }

    @Override
    public void onReceive(Object msg) {

        ActorRef child = getContext().actorOf(Props.create(Chirldren.class));

        System.out.println("helloclient parent = "+getContext().parent().tell(););
        System.out.println("helloclient getcontext guardian = "+getContext().guardian());
        System.out.println("helloclient self path = " + getSelf().path());
        System.out.println("helloclient children = "+getContext().getChildren().toString());
        System.out.println("on recieve msg = "+msg);
        if (msg == Greeter.Msg.DONE) {
            getContext().stop(getSelf());
        } else {
            unhandled(msg);
        }
    }


    }




