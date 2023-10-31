package src.main;

/**
 * run 方法执行完了,线程就结束了
 * 有没有办法让线程提前结束,就是通过线程中断的方式来进行的(本质仍然是让run方法尽快结束,而不是润执行一半强行结束)
 *
 * 而让 run 方法提前结束时要看run方法里面具体是如何实现的
 * 1.自己手动定义一个标志位,也就是做个标记
 * 2.还可以使用标准库里面自带的一个标志位
 */
public class Demo10 {
    private static boolean isQuit = false;//多个线程共用内存资源空间,所以这个常量既可以在主线程中使用,也可以在新线程中使用
    public static void main(String[] args){
    Thread thread = new Thread(()->{
        while(!isQuit){
            System.out.println("Hello Thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("thread线程执行完了");
    });

    thread.start();
        //这里main线程的任务
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //在这里把thread线程给结束掉,通过标志位来手动结束
        isQuit = true;
        System.out.println("设置让thread线程结束!");

    }
}
