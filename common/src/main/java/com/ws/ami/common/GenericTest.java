package com.ws.ami.common;

import java.math.BigDecimal;

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
    }
}
