package java26;

/**
 * @author : ljg
 * @ClassName: InterfaceTest
 * @Description 定义一个接口用来实现两个对象的比较。
 * interface CompareObject{
 * public int compareTo(Object o); //若返回值是 0 , 代表相等; 若为正数，代表当
 * 前对象大；负数代表当前对象小
 * }
 * 定义一个Circle类，声明redius属性，提供getter和setter方法
 * 定义一个ComparableCircle类，继承Circle类并且实现CompareObject接口。在
 * ComparableCircle类中给出接口中方法compareTo的实现体，用来比较两个圆的半
 * 径大小。
 * 定义一个测试类InterfaceTest，创建两个ComparableCircle对象，调用compareTo
 * 方法比较两个类的半径大小。
 * @date : 2022/4/19 10:53
 */
public class InterfaceTest {
    public static void main(String[] args) {
        ComparableCircle c1 = new ComparableCircle(3.5);
        ComparableCircle c2 = new ComparableCircle(3.6);

        int compareVal = c1.compareTo(c2);
        if (compareVal > 0) {
            System.out.println("c1大");
        }else if (compareVal < 0) {
            System.out.println("c2大");
        }else {
            System.out.println("一样大");
        }

    }
}
interface CompareObject {
    //若返回值是 0 , 代表相等; 若为正数，代表当前对象大；负数代表当前对象小
    public int compareTo(Object o);
}
class Circle {
    //包装类
    private Double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    public Circle(Double radius) {
        this.radius = radius;
    }
}
class ComparableCircle extends Circle implements CompareObject {
    public ComparableCircle() {
    }

    public ComparableCircle(Double radius) {
        super(radius);
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        }
        if (o instanceof ComparableCircle) {
            ComparableCircle c = (ComparableCircle) o;
            if (this.getRadius() > c.getRadius()) {
                return 1;
            } else if (this.getRadius() < c.getRadius()) {
                return -1;
            } else {
                return 0;
            }
//            //当属性radious声明为包装类时，可以调用该方法
//            return this.getRadius().compareTo(c.getRadius());
        } else {
//            return 0;
            //异常
            throw new RuntimeException("传入的数据类型不匹配！");
        }
    }
}