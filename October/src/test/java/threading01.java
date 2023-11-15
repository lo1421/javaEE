package src.test.java;

/**
 * 这个类是用来测试多个线程是否是安全的,而线程是否安全是取决于我们在完成具体的项目的时候,是否会出现bug
 * 而bug就表示我们完成这个业务的时候,不能够得到正确的结果
 */


class Counter{
    public int count ;
    public synchronized void increase(){
        synchronized (Counter.class){
            count++;
        }
    }

}
public class threading01{
    //创建一个Counter类型的的静态的对象
    public static Counter counter  = new Counter();

    //我们通过Counter对象中的count()方法,然后就可以对count对象进行加一
    //现在我们的业务就是通过两个线程,每个线程都调用5w次的自增方法,那么我们程序执行完之后,就获取Counter对象的count,按照预期的结果应该是拿到10w
    public static void main(String[] args) throws InterruptedException {
       Thread t1 = new Thread(()->{
           for (int i = 0; i < 50000; i++) {
               counter.increase();
           }
       });

       Thread t2 = new Thread(()->{
           for (int i = 0; i < 50000; i++) {
               counter.increase();
           }
       });

       //开启两个线程
        t1.start();
        t2.start();

        //让main线程等等t1 和 t2 两个线程,等这两个线程执行完之后再执行面线程中的代码,这里的意思其实就是阻塞main方法的执行,等t1 和 t2 执行完之后再执行
        t1.join();
        t2.join();

        //然后打印我们业务中的count
        System.out.println("两个线程执行完之后的count的结果:"+counter.count);
    }
}
