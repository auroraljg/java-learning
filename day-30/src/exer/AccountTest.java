package exer;

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
class Account extends Thread {
    @Override
    public void run() {

    }
}
class Customer extends Account {


}
public class AccountTest {

}
