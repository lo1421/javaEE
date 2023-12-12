package src.main;

public class Example {
    private int memberVar = 10;

    public void modifyMemberVar() {
        // 匿名内部类
        Runnable r1 = new Runnable() {
            @Override
            public synchronized  void run() {
                // 访问外部类的成员变量
                System.out.println("Before modification: " + memberVar);

                // 修改外部类的成员变量
                memberVar = 20;

                System.out.println("After modification: " + memberVar);
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public synchronized  void run() {
                // 访问外部类的成员变量
                System.out.println("Before modification: " + memberVar);

                // 修改外部类的成员变量
                memberVar = 20;

                System.out.println("After modification: " + memberVar);
            }
        };

        // 使用匿名内部类的实例
        new Thread(r1).start();
        new Thread(r2).start();
    }

    public static void main(String[] args) {
        Example example = new Example();
        example.modifyMemberVar();
    }
}
