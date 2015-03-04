package com.ws.ami.design.proxy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 2015/1/29.
 */
public class ProxyTest {

    public static void main(String[] args) {
        MyProxy proxy = new MyProxy();
        List<String> target =  new ArrayList();
        List<Integer> l = (List) proxy.factory(target);
      ///  l.add("hello");
        l.add(1);


    }


}
