package learn;

/**
 * @author : ljg
 * @ClassName: BlockTest
 * @Description 类的成员之四：代码块
 *              1.作用：用来初始化类，对象
 *              2.如果有修饰，只能是static
 *              3.静态代码块：
 *                      3.1内部可有输出语句
 *                      3.2随着类的加载而执行，且只执行一次
 *                      3.3作用：初始化类的信息
 *                      3.4类中多个静态代码块，按申明顺序执行
 *                      3.5静态代码块顺序优于非静态代码块
 *                      3.6只能调用静态属性，静态方法，不能调用非静态结构
 *              4.非静态代码块：
 *                      4.1内部可有输出语句
 *                      4.2随着类的创建而执行
 *                      4.3每创建一次对象，即可执行一次
 *                      4.4作用：可以在创建对象是，对对象的属性进行初始化
 *              对属性赋值的位置：
 *              默认初始化、显示初始化、构造器初始化、创建对象后，通过对象.属性或对象.方法赋值、代码块赋值
 * @date : 2022/4/16 11:50
 */
public class BlockTest {
    public static void main(String[] args) {

        String desc = Person.desc; //静态属性
        System.out.println(desc);

        Person p1 = new Person();
        Person p2 = new Person();
    }
}
class Person{
    //属性
    String name;
    int age;
    static String desc = "我是一个人";

    //构造器
    public Person() {
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //代码块
    {
        System.out.println("hello,block!");
    }
    static {
        desc = "我是爱学习的人！";
        System.out.println("hello,static block-2!");
        info();
//        eat();
//        age = 29;
    }
    static {
        desc = "我是爱学习的人！";
        System.out.println("hello,static block-1!");
    }

    //方法
    public void eat(){
        System.out.println("我要吃饭");
    }
    public static void info(){
        System.out.println("我很快乐！");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}