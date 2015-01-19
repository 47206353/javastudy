package com.ws.ami;

import org.junit.Test;

/**
 * Created by hp on 2015/1/8.
 */
public class Mytest {

    @Test
    public void test() {
        String templateContent = "您注册的翼支付企业客户已开!{ROLE_NAME}用户名:{STAFF_ID}密码:{LOGIN_PWD!DECRYPT}，请登录翼支付企业客户自服务门户初始化密码确保支付安全。";

        String[] temps = templateContent.split(":");
        String key = "\\{" + temps[0] + "\\}";
        String value = "";
        value = temps[1];

       // String all = templateContent.replaceAll(key, value);
    }
}
