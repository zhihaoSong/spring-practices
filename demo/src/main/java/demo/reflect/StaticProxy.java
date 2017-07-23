package demo.reflect;

/**
 * Created by zhihaosong on 17-7-23.
 * 静态代理
 * 由程序员创建或特定工具自动生成源代码，再对其编译。在程序运行前，代理类的.class文件就已经存在了。
 * 1.每一个代理类只能为一个接口服务
 * 2.所有的代理操作除了调用的方法不一样之外，其他的操作都一样，则此时肯定是重复代码
 */
public class StaticProxy implements UserService {

    private UserServiceImpl userImpl;

    public StaticProxy(UserServiceImpl countImpl) {
        this.userImpl = countImpl;
    }

    public void addUser() {
        System.out.println("代理类方法，进行了增强。。。");
        System.out.println("事务开始。。。");
        // 调用委托类的方法;
        userImpl.addUser();
        System.out.println("处理结束。。。");
    }

    public void editUser() {
        System.out.println("代理类方法，进行了增强。。。");
        System.out.println("事务开始。。。");
        // 调用委托类的方法;
        userImpl.editUser();
        System.out.println("事务结束。。。");
    }

    public static void main(String[] args) {
        UserServiceImpl userImpl = new UserServiceImpl();
        StaticProxy proxy = new StaticProxy(userImpl);
        proxy.addUser();
        System.out.println("----------分割线----------");
        proxy.editUser();
    }
}