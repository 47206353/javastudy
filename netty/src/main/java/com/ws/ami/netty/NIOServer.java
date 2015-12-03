package com.ws.ami.netty;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

/**
 * Created by hp on 2015/12/3.
 */
public class NIOServer {


    ServerBootstrap bootstrap;
    Channel parentChannel;
    InetSocketAddress localAddress;
    MyChannelHandler channelHandler = new MyChannelHandler();

    public NIOServer() {
        bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(
                Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));


        ChannelPipeline pineline = bootstrap.getPipeline();
        // String格式字符串解码写的时候都会经过这个过滤器处理
        pineline.addLast("encode", new StringEncoder());
        // 接受信息的时候会被处理
        pineline.addLast("decode", new StringDecoder());
        // 自定义处理类，我们的业务一般从这个类开始
        pineline.addLast("servercnfactory", channelHandler);
        bootstrap.bind(new InetSocketAddress(8080));

    }


    public static void main(String[] args) {


        new NIOServer();
        System.out.println("服务启动完成");

    }
}
