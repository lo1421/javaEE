package src.main;

/**
 * 测试创建线程的四四种方式
 * 使用匿名内部类实现Runnable接口,然后重写run方法
 * 之后使用Thread类型的引用调用start方法就表示开启了一个线程
 *
 */
public class Demo5 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread!");
            }
        });
    }
}
