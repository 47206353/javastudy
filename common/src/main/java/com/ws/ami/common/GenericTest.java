package com.ws.ami.common;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by hp on 2015/3/23.
 */
public class GenericTest<REQUEST, RESPONSE> {


    public RESPONSE invoke(REQUEST request) {
        return null;
    }

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(12.3);
        System.out.println(bigDecimal);

        Date date = new Date();
        System.out.println("day ="+date.getTime());
        System.out.println("date ="+date.getDate());

        Integer i = new Integer();
        i.toString()
    }
}
