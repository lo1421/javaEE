package src.demo;

import java.util.Stack;

/**
 * 描述
 * 用两个栈来实现一个队列，
 * 使用n个元素来完成n 次在队列尾部插入整数(push)和n次在队列头部删除整数(pop)的功能。
 * 队列中的元素为int类型。保证操作合法，即保证pop操作时队列内已有元素。
 * 数据范围: n<1000要求:存储n个元素的空间复杂度为 O(n)，插入与删除的时间复杂度都是 O(1)

 */

/*分析之后我们知道其实这里的两个栈的容量是无限的,或者可以理解为是相同的容量,那么如果我们想模拟队列的时候
使用两个容量相同的辅助栈的时候,其实可将一个栈作为入队操作,另外一个栈作为出队操作,这两个栈的工作是可以随意分配的
也就是不管是谁来出队或者谁来入队,效果都是一样的
 */
public class Solution2 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        //我们把stack1 作为入队的操作
        stack1.push(node);

    }

    public int pop() {
        //我们把stack 2 作为出队的操作
        if (stack2.empty()){

            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
