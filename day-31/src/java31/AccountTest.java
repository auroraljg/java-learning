package java31;

/**
 * @author : ljg
 * @ClassName: AccountTest
 * @Description 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打
 * 印账户余额。
 * 问题：该程序是否有安全问题，如果有，如何解决？
 * 【提示】
 * 1，明确哪些代码是多线程运行代码，须写入run()方法
 * 2，明确什么是共享数据。
 * 3，明确多线程运行代码中哪些语句是操作共享数据的。
 * @date : 2022/4/30 10:35
 */
class Account {
    private double balance = 0;

    public Account(double balance) {
        this.balance = balance;
    }

    //存钱
    //同步方法，针对共享数据的操作代码块
//    public synchronized void deposit(double amt) {
    public void deposit(double amt) {
        //同步代码块
        synchronized (this) {
            if (amt > 0) {
                balance += amt;
                //便于出现线程安全问题
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("账户" + Thread.currentThread().getName()+"存钱成功。余额为：" + balance);
            }
        }
    }
}

class Customer extends Thread {
    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i= 0;i < 3;i++) {
            acct.deposit(1000);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        //采用单列模式的方法让两个账号共享同一个数据
        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }
}
