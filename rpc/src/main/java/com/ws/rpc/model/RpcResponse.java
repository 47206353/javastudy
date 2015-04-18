package com.ws.rpc.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hp on 2015/2/25.
 */
public class RpcResponse {
    @Getter
    @Setter
    private String requestId;
    @Getter
    @Setter
    private Throwable error;
    @Getter
    @Setter
    private Object result;
}
