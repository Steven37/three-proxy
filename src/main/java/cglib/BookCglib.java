package cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 2、实现MethodInterceptor方法代理接口，创建代理类
 * @Author tannanlin
 * @Date 2018/7/5
 */
public class BookCglib implements MethodInterceptor {
    //业务类对象，供代理方法中进行真正的业务方法调用
    private  Object target;


    /**
     * 相当于jdk动态代理中的绑定
     * @param target
     * @return
     */
    public Object getInstance(Object target){
       //给业务对象赋值
        this.target = target;

        //创建加强器，用来创建动态代理类
        Enhancer enhancer = new Enhancer();
        //为加强器指定要代理的业务类（即：为下面生成的代理类指定父类）
        enhancer.setSuperclass(this.target.getClass());
        //设置回调：对于代理类上所有方法的调用，都会调用CallBack，而CallBack则需要实现interceor方法进行拦截
        enhancer.setCallback(this);
        //创建动态代理类对象 并返回
        return  enhancer.create();
    }


    /**
     * 实现回调方法
     * @param object
     * @param method
     * @param args
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
       System.out.println("预处理————");
        methodProxy.invokeSuper(object,args);
        System.out.println("调用后处理————");
       return null;
    }
}
