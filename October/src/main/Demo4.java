package src.main;

/**
 * 测试创建线程的方式三 使用匿名内部类实现 Thread 抽象类的对象
 * 然后调用start()方法
 */
public class Demo4 {

    public static void main(String[] args) {
    Thread t1 = new Thread(){
        public void run(){
            for (int i = 0; i < 100_0000; i++) {
                System.out.println("thread1");
            }

            }
    };

    Thread t2 = new Thread(){
        public void run(){
          for (int i = 0;i<100_0000;i++){
                System.out.println("thread2");

        }
            try {
                Thread.sleep(1);//ms
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    };

    t1.start();
    t2.start();

    }
}
