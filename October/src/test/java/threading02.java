package src.test.java;


public class threading02 {
    public static Counter counter = new Counter();
    public static Counter counter1 = new Counter();

    public static void main(String[] args){
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                counter.increase();
            }
        });

        Thread t2 =  new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                counter1.increase();
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

        System.out.println(counter.count);
        System.out.println(counter1.count);
    }
}
