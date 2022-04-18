package java25;

/**
 * @author : ljg
 * @ClassName: InterfaceTest
 * @Description 接口的使用：interface
 *                  1.java中类和接口是并列结构
 *                  2.如何定义接口中的成员：
 *                      2.1 JDK7以前，只能定义全局常量和抽象方法
 *                          全局常量： public static final,书写时可省略
 *                          抽象方法：public abstract
 *                      2.2 JDK8之后：还可以定义静态方法、默认方法
 *                  3.接口中不能定义构造器，即不能接口实例化
 *                  4.开发中，接口通过类去实现(implements)的方式来使用
 *                    如果实现类覆盖了接口中所有抽象方法，则该类可以实例化，否则仍为一个抽象类
 *                  6.java类可以实现多个接口  --->弥补了Java单继承的局限性
 *                    格式： class Aa extends Bb implements Cc,Dd,Ee{ }
 *                  7.接口与接口之间可以继承，而且可以多继承
 *
 *                  8.接口的具体使用，体现多态性
 *                  9.接口的本质是契约，标准，规范
 * @date : 2022/4/18 9:22
 */
public class InterfaceTest {
    public static void main(String[] args) {
        //全局常量直接调用
        System.out.println(Flyable.MAX_SPEED);
        System.out.println(Flyable.MAN_SPEED);

        Plane plane = new Plane();
        plane.fly();
        plane.stop();

        Kite kite = new Kite() {   // 仍为抽象类
            @Override
            public void stop() {
                System.out.println("靠风停止");
            }
        };
        kite.fly();
    }
}

interface Attackable{

    void attack();
}

interface Flyable{
    //全局常量
    public static final int MAX_SPEED = 7900;
    int MAN_SPEED = 5;  //省略了public static final

    //抽象方法
    public abstract void fly();
    void stop();  //省略了public abstract

    /*public Flyable(){     //构造器不能定义

    }*/
}

class Plane implements Flyable{

    @Override
    public void fly() {
        System.out.println("通过引擎起飞");
    }

    @Override
    public void stop() {
        System.out.println("驾驶员停止");
    }
}
//抽象类
abstract class Kite implements Flyable{

    @Override
    public void fly() {
        System.out.println("通过风起飞");
    }

}

class Bullet implements Flyable,Attackable{

    @Override
    public void attack() {

    }

    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }
}