package com.ws.ami.common.overwrite;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by hp on 2015/3/17.
 */
public class Test {
    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("8", "8");
        map.put("1", "1");
        map.put("3", "3");
        map.put("2", "2");


        for (Map.Entry m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());

        }


    }
}
