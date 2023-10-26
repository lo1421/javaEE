package src.main;

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
