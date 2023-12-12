package src.main;

public class AnonymousInnerClassExample {
    public static void main(String[] args) {
        // 尝试在匿名内部类中定义静态成员（编译错误）
        Runnable myRunnable = new Runnable() {
            // 尝试定义静态成员变量（编译错误）
            // static int staticVariable = 20;

            @Override
            public void run() {
                // 尝试定义静态方法（编译错误）
                // staticMethod();
                System.out.println("Inside Runnable");
            }
        };

        // 调用匿名内部类中的 run 方法
        myRunnable.run();
    }

    // 尝试在外部类中定义静态方法（正常）
    public static void staticMethod() {
        System.out.println("Static method");
    }
}
