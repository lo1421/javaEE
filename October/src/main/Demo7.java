package src.main;

/**
 * Thread 的 API 调用 测试类
 */
public class Demo7 {
    public static void main(String[] args){
        Thread t1 = new Thread(()->{
           while(true){
               System.out.println("hello thread");

               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        },"这是线程的名字");//这里是带有两个参数的构造方法,前一个是使用lambda表达式实现的函数,后一个参数是String类型的用来给线程命名的
        t1.setDaemon(true);//这是吧默认的前台线程t1设置成后台线程的方法

        t1.start();
        System.out.println("main线程执行结束!");
    }

}
/*
我们默认创建的线程是"前台线程",前台线程会阻止进程退出,如果main运行完了,但是前台线程还没有结束,那么进程这个时候也是不会退出的
如果我们通过setDaemon()方法吧线程给修改成"后台线程",那么这个时候"后台线程"就不会阻止进程退出,如果main以及其他的前台线程都执行完了,
那么这个时候,即使后台线程没有执行完,进程也是会推出的
 */