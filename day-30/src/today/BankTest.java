package today;

/**
 * @author : ljg
 * @ClassName: BankTest
 * @Description 使用同步机制将单例模式中的懒汉式改写为线程安全
 * @date : 2022/4/25 12:22
 */
class Bank {
    private Bank() {

    }

    private static Bank instance = null;

    //3.静态的同步方法：同步监视器为当前类本身
//    public static synchronized Bank getInstance() {
    //方式一：效率差
    public static Bank getInstance() {
//        synchronized (Bank.class){
//            if (instance != null) {
//                instance = new Bank();
//            }
//            return instance;
//        }
        //方式二
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance != null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}

public class BankTest {
    public static void main(String[] args) {

    }

}

//使用同步机制将单例模式中的懒汉式改写为线程安全
class Bank2 {
    private Bank2() {
    };

    private static Bank2 instance2 = null;

    public static Bank2 getInstance2() {
        if (instance2 == null) {
            synchronized (Bank2.class) {
                if (instance2 != null) {
                    instance2 = new Bank2();
                }
            }
        }
        return instance2;
    }
}
//饿汉式
