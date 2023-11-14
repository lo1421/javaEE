package src.demo;

/**
 * 创建线程的方法
 */
public class test01 {
    public static int  count  = 0;
    public static void main(String[] args){
        //使用匿名内部类继承Thread类,重写run方法
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                super.run();
            }
        };

        //使用匿名内部类实现Runnable接口,重写run方法
      Thread thread2 = new Thread(new Runnable(){
          @Override
          public void run() {

          }
      });

       //使用Lambda表达式,把run方法作为参数传给Thread类的构造方法
        Thread thread3 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                count++;
            }
        });

    }
}
