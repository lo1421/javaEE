package src.main;

/**
 * 多线程
 * 线程是什么?现成是"轻量级"的进程
 * 进程已经可以实现"并发编程"但是频繁的创建和销毁进程的代价比较的大,开销也比较大,所以引入线程是对多进程程序的优化
 * 统一个进程中的线程之间共用同一份的系统的资源(文件描述附表就是文件资源+内存资源)
 * 进程中包含了线程,一个线程对应一个PCB,一个进程对应一组PCB(调度信息:状态,优先级,进程调度的上下文,记账信息这些都是一个线程独有一份)
 * 进程是资源分配的基本单位,线程是调度执行的基本单位
 * 多线程程序,能够有效的提高程序运行的效率(能够更加充分的利用多核CPU)
 */

/*
创建线程的方法
1.继承Thread类,实现run方法,调用start方法
2.实现Runnable接口,重写run方法,调用start方法
3.继承Thread类,使用匿名内部类
4.实现Runnable接口,使用匿名内部类
5.lambda表达式
 */

/**
 * 我们给线程起的名字,可以通过第三方的程序比如 JDK 的 bin目录下的 jconsole.exe 就可以显式的看见我们给线程起的名字
 * 这样做的目的就是我们可以非常便捷的控制线程
 * 程序员工作的很大部分就是在命名
 */
public class Demo8 {
    public static void main(String[] args){
    }

    /**
     * 创建线程的方法1
     * 不带参数
     * 创建线程对象
     */
    public static void creatThread1(){
        Thread thread = new Thread(()->{
            //线程具体的需要做的事
        });
    }

    /**
     * 创建线程的方法2
     * 带一个参数
     * 带一个Runnable实现类对象的参数
     */
    public static void createThread2(){
        Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println("线程!");
            }
        });
    }

    /**
     * 创建线程的方法3
     * 带一个参数
     * String类型的参数,创建线程对象的同时用来给线程命名的
     */
    public static  void createThread3(){
        Thread thread = new Thread("ThreadName!");
    }

    /**
     * 创建线程的方法4
     * 带两个参数
     * 使用Runnable皆苦对象创建线程对象,并命名
     */
    public static void createThread4(){
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("线程!");
            }
        },"这是线程的名字");//这个名字是允许重复的,取这个名字是为了方便之后调试
    }

    /**
     * 创建线程的方法5
     * 带两个参数[了解]
     * 线程可以用来分组管理,分好组的线程就称为线程组
     */
    public static void createThread5(){
       // Thread thread  = new Thread(ThreadGroup group,Runnable target);
    }
}
