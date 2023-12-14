package src.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
使用Java标准库中的线程池
线程池中的线程只是在用户态使用线程
而我们平时创建的线程是 用户态->内核态 的,避免不了有很多开销
 */
public class Demo17 {
public static void main(String[] args){
    //这里是通过调用Java中的线程池中提供的工厂方法来创建线程池对象
    ExecutorService poor = Executors.newCachedThreadPool();
    //通过调用线程池中的submit提交任务方法,完成把任务传给线程池中的线程的工作
    poor.submit(new Runnable() {
        @Override
        public void run() {
            System.out.println("任务执行!");
        }
    });

}
}
