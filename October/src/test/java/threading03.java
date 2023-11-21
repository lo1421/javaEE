package src.test.java;

/**
 * 无论所对象是什么样的形态或者是什么样的类型,核心的原则都只是作为起到担任锁对象的功能,而如果两个线程争一个锁对象,就会存在竞争,多个线程分别是不同
 * 的锁对象,那么就不会存在锁竞争,而锁竞争存在的意义其实是为了反制线程不安全的问题.
 */

/**
 * 线程对象的创建方法
 * 五种:
 * 第一种 : 继承 Thread 类, 实现run方法
 * 第二种 : 实现 Runnable接口,实现run方法
 * 第三种 : 使用匿名内部类继承Thread类,重写run方法
 * 第四种 : 使用匿名内部类实现Runnable接口,重写run方法
 * 第五种 : 使用Lambda表达式.利用函数式接口,给方法传入参数
 *
 */

class Student extends Thread{
    public String name;
    public int age;

    /**
     * 构造方法
     */
    public Student(){

    }

    public Student(String name,int age){
        this.name = "张三";
        this.age = 20;
    }

    @Override
    public void run() {

    }
}
public class threading03 {
    public static void main(String[] args){
    Thread thread1 = new Thread();
    }
}
