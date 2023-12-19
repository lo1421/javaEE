package src.demo;

public class RunnableExample {

    public static void main(String[] args) {
        // 使用Runnable创建一个任务
        Runnable runnableTask = () -> {
            System.out.println("Executing Runnable task...");
            // 模拟一个耗时操作
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // 创建一个线程来执行Runnable任务
        Thread thread = new Thread(runnableTask);
        thread.start();

        // 此时可以执行一些其他的操作
    }
}
