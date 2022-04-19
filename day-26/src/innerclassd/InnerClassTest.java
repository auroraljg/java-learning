package innerclassd;

/**
 * @author : ljg
 * @ClassName: InnerClassTest
 * @Description 类的内部成员五：内部类
 *                  1.java允许将一个类A声明在另一个类B中，则类A为内部类
 *                  2.成员内部类：
 *                      2.1作为外部类的成员
 *                          2.1.1调用外部类的结构
 *                          2.1.2可以用static修饰
 *                          2.1.3可以被四种权限修饰符修饰
 *                      2.2作为一个类：
 *                          2.2.1类内可以定义属性，方法，构造器
 *                          2.2.2可以被final修饰，表示此类不能被继承
 *                          2.2.3可以被abstract修饰，不能被实例化
 *                  3.关注一下方法：
 *                      3.1如何实例化成员内部类的对象
 *                      3.2成员内部类中调用外部类的结构
 *                      3.3局部内部类的使用
 * @date : 2022/4/19 17:13
 */
public class InnerClassTest {
    public static void main(String[] args) {
        //创建Dog实例：静态的成员内部类
        Person.Dog dog = new Person.Dog();
        dog.sing();
        //创建Bird实例：非静态的成员内部类
        Person p = new Person();  //先实例化外部类的对象
        Person.Bird bird = p.new Bird();
        bird.sing();
        bird.display("xiaohuang");

    }
}

class Person {
    String name = "xiaoMing";
    int age;

    public void eat() {
        System.out.println("我要吃饭");
    }

    //静态成员内部类
    static class Dog {
        String name ;
        int age;


        public Dog() {
        }

        public Dog(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void sing() {
            System.out.println("我是一只狗");
//            eat();
        }

    }
    //非静态成员内部类
    class Bird {
        String name = "dujuan";

        public void sing() {
            System.out.println("我是一只鸟");
            Person.this.eat(); //调用外部类的非静态属性
            eat();  //省略了Person.this.eat();
        }

        public void display(String name) {
            System.out.println(name);  //方法的形参
            System.out.println(this.name);  //内部类的属性
            System.out.println(Person.this.name);  //外部类的属性
        }

    }
}