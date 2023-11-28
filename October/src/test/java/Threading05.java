package src.test.java;

/**
 * 这个类中测试的是Object中的两个方法
 * 分别是 :
 * 1. wait() 方法
 * 2. notify() 方法
 *  我们调用完wait方法之后,wait操作的内部其实 做了三件事 :
 *      2.1 释放当前锁
 *      2.2 进行等待 ,等待通知
 *      2.3 满足一定的条件之后(别人使用相同的实例调用notify方法的时候)被唤醒,然后尝试重新加锁
 *
 *      wait 可以理解为如果当前的代码执行的时机还不过成熟,得结合具体的业务逻辑来看待
 *      notify 的调用也必须包含在 synchronized 里面
 *
 *      比如 : 线程 1 没有释放锁的话,线程 2 是无法调用到 notify 方法的,因为此时的线程 2 处于阻塞等待, 线程 1 调用该wait 之后,在wait里面
 *      就会释放 锁,这个时候线程 1 代码就会阻塞在 synchronized里面,而wait释放锁之后,线程2 就可以成功加锁了,然后再线程1 阻塞的时候,线程2
 *      完成调用notify的时候,就相当于告诉了线程1 可以开始重新加锁了,然后这个时候就又会进入阻塞,直到线程 2 解锁成功之后,线程1 才会解锁成功.
 */
public class Threading05 {


    //这是第一个线程,会在这里面调用wait方法
    public static void main(String[] args ){
        Object object = new Object();
        Thread thread1 = new Thread(()->
        {
            while(true){
                synchronized (object){
                    System.out.println("wait之前");
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("wait之后");
                }
            }
        });

        thread1.start();

        Thread thread2 = new Thread(()->{
           while(true){
               synchronized(object){
                   System.out.println("notify之前");
                   object.notify();
                   System.out.println("notify之后");
               }
               try {
                   Thread.sleep(5000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });

        thread2.start();

    }
}
