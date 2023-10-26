package src.main;

/**
 * 写个代码看多线程是否可以提高开发效率,如果能的话,那么又能提高多少
 */


public class Demo1 {


    public static final long COUNT = 100_0000_0000L;
    public static void main(String[] args) {


       serial();
      concurrency();
    }

    //串行执行任务
    public static void serial(){
        //毫秒级别的时间戳
        long begin = System.currentTimeMillis();
        long a = 0;
        for (long i = 0; i < COUNT; i++) {
            a++;
        }

        a = 0;

        for (long i = 0; i < COUNT; i++) {
            a++;
        }

        long end = System.currentTimeMillis();
        System.out.println("执行任务的时间:"+ (end - begin)+"ms");


    }


    //并发执行任务
    public static void concurrency(){

        long begin = System.currentTimeMillis();

        Thread t1 = new Thread(()->{
            long a = 0;
            for (long i = 0; i < COUNT; i++) {
                a++;
            }
        });

        Thread t2 = new Thread(()->{
            long a = 0;
            for (long i = 0; i < COUNT; i++) {
                a++;
            }
        });


        t1.start();
        t2.start();

        //在main中调用t1.join的效果就是让main线程(调用该方法)阻塞,让代码先停一停,等到t1执行完run之后,main才继续执行(t2同理)
        //t1和t2是并发执行的,而不是先执行t1 再执行t2
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long end = System.currentTimeMillis();
        System.out.println("执行任务的时间:"+ (end - begin)+"ms");
    }
}
