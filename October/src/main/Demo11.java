    package src.main;

    /**
     * run 方法执行完了,线程就结束了
     * 有没有办法让线程提前结束,就是通过线程中断的方式来进行的(本质仍然是让run方法尽快结束,而不是润执行一半强行结束)
     *
     * 而让 run 方法提前结束时要看run方法里面具体是如何实现的
     * 1.自己手动定义一个标志位,也就是做个标记
     * 2.还可以使用标准库里面自带的一个标志位
     */
    public class Demo11 {

        public static void main(String[] args){
            Thread thread = new Thread(()->{
                while(!Thread.currentThread().isInterrupted()){//这里是通过这个currentThread()静态方法我们可以拿到当前线程对应的Thread对象实例
                    //通过获取的当前线程对象然后去调用isInterrupted()方法
                    System.out.println("Hello Thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        //e.printStackTrace();这个是打印异常信息的代码,我们可以选择一旦触发了sleep异常就直接break
                        break;
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

            //在这里把thread线程给结束掉,通过标准库中带的方法来实现
            thread.interrupt();
            System.out.println("设置让thread线程结束!");
        }
       /*
 thread 线程在阻塞状态(sleep)不会设置标志位,而是触发一个interruptException异常,这个异常会把sleep提前唤醒,
 但是由于代码中只是打印了日志,并没有结束循环,因此线程还是在继续执行中,        */
    }
