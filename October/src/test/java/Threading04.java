package src.test.java;

import java.util.Scanner;

/**
 * 在这个程序中我们就要进行修改操作,看看在多线程的条件下,是否会因为内存可见性而发生线程不安全!
 * 如果在这个线程中加入volatile关键字的话,那么我们的线程就不会因为编译器的优化机制
 * volatile是拿来修饰变量的,volatile修饰的变量是不会被编译器优化的
 */
public class Threading04 {

    static class Counter{
        public int count = 0;
        public Counter(){

        }
    }
    public static void main(String[] args){
        Counter counter = new Counter();

        Thread thread1 =new  Thread(()->{
            synchronized (counter) {
                //这是仅仅进行读操作的线程
                while (counter.count == 0) {

                }

                System.out.println("thread1 线程结束!");
            }

        });

        thread1.start();

        Thread thread2 = new Thread(()->{
           //从键盘中输入一个非零的数据
           Scanner scanner = new Scanner(System.in);
            System.out.println("从键盘输入一个非零的int型数据 : ");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

           counter.count = scanner.nextInt();  //把输入的值拿来对count值进行修改操作


            System.out.println("thread2 线程结束!");
        });

        thread2.start();
    }
}
