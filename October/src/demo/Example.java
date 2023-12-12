package src.demo;

public class Example {
    public void someMethod() {
       int localVar = 42;//局部变量(没有显式的使用final修饰)
//局部变量必须是 final 或者是 effectively final
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(localVar);//在匿名内部类中访问外部类的局部变量
            }
        };
        // 使用匿名内部类的实例
        new Thread(r).start();
    }
}