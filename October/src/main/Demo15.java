package src.main;

/**
 * 接下来的代码是一个单例模式的懒汉实现
 * 懒汉模式就是等真正的调用get方法的时候才会6真的创建一个实例,而且这个实例一定是类级别的,不允许
 * 创建多个的,一个线程中只允许存在这一个实例,所以我们就不能对外暴露缺省构造器
 *
 * 其实可以通过反射机制获取多个实例
 *
 * 这里我们主要是实现一个比较完整的懒汉模式
 * volatile关键字是防止new实例的时候编译器的指令重排序机智的发生
 *
 * get方法中的两个if语句各自发挥的作用不一样
 * 外部的if语句是防止线程的过度调用,浪费
 * 里面的if语句是防止重复的创建多个实例
 *
 * 还有个需要注意的点就是我们的线程不安全引发的问题,为了在多线程下以下的代码不会引起线程不安全,所以这就需要我们去
 * 给我们需要加锁的代码加上锁,但是为了防止锁的过度使用所以加了个if条件语句,只有需要加的时候加锁,不需要的时候就不加锁
 *
 */
class SingletonLazy{
    private volatile static SingletonLazy instance = null;

    public static SingletonLazy getInstance(){
        if(instance == null){
            synchronized(SingletonLazy.class){
                if (instance == null){
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }

    private SingletonLazy(){

    }
}
public class Demo15 {

}
