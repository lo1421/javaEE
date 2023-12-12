package src.demo;

//定义一个接口
interface  Chef{
    void cook();
}

class Sever{
    public void shangCai(){
        System.out.println("服务员上菜");
    }
}

public class Demo01 {
    public static void main(String[] args) {

        //使用匿名内部类来实现接口
        Chef chef1 = new Chef() {
            @Override
            public void cook() {
                System.out.println("炒蛋炒饭");
            }
        };
        //调用我们使用匿名内部类实现接口实例中的抽象方法
        chef1.cook();


        //使用匿名内部类重写父类方法
        Sever sever = new Sever() {
            @Override
            public void shangCai() {
                System.out.println("服务员上菜->蛋炒饭");
            }
        };
        //调用我们使用匿名内部类重写父类的方法
        sever.shangCai();
    }
}
