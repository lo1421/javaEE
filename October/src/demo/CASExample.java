package src.demo;

import java.util.concurrent.atomic.AtomicInteger;

public class CASExample {
    // 使用AtomicInteger作为计数器，初始值为0
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        // 模拟多线程并发操作
        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                incrementCounter();
            }
        };

        // 创建两个线程来执行增加计数器的任务
        Thread thread1 = new Thread(incrementTask);
        Thread thread2 = new Thread(incrementTask);

        // 启动线程
        thread1.start();
        //thread2.start();

        try {
            // 等待两个线程执行完毕
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 输出最终的计数器值
        System.out.println("Final Counter Value: " + counter.get());
    }

    // 使用CAS操作增加计数器的值
    private static void incrementCounter() {
        int oldValue, newValue;

        do {
            // 读取当前计数器的值
            oldValue = counter.get();
            // 计算新的值
            newValue = oldValue + 1;
            // 使用CAS操作尝试更新计数器的值
        } while (!counter.compareAndSet(oldValue, newValue));

        // 注意：由于CAS操作是原子的，如果成功，新值已经被更新，不需要额外的同步
    }
}
