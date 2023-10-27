package src.main;

/**
 * 测试创建线程的方式二
 * 实现 Runnable接口,然后 实现 run方法,创建 Thread类型的引用, 把 时间Runnable接口的对象传给 Thread对象的有参构造方法
 * 然后Thread类型的引用调用 start()方法
 */
public class Demo3 {
    static class run implements Runnable{
        public void run(){
            System.out.println("thread");
        }
    }
    public static void main(String[] args) {
        Thread t1 =new Thread(new run());
        t1.start();

        Thread t2  = new Thread(new run());
        t2.start();
    }

}
