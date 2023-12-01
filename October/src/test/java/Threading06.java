package src.test.java;

/**
 *在该类中我们将进行一个测试:
 *  测试 notifyAll()方法唤醒的是所有的wait方法还是只唤醒和自己有着相同对象调用的wait方法??
 */
public class Threading06 {
  public static void main(String[] args) throws InterruptedException {
    Object object = new Object();
      Object object1 = new Object();

      //创建线程1
      Thread thread1 = new Thread(()->{
          //wait方法一定要写在锁里面,因为wait方法一旦被唤醒是需要释放锁的
          synchronized(object) {
              System.out.println("线程1的wait方法之前");
              try {
                 object.wait();
              } catch (InterruptedException e){
                  e.printStackTrace();
              }
              System.out.println("线程1的wait方法之后");

              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }

          }
      });
      thread1.start();

  //创建线程2
      Thread thread2 = new Thread(()->{
          synchronized(object) {
              System.out.println("线程2的wait方法之前");
              try {
                  object.wait();
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              System.out.println("线程2的wait方法之后");
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
          }
      });

      thread2.start();

      //创建线程3
      Thread thread3 = new Thread(()->{
          synchronized(object1) {
              System.out.println("线程3的wait方法之前");
              try {
                  object1.wait(); // thread3 线程调用wait的对象和thread1以及thread2不同
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              System.out.println("线程3的wait方法之后");
            //  System.out.println("=========================================");
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
          }
      });

      thread3.start();


//创建线程3
      Thread thread4 = new Thread(()->{
          synchronized(object1) {
              System.out.println("线程4的wait方法之前");
              try {
                  object1.wait(); // thread4 线程调用wait的对象和thread1以及thread2不同
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              System.out.println("线程4的wait方法之后");
              //  System.out.println("=========================================");
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
          }
      });

      thread4.start();



      //唤醒线程的操作
      Thread thread5  = new Thread(()->{
          //这个线程将会调用notifyAll() 方法,目的是唤醒所有的wait方法

          synchronized(object) {
              System.out.println("notifyAll方法调用之前");

              object.notifyAll();

              System.out.println("notifyAll方法调用之后");

          }
      });

      thread5.start();

      thread1.join();
      thread2.join();
      thread3.join();
      thread4.join();
      thread5.join();

  }

}
