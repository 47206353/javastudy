package com.ws.rpc.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hp on 2015/2/25.
 */
public class RpcRequest {
    @Getter
    @Setter
    private String requestId;
    @Getter
    @Setter
    private String className;
    @Getter
    @Setter
    private String methodName;
    @Getter
    @Setter
    private Class<?>[] parameterTypes;
    @Getter
    @Setter
    private Object[] parameters;

}
