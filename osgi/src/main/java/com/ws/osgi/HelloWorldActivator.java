package com.ws.osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Created by hp on 2015/3/20.
 */
public class HelloWorldActivator implements BundleActivator {
    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Hello World Bundle started!");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Hello World Bundle stop!");
    }
}
