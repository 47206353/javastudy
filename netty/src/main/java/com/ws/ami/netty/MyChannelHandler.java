package com.ws.ami.netty;


import org.jboss.netty.channel.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by hp on 2015/12/3.
 */
public class MyChannelHandler extends SimpleChannelHandler {


    /**
     * 保存所有的通道
     */
    Map<Channel, String> channels = new ConcurrentHashMap<Channel, String>();


    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent event)
            throws Exception {


        Channel channel = event.getChannel();
        System.out.println(channel.toString());
        channels.put(event.getChannel(), "");


        System.out.println("接受到的信息" + event.getMessage());
        System.out.println("channelClosed    and the size of channel is :" + channels.size());
        // 返回信息可以在dos对话框中看到自己输的内容
        //   e.getChannel().write(e.getMessage());
        // super.messageReceived(ctx, e);
    }

    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e)
            throws Exception {
        System.out.println("channel Connected......");


        // super.channelConnected(ctx, e);
    }

    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e)
            throws Exception {

        channels.remove(ctx.getChannel());
        System.out.println("channelClosed    and the size of channel is :" + channels.size());


        // super.channelClosed(ctx, e);
    }
}
