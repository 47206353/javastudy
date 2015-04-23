package com.ws.ami.design.command;

import lombok.Data;

/**
 * Created by hp on 2015/3/31.
 */
@Data

public class Invoker {

    private Command command;



    public void invoke() {
        command.exeute();
    }
}
