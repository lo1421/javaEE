package src.main;

/**
 * 1. 线程等待,线程之间的调度的顺序是不确定的
 * 我们可以通过一些特殊的操作,来对线程的执行顺序人为进行干预,join()方法就是其中的一个方式,控制线程之间的结束顺序
 * 在main线程中使用thread.join()就是让main线程阻塞等待等到thread执行完了,然后main才会继续执行,这个时候线程
 *
 * 2.调用的原则:
 * 在什么方法里面调用的就表示此时的方法处于阻塞的状态,而等待另一个线程执行完才能继续执行
 * 用什么线程的引用对象调用的那么就是这个线程就是被等待的线程
 * */
public class Demo12 {
    public static void main(String[] args){
        //创建线程
        Thread thread  = new Thread(()->{
            System.out.println("thread1线程开始执行!");
         for (int i = 0;i < 5;i++){
               System.out.println("hello thread !");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();

               }
           }
        });
        thread.start();

        System.out.println("main 线程 join 之前");
        try {
            thread.join();//阻塞的事main方法,而且main等待的是thread异常
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main 线程 join 之后");

    }
}
