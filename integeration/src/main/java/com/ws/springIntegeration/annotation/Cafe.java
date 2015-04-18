package com.ws.springIntegeration.annotation;

/**
 * Created by hp on 2015/3/9.
 */
public class Cafe {


    public static void main(String[] args) {

        Drink d = new Drink();
        Object o = d;
        int i = 0;
        while (o != null && !(o instanceof Class)) {
            i++;

            System.out.println("i =" +i +"   and o.type ="+o.getClass().getName() );
        o = o.getClass().getSuperclass();
        }
    }
}
