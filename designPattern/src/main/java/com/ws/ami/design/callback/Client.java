package com.ws.ami.design.callback;

/**
 * Created by hp on 2015/3/4.
 */
public class Client {

    public static void main(String[] args) {


        Employee emp = new Employee();

        //将回调对象（上层对象）传入，注册
        emp.setCallBack(new Boss());

        //开启控制器对象运行
        emp.doSome();
    }
}
