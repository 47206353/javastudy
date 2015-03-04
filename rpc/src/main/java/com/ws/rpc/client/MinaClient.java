package com.ws.rpc.client;

import com.ws.rpc.model.RpcRequest;
import com.ws.rpc.model.RpcResponse;
import org.apache.mina.core.RuntimeIoException;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.SocketConnector;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.ConnectException;
import java.net.InetSocketAddress;

/**
 * Created by hp on 2015/2/25.
 */
public class MinaClient extends IoHandlerAdapter {
    public SocketConnector socketConnector;

    private RpcResponse response;
    MinaClient ioHandler;


    public static final String HOST = "localhost";

    public static final int PORT = 8080;

    public MinaClient() {
        init();
    }

    public void init() {
        socketConnector = new NioSocketConnector();
        socketConnector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory()));
        ioHandler = new MinaClient();
        socketConnector.setHandler(this);
    }

    public RpcResponse sendMessage(RpcRequest msg) throws Exception {
        InetSocketAddress addr = new InetSocketAddress(HOST, PORT);
        ConnectFuture cf = socketConnector.connect(addr);

        cf.awaitUninterruptibly();
        WriteFuture future = cf.getSession().write(msg);
        future.await();
        return ioHandler.response;


    }


    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        System.out.println("Receive Server message " + message);
        if (message instanceof RpcResponse)
            this.response = (RpcResponse) message;

        session.close(true);
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        System.out.println("exceptionCaught");
        cause.printStackTrace();
        session.close(true);
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        System.out.println("messageSent");
        super.messageSent(session, message);
    }
}







