package main.java.cp1_StkAndQue.p13;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by solid on 16-12-13.
 * 类型: 整形
 * 功能: 创建一个能自动排序的栈
 * 条件: 只允许申请一个栈.可以申请新的变量,不能申请额外数据结构
 * 难度: ???
 *
 */
public class p13 {

    @Test
    public void testPush() {
        System.out.println("test push() begin ! ");
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(4);
        myStack.push(6);
        myStack.push(2);
        myStack.push(5);
        myStack.push(3);
        myStack.push(7);
        while (!myStack.isEmpty()) {
            System.out.println(myStack.pop());
        }
    }

    @Test
    public void testPeek() {
        System.out.println("test peek() begin ! ");
        MyStack myStack = new MyStack();
        myStack.push(1);
        System.out.println(myStack.peek());
        myStack.push(2);
        System.out.println(myStack.peek());
        myStack.push(3);
        System.out.println(myStack.peek());
        myStack.push(4);
        System.out.println(myStack.peek());
        myStack.push(5);
        System.out.println(myStack.peek());
    }

}

class MyStack{

    private Stack<Integer> stack = new Stack<Integer>();

    public boolean push(Integer num){
        try {
            if(null==num){
                return false;
            }
        }catch (Exception e){
            System.out.println("error in push method : " + e.getLocalizedMessage());
        }
        if (stack.empty() || num > stack.peek()){
            stack.push(num);
            return true;
        }else {
            Integer tmp = stack.pop();
            if (push(num)){
                stack.push(tmp);
            }
            return true;
        }
    }

    public Integer pop(){
        if (!stack.empty()){
            return stack.pop();
        }else return null;
    }

    public Integer peek(){
        if (!stack.empty()){
            return stack.peek();
        }else return null;
    }

    public boolean isEmpty(){
        return  stack.isEmpty();
    }

}