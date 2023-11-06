package src.main;

/**
 * Thread.sleep() 指定一个休眠的时间,手动阻塞线程,阻塞的时间可以自己定义,按照方法的参数规则来阻塞
 * 操作系统关系这些PCB的时候是有多个链表的,而这些链表上的节点就是一个个的PCB
 * 同时链表分为: 阻塞队列 和 就绪队列
 * 如果在就绪队列中的 PCB(线程A) 被设置成阻塞状态,那么就会把当前这个PCB(线程A) 从 就绪队列拿到 阻塞队列中,而只有就绪队列中的PCB才会参与CPU的调度
 * 如果当前的线程A的阻塞时间结束了,那么就会把线程A 从 阻塞队列 拿回到 就绪队列 中
 * 但是呢挪回到就绪序列中并不代表马上就可以执行,还是得看cpu什么时候去调度线程A
 * 所以 sleep(1000) 由于现实中真正的休眠的时间包括了sleep阻塞的时间+cpu调度等待的时间 开销 ,所以具体休眠的时间可能会略多于1000的
 * */
/*
操作系统的调度开销是不可预期的,有可能快有可能慢,而且还跟操作系统的不同而不同,但是我们有时候期望这个调度开销尽可能的小
在这种问题存在的情况下,我们就出现了一种解决办法,那就是 "实时操作系统" ,这个操作系统的特点就是 线程任务的调度是在预期之内的
但是一般情况下,民用其实用不到这种这种操作系统,通常是在航天,火箭系统
 */

/**
 * 线程的状态
 * 在操作系统中有自带的对PCB状态的描述
 * 但是java额外又定义了一些关于线程的状态
 */
public class Demo14 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
           /* for (int i = 0; i < 10000_0000; i++) {
                //什么都不做
            }*/
            //如果这里的代码表示线程执行的工作,那么我们把当前线程的变成阻塞的状态,之后获取的时候会出现什么样的结果呢?
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        //java中这里得到的线程的状态就是NEW ,此时的线程对象在java中创建出来了,但是在内核中还没有创建PCB
        System.out.println("获取线程t的状态:" + t.getState());

        t.start();

        Thread.sleep(50);//休眠一定的时间保证我们的代码雀食已经在执行了,这里的意思其实就是让main线程等等thread线程的执行

        //此时线程的状态是正在工作,那么状态应该是RUNNABLE ,而RUNNABLE其实包含的是PCB在就绪队列中以及cpu正在调用
        System.out.println("获取线程t的状态:"+ t.getState());


            t.join();//这里是让main线程等t执行完,也就是对main线程的一种阻塞

        //java中,t结束之后,这里获得的线程的状态就是 TERMINATED
        System.out.println("获取线程t的状态:"+t.getState());
    }
}
