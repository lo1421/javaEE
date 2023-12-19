package src.demo;

import java.util.concurrent.*;

public class CallableTest {
    public static void main(String[] args) {
        Callable<String> stringCallable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                return "任务执行结束!";
            }
        };

        FutureTask<String> futureTask = new FutureTask<>(stringCallable);

        Thread thread = new  Thread(futureTask);
        thread.start();

        try {
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
