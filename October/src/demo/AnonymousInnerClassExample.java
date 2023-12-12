package src.demo;

interface Greeting {
    void greet();
}

public class AnonymousInnerClassExample {

    public static void main(String[] args) {
        // 使用匿名内部类实现接口并包含字段和方法
        Greeting greeting = new Greeting() {
            //字段
            private String message = "Hello from anonymous inner class";

            @Override
            public void greet() {
                System.out.println(message);
                sayGoodbye(); // 调用匿名内部类中定义的方法
            }
			//方法
            private void sayGoodbye() {
                System.out.println("Goodbye from anonymous inner class");
            }
        };

        // 调用实例方法
        greeting.greet();

    }
}
