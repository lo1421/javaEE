package src.main;

/**
 * 测试线程创建的第一种方式
 * 继承Thread类,实现run方法,子类引用调用 start()方法
 * 缺点 : 线程 和 线程需要做的事情耦合度太高了,后续不利于扩展
 */

public class Demo2 {
   static  class thread extends Thread{
       @Override
       public void run() {
           System.out.println("thread!");
       }
   }

    public static void main(String[] args) {
       thread t1 = new thread();
        t1.start();
    }
}
