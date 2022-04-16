package java23;

/**
 * @author : ljg
 * @ClassName: SingletonTest2
 * @Description 单例设计模式实现2-懒汉式
 * @date : 2022/4/16 10:20
 */
public class SingletonTest2 {
    public static void main(String[] args) {
        Order order1 = Order.getInstance();//调用类的静态方法来唯一创建一个类的对象
        Order order2 = Order.getInstance();

        System.out.println(order1 == order2); //表示该静态对象是唯一的，地址一样
    }
}
//懒汉式
class Order{
    //1.私有化类的构造器
    private Order(){

    }
    //2.声明当前类的对象，没有初始化
    //4.此对象也必须声明为静态的
    private static Order instance = null;
    //3.声明public，static的返回当前类对象的方法
    public static Order getInstance(){
        if(instance == null){
            instance = new Order();
        }
        return instance;
    }
}