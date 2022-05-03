package java32;

/**
 * @author : ljg
 * @ClassName: Bank
 * @Description 使用同步机制将单例模式懒人改为线程安全的
 * @date : 2022/5/3 10:18
 */
class Bank {
    private Bank() {

    }

    private static Bank instance = null;

    public static Bank getInstance() {
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
//饿汉式
class Bank1 {
    private Bank1() {
    }

    private static Bank1 instance1 = null;

    static {
        instance1 = new Bank1();
    }

    public static Bank1 getInstance1() {
        return instance1;
    }
}
