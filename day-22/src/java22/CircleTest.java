package java22;

/**
 * @author : ljg
 * @ClassName: CircleTest
 * @Description TODO
 * @date : 2022/4/15 20:18
 */
public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle();
        Circle c3 = new Circle();

        System.out.println("c1的id:"+c1.getId());
        System.out.println("c2的id:"+c2.getId());
        System.out.println("c3的id:"+c3.getId());

        System.out.println("创建的圆的个数:"+Circle.getTotal());
    }

}
class Circle{
    private double radius;
    private  int id;

    public Circle(){
        id = init++;
        total++;
    }
    public Circle(double radius, int id) {
        this();
        this.radius = radius;
    }

    private static int total = 0;  //记录创建的圆的个数
    private static int init=1001;  //static声明的属性被所有对象所共享

    public double findArea(){
        return radius * radius * Math.PI;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getTotal() {
        return total;
    }

    public static void setTotal(int total) {
        Circle.total = total;
    }

    public static int getInit() {
        return init;
    }

    public static void setInit(int init) {
        Circle.init = init;
    }
}
