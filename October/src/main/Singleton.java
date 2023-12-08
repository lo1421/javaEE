package src.main;

/**
 * 这里是单例模式中的河岸模式
 *
 */
public class Singleton {
private  static Singleton instance = new Singleton();

private Singleton(){}

    public static Singleton getInstance(){
    return instance;
    }

    public static void main(String[] args){
    Singleton instance = Singleton.getInstance();//这就是获取了衣一个唯一的实例的操作
        //此时是饿汉模式
    }
}
