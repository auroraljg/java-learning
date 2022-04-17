package java24;

/**
 * @author : ljg
 * @ClassName: EmployTest
 * @Description TODO
 * @date : 2022/4/17 16:40
 */
public class EmployTest {
    public static void main(String[] args) {
        //多态,父类的对象指向子类的引用
        Employee e1 = new Manager("haoke", 45, 4500, 2000) ;
        e1.work();
        CommonEmployee commonEmployee1 = new CommonEmployee();

    }
}
