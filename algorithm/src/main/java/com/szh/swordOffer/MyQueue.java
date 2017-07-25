package com.szh.swordOffer;

import java.util.Stack;

/**
 * 7.1两个栈实现队列
 */
public class MyQueue {

    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();

    public void appendTail(Integer a) {
        stack1.push(a);
    }

    public Integer deleteHead() throws Exception {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new Exception("队列为空，不能删除");
        }
        return stack2.pop();
    }

    public static void main(String[] args) throws Exception {
        MyQueue queue = new MyQueue();
        queue.appendTail(1);
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
    }
}
