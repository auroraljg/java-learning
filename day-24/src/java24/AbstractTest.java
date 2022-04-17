package java24;/**
 * @ClassName: AbstractTest
 * @Description 关键字abstract的使用
 *              1.抽象的，可用于修饰类和方法
 *              2.修饰类：
 *                  2.1抽象类不能实例化
 *                  2.2抽象类一定有构造器，便于子类实例化使用。开发时，一般都会提供抽象类的构造器
 *              3.修饰方法：
 *                  3.1抽象方法只有方法的说明，没有方法体
 *                  3.2包含抽象方法的类一定是抽象类，反之不成立
 *                  3.3非抽象子类必须重写父类中所有抽象方法！
 *                     若没有全部重写父类中所有抽象方法，则为抽象子类，用abstract修饰
 * @author : ljg
 * @date : 2022/4/17 11:36
 */
public class AbstractTest {
    public static void main(String[] args) {

//        //抽象类不能被实例化
//        Person1 p1 =new Person1();
//        p1.eat();

    }
}
abstract class Person1{
    String name;
    int age;

    public Person1() {
    }

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //抽象方法
    public abstract void eat();

    public void walk(){
        System.out.println("人会走路");
    }
}
class Student extends Person1{
    public Student() {
    }

    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("学生要吃有营养的食物");
    }

    @Override
    public void walk() {
        System.out.println("学生要多锻炼，走路");
    }
}