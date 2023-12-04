package src.demo;

import java.util.*;
import java.util.Stack;


/*
含有min函数的栈

这个题目需要我们自己实现栈的基本的结构
 */

public class Solution3 {

    //这个栈1是我们的主要的栈
Stack<Integer> stack1 = new Stack<>();

//这个栈2 是我们专门用来保存最小值的栈
Stack<Integer> stack2 = new Stack<>();
    
    public void push(int node) {

        //准备一个辅助栈,这个栈必须在push方法中,因为这样我们就可以直接就保证min函数里面的栈中保存的一定是最小的值
        //所以我们就只需要在插入元素的时候就进行筛查

        if (stack1.empty()){
            stack2.push(node);
            stack1.push(node);
        }else{
            if (node>=stack2.peek()){
                stack1.push(node);
            }else{
                stack2.pop();
                stack2.push(node);
            }
           stack1.push(node);
        }
    }
    
    public void pop() {
        stack1.pop();
    }
    
    public int top() {
       return stack1.peek();
        
    }
    
    public int min() {
        return stack2.pop();
    }
}
