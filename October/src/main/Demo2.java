package src.main;

public class Demo2 {
   static  class thread extends Thread{
       @Override
       public void run() {
           System.out.println("thread!");
       }
   }

    public static void main(String[] args) {
       thread t1 = new thread();
       Thread thread = new Thread(t1);
        thread.start();
    }
}
