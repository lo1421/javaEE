package src.main;

/**
 * 线程类中的几个常见的属性,通过方法去获取
 */
public class Demo9 {
    public static void main(String[] args) {
    Thread thread = new Thread(()->{
        while(true){
            System.out.println("thread!");

            try {
                Thread.sleep(1000);//休眠1s(1000ms)
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    },"线程的名字~");

       // thread.setDaemon(true);//通过setDaemon方法可以手动的将当前的线程设置为前台或者后台线程,这样我们就可以手动控制该线程是否会阻止进程
        //注意 !!!这个setDaemon(Boolean)方法必须在start方法之前设置,如果在start方法之后设置,是不会成功的,也就是启动了的线程是无法修改Daemon的

        //只有调用了start方法才是真正的创建了一个线程,而且这个时候的线程是前台线程,前台线程没有结束main方法结束与否都不影响,但是后台线程只要main结束了
        // 就不会继续执行下去
        thread.start();


        //① getId() 获取线程属性ID(这里的ID是在java环境中给线程对象安排的身份标识,和操作系统内核汇总的PCB的pid,以及和操作系统提供的API的线程ID都不是一回事)
        System.out.println("java中线程的ID"+thread.getId());

        //② getName() 获取线程属性name,这里的名称就是我们之前手动通过给线程对象的构造方法传入参数指定的name
        System.out.println("线程的名字"+ thread.getName());

        //③ getState() 获取线程属性状态,后面详细介绍
        System.out.println("线程的状态" + thread.getState());

        //④ getPriority()获取线程的优先级
        System.out.println("线程的优先级"+ thread.getPriority());

        //⑤ isDaemon() 判断当前的线程是否是"守护/精灵线程" ,可以翻译成"后台线程" 我们默认创建的线程是前台线程.
        // 前台线程会阻止进程退出,也就是如果main(主)线程运行完了,但是前台线程还没有运行完,那么当前的进程不会退出
        // 后台线程无法阻止进程退出,而是后台线程即使没有执行完也会跟着主线程/前台线程的结束而结束
        System.out.println("当前的线程是否是后台线程?" + thread.isDaemon());

        /*⑥ isAlive() 判断当前线程是否存活,thread 对象虽然和内核中的线程是一一对应的关系,但是生命的周期并不是完全的相同
        thread对象出来了,内核里的线程还不一定有,调用start方法,内核线程才会有,当内核里面的线程执行完了(也就是run运行完了)内核的线程销毁了
        但是Thread对象还在,而isAlive()方法是判断内核中的线程是否还在
        */
        System.out.println("内核中的线程是否还存在?" + thread.isAlive());



        System.out.println("main线程执行结束!");

    }
}
