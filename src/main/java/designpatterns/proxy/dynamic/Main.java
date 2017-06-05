package designpatterns.proxy.dynamic;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
//        Humen humen = new HumenProxy();
//        humen.eat("rice");
        Humen humen = new HumenImpl();
        
        DynamicProxy dynamicProxy = new DynamicProxy(humen);
        
//        Humen humenProxy = (Humen) Proxy.newProxyInstance(
//                humen.getClass().getClassLoader(), 
//                humen.getClass().getInterfaces(), 
//                dynamicProxy);
        Humen humenProxy = dynamicProxy.getProxy();
        humenProxy.eat("rice");
    }
}
