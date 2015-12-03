package com.jyzq.mule;


import org.mule.api.MuleContext;
import org.mule.api.MuleMessage;
import org.mule.module.client.MuleClient;
import org.mule.api.context.MuleContextFactory;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.context.DefaultMuleContextFactory;

/**
 * Created by hp on 2015/10/12.
 */
public class Demo1 {

    public static void main(String[] args) throws Exception {



/*
     System.out.println("ddd");
        org.mule.api.config.ConfigurationBuilder b;
  System.out.println(System.getProperty("user.dir"));
        MuleContext muleContext = new DefaultMuleContextFactory().createMuleContext("E:\\project\\javaproject\\javastudy\\muletest\\target\\classes\\mule-config.xml");
        muleContext.start();
        System.out.println("Server Started");*/



        MuleClient client = new MuleClient(true);
        RemoteDispatcher dispatcher = client.getRemoteDispatcher("http://localhost:81");


        MuleMessage result = dispatcher.sendToRemoteComponent("StockManager", "give me the price of XXX", null);

        StockQuote sq = (StockQuote) result.getPayload();

    }
}
