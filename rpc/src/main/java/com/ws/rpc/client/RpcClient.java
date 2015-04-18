package com.ws.rpc.client;

import com.ws.rpc.model.RpcRequest;
import com.ws.rpc.model.RpcResponse;

/**
 * Created by hp on 2015/2/25.
 */
public class RpcClient {

    private String host;
    private int port;

    public RpcClient(String host, int port) {
        this.host = host;
        this.port = port;
    }


    public RpcResponse send(RpcRequest request) throws Exception {
        MinaClient minaClient = new MinaClient();
        return minaClient.sendMessage(request);
         

    }
}
