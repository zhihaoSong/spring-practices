package com.szh.swordOffer.Problem46;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem46
 * 求1+2+...+n，不能使用乘除法，循环等
 * 利用反射找到函数名递归得到
 *
 * @author hztaoran
 */
public class Calculate {

    public int terminal(int n) {
        return 0;
    }

    public int sum(int n) throws Exception {
        List<Boolean> list = new ArrayList<>();
        list.add(false);
        list.add(true);
        Method[] methods = this.getClass().getMethods();
        int index = list.indexOf(n == 0);
        return (n--) + (Integer) methods[index].invoke(this, n);
    }
}
