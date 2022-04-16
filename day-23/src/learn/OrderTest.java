package learn;

/**
 * @author : ljg
 * @ClassName: OrderTest
 * @Description 对属性赋值的位置：
 *              1.默认初始化、
 *              2.显示初始化、/5.代码块赋值
 *              3.构造器初始化、
 *              4.创建对象后，通过对象.属性或对象.方法赋值、
 *              顺序：1>2-5>3>4
 * @date : 2022/4/16 20:29
 */
public class OrderTest {
    public static void main(String[] args) {
        Order order = new Order();
        System.out.println(order.orderId);  //4
    }
}
class Order{

    int orderId = 3;
    {
        orderId = 4;
    }
}