package com.ws.rpc.server;

import com.ws.rpc.model.RpcRequest;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hp on 2015/2/25.
 */
public class SimpleMinaServerHandler extends IoHandlerAdapter {
    private AtomicInteger count = new AtomicInteger(0);
    private final Map<String, Object> handlerMap = null;

    /**
     * 当一个客户端连接进入时
     */
    @Override
    public void sessionOpened(IoSession session) throws Exception {

        System.out.println("client connection : " + session.getRemoteAddress());

    }

    /**
     * 当一个客户端关闭时
     */
    @Override
    public void sessionClosed(IoSession session) throws Exception {

        System.out.println("client disconnection : " + session.getRemoteAddress() + " is Disconnection");

    }

    /**
     * 当接收到客户端的信息
     *
     * @param session
     * @param message
     * @throws Exception
     */

    public void messageReceived(IoSession session, Object message)
            throws Exception {

        RpcRequest rpcRequest = (RpcRequest) message;
        String className = rpcRequest.getClassName();
        String methodName = rpcRequest.getMethodName();
        String requestId = rpcRequest.getRequestId();
        Object[] parameters = rpcRequest.getParameters();
        Class<?>[] parameterTypes = rpcRequest.getParameterTypes();

        Object serviceBean = handlerMap.get(className);
        Class<?> serviceClass = serviceBean.getClass();
        Method method = serviceClass.getMethod(methodName, parameterTypes);
        method.setAccessible(true);
        Object result = method.invoke(serviceBean, parameters);
        session.write(result);


    }
}
