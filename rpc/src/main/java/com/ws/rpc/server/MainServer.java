package com.ws.rpc.server;

import com.ws.rpc.annotation.RpcService;
import org.apache.commons.collections.MapUtils;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hp on 2015/2/25.
 */
public class MainServer implements ApplicationContextAware {
    // 服务器端口
    private static final int SERVER_PORT = 8899;

    private Map<String, Object> handlerMap = new HashMap();

    public static void main(String[] args) throws Exception {

        //创建一个非阻塞的Server端Socket，用NIO
        SocketAcceptor acceptor = new NioSocketAcceptor();

        // 定义每次接收数据大小
        SocketSessionConfig sessionConfig = acceptor.getSessionConfig();
        sessionConfig.setReadBufferSize(2048);

        //创建接受数据的过滤器
        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();

        //设定这个过滤器将一行一行（/r/n）的读取数据
        chain.addLast("myChain", new ProtocolCodecFilter(new TextLineCodecFactory()));

        //设定服务器端的消息处理器: 一个 SimpleMinaServerHandler 对象
        acceptor.setHandler(new SimpleMinaServerHandler());

        //绑定端口，启动服务器
        try {
            acceptor.bind(new InetSocketAddress(SERVER_PORT));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Mina server is listing port:" + SERVER_PORT);

    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        Map<String, Object> serviceBeanMap = ctx.getBeansWithAnnotation(RpcService.class); // 获取所有带有 RpcService 注解的 Spring Bean
        if (MapUtils.isNotEmpty(serviceBeanMap)) {
            for (Object serviceBean : serviceBeanMap.values()) {
                String interfaceName = serviceBean.getClass().getAnnotation(RpcService.class).value().getName();
                handlerMap.put(interfaceName, serviceBean);
            }
        }
    }
}
