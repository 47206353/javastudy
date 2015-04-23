package com.ws.ami.design.command;

/**
 * Created by hp on 2015/3/31.
 */
public class ConcreteCommand implements Command {

    Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exeute() {
        System.out.println("ConcreteCommand start");
        receiver.receive();
        System.out.println("ConcreteCommand end");
    }
}
