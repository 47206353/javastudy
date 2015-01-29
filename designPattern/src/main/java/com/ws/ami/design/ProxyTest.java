package com.ws.ami.design;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 2015/1/29.
 */
public class ProxyTest {

    public static void main(String[] args) {
        MyProxy proxy = new MyProxy();
        List l = (List) proxy.factory(new ArrayList());
        l.add("hello");


    }


}
