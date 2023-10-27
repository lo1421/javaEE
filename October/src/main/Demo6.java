package src.main;

/**
 * 测试使用Lambda表达式完成线程对象的创建
 * 优点 : 非常的简洁
 */
public class Demo6 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
                System.out.println("thread!");
        });
    }
}
