package com.ws.ami.common.propertiescopy;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hp on 2015/1/22.
 */
public class TargetDog extends TargetAnimal{
    @Setter
    @Getter
    private int dogMouth;
    @Setter
    @Getter
    private String dogName ;
}
