package src.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
    public static void main(String[] args) {
        // 创建固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 提交任务给线程池执行
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            executorService.execute(() -> {
                System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName());
            });
        }

        // 关闭线程池
        executorService.shutdown();
    }
}
