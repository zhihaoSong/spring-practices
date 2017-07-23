package demo.reflect;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by zhihaosong on 17-7-23.
 * 业务类 没有实现接口
 * 如果类是final的，则没法生成代理对象，报错。
 * 如果方法是final的，代理无效
 */
public class CglibProxy implements MethodInterceptor {

    private Object target;

    //创建代理实例
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 设置回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    /**
     * 实现MethodInterceptor接口要重写的方法。
     * 回调方法
     */
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        System.out.println("事务开始。。。");
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("事务结束。。。");
        return result;
    }

    public static void main(String[] args) {
        CglibProxy cglib = new CglibProxy();
        UserServiceImpl4Cg UserServiceImpl4Cg = (UserServiceImpl4Cg) cglib.getInstance(new UserServiceImpl4Cg());
        UserServiceImpl4Cg.addUser();
    }
}