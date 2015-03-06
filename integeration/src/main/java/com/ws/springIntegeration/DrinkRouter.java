package com.ws.springIntegeration;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

/**
 * Created by hp on 2015/3/6.
 */
@MessageEndpoint()
public class DrinkRouter {

    //@Router表示,接收消息后，调用这个类的该方法. 其的参数类型必须与message的 payload属性一致。
    //方法执行完毕后，其返回值为 在容器中定义的channel名称。channel名称必须存在
    @Router
    public String resolveDrinkChannel(Drink drink) {
        return (drink.isIced()) ? "coldDrinks" : "hotDrinks"; //方法中，是根据处理饮料是否是冷饮，送不同的channel处理
    }
}