package exer;

/**
 * @author : ljg
 * @ClassName: AccountTest
 * @Description TODO
 * @date : 2022/4/15 20:51
 */
public class AccountTest {
    public static void main(String[] args) {
        Account acct1 = new Account();
        Account acct2 = new Account("666666", 3000);

        Account.setInterestRate(0.012);
        Account.setMinMoney(100);

        System.out.println(acct1);
        System.out.println(acct2);

        System.out.println(acct1.getInterestRate());
        System.out.println(acct2.getMinMoney());
    }
}
