package src.demo;

import java.util.Stack;

public class Solution {
    public static void main(String[] args){

    }

    public boolean isPopOrder(int[] pushA,int[] popA){
        if(pushA.length==0||popA.length==0){
            return false;
        }

        //准备一个栈,用来push数组
        Stack<Integer> stack = new  Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            //进行压栈操作
            stack.push(pushA[i]);

            while(!stack.empty()&&j< popA.length&&stack.peek().equals(popA[j])){
                stack.pop();
                j++;
            }

        }
        return stack.empty();

    }

}
