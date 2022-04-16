package java23;

/**
 * @author : ljg
 * @ClassName: SingletonTest1
 * @Description 单例设计模式实现1-饿汉式
 * @date : 2022/4/16 10:10
 */
public class SingletonTest1 {
    public static void main(String[] args) {
//        Bank bank1 = new Bank();   //类外非法创建
       Bank bank1 = Bank.getInstance();
       Bank bank2 = Bank.getInstance();

       System.out.println(bank1 == bank2); //表示该静态对象是唯一的，地址一样
    }
}

//饿汉式
class Bank{
    //1.私有化类的构造器
    private Bank(){

    }
    //2.内部创建类的对象,
    //4.要求此对象也是声明为静态的
    private  static Bank instance = new Bank();
    //3.提供公共的静态的方法，返回类的对象
    public  static Bank getInstance(){
        return instance;
    }
}
