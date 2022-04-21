package java27;

/**
 * @author : ljg
 * @ClassName: InnerClassTest
 * @Description
 *      局部内部类的方法如果调用局部内部类所声明的方法中的变量，则要求此局部变量为final型
 * @date : 2022/4/20 9:44
 */
public class InnerClassTest {

    public void method() {
        int num = 10;

        class AA {

            public void show() {
                //Variable 'num' is accessed from within inner class, needs to be final or effectively final
//                num = 20;
                System.out.println(num);
            }
        }
    }
}
