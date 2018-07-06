package jdk.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 3、调用管理接口 InvocationHandler 创建动态代理类
 * @Author tannanlin
 * @Date 2018/7/5
 */
public class BookProxy  implements InvocationHandler{
    //业务实现类对象、用来调用具体的业务方法
    private  Object target;

    /**
     * 绑定业务对象  并返回一个代理类
     * @param target
     * @return
     */
    public Object bind(Object target){
        //接收业务实现类对象参数
        this.target = target;

        //通过反射机制，创建一个代理类对象实例并返回。用户进行方法调用时使用
        //创建代理对象时，需要传递改业务类的类加载器（用来获取业务实现类的元数据，
        // 在包装方法时调用真正的业务方法），接口、handler实现类
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }

    /**
     *  包装调用方法：进行预处理、调用后处理
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("预处理操作————");
        result = method.invoke(target,args);
        System.out.println("调用后处理操作————");
        return result;
    }
}
