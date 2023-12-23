package src.main;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo19 {
    public static void main(String[] args) {

        /*
        原本我们的count++在多线程环境下不是原子性的,所以多个线程同时进行count++操作的时候大概率是会发生线程不安全的
        所以我们就可以通过volatile和synchronized这类关键字保证在多线程环境下count++这种操作是线程安全的
        但是呢现在我们要保证count++这种操作是安全的还有一种方式就是使用Java标准库中已经封装好了的一些类的原子类
         */
        AtomicInteger atomicInteger = new AtomicInteger(0);
        /*
          //相当于++count
                atomicInteger.incrementAndGet();
                //相当于count--
                atomicInteger.getAndDecrement();
                //相当于--count
                atomicInteger.decrementAndGet();
         */

        //创建一个线程Thread1
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                //相当于count++
               atomicInteger.getAndIncrement();
            }
        });

        //创建一个线程Thread2
       Thread t2 = new Thread(()->{
           for (int i = 0; i < 50000; i++) {
               atomicInteger.getAndIncrement();
           }
       });

       t1.start();
       t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
