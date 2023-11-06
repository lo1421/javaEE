package src.main;

/**
 * 获取当前线程的引用 currentThread() 返回当前线程对象的引用
 */
public class Demo13 {
    public static void main(String[] args){

        Thread t1 = new Thread(()->{
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("thread1");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
            System.out.println("thread线程执行完了!");
        });

        t1.start();
        System.out.println("main线程开始!");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("mian线程执行完了!");

        /*
        我们可以在main方法中随意定义一个逻辑用来阻塞作为thread1 线程终止的一个判断条件,我们这里在main方法中实现的逻辑就是
        等main执行3秒之后就可以把thread线程给结束掉了,所以这个时候我们就需要把系统调用的方法给修改成阻塞状态
         */
        t1.interrupt();
        System.out.println("设置让mian线程结束!");
    }

}
