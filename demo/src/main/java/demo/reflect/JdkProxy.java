package demo.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhihaosong on 17-7-23.
 * JDK的动态代理
 * 1.依靠接口实现
 * 2.如果有些类并没有实现接口，则不能使用JDK代理
 * 3.没有实现接口只能使用cglib动态代理
 */
public class JdkProxy implements InvocationHandler {

    // 目标对象
    private Object target;

    public JdkProxy(Object target) {
        super();
        this.target = target;
    }

    /**
     * 创建代理实例
     *
     * @return
     * @throws Throwable
     */
    public Object getProxy() throws Throwable {
        return Proxy.newProxyInstance(Thread.currentThread()
                .getContextClassLoader(), this.target.getClass()
                .getInterfaces(), this);
        // 这样写只返回了目标对象，没有生成代理对象。
        // return target;
    }

    /**
     * 实现InvocationHandler接口方法
     * 执行目标对象的方法，并进行增强
     */
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Object result = null;
        System.out.println("代理类方法，进行了增强。。。");
        System.out.println("事务开始。。。");
        // 执行目标方法对象
        result = method.invoke(target, args);
        System.out.println("事务结束。。。");
        return result;
    }

    /**
     * jdk动态代理会生成一个动态代理类，生成相应的字节码，然后通过ClassLoader加载字节码。
     * 该实例继承了Proxy类，并实现了业务接口，在实现的方法里通过反射调用了InvocationHandler接口实现类
     * 的invoke()回调方法。
     *
     * @param args
     * @throws Throwable
     */
    public static void main(String[] args) throws Throwable {
        UserService userService = new UserServiceImpl();
        JdkProxy handler = new JdkProxy(userService);
        // 根据目标生成代理对象
        UserService proxy = (UserService) handler.getProxy();
        proxy.addUser();
//      proxy.editUser();

    }
}