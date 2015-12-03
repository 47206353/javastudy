package com.jyzq.mule;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.springframework.stereotype.Service;

/**
 * Created by hp on 2015/10/12.
 */
@Service
public class TestBean implements Callable {
    org.mule.api.config.ConfigurationBuilder b ;

    public Object onCall(MuleEventContext muleEventContext) throws Exception {

        System.out.print("helloworld");
        return null;
    }
}
