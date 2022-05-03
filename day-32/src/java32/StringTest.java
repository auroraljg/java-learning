package java32;


import org.testng.annotations.Test;

/**
 * @author : ljg
 * @ClassName: StringTest
 * @Description 字符串String
 *                  1.String是一个final类，不可被继承
 *                  2.实现了Serializable接口，表明字符串支持序列化。
 *                    实现了 Comparable接口，可比较大小
 *                  2.字符串是常量，用双引号引起来表示。它们的值在创建之后不能更改。不可变性
 *                      2.1对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value[]
 *                      2.2对现有的字符串进行连接操作，也需要重新指定内存区域赋值
 *                      2.3对现有的字符串进行替换操作，也需要重新指定内存区域赋值
 *
 *                  3.String对象的字符内容是存储在一个字符数组中的。
 *                  4.通过字面量的定义方式给字符串赋值，则此时存储在字符串常量池中(方法区)
 *                  5.字符串常量池不会存储相同内容的字符串
 *                  6.
 * @date : 2022/5/3 10:47
 */
public class StringTest {


    /*
     * Description:常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。
                    只要其中有一个是变量，结果就在堆中
                    如果拼接的结果调用intern()方法，返回值就在常量池中
     * @param:
     * @return:
     * @author: ljg
     * @date: 2022/5/3 16:28
     */
    @Test
    public void test3() {
        String s1 = "javaEE";
        String s2 = "hello";

        String s3 = "javaEEhello";
        String s4 = "javaEE" + "hello";//常量池
        String s5 = s1 + "hello";//堆
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);
        System.out.println(s3 == s7);
        System.out.println(s5 == s6);
        System.out.println(s5 == s7);
        System.out.println(s6 == s7);

        String s8 = s5.intern();//返回值s8中使用的常量池中存在的javaEEhello
        String s9 = "javaEEhello";
        System.out.println(s3 == s8);//true

    }

    /*
     * Description: String的实例化方式
     *                  方式一：通过字面量定义方式
     *                  方式二：通过new+构造器的方式
     * @param: []
     * @return: void
     * @author: ljg
     * @date: 2022/5/3 13:01
     */
    @Test
    public void test2() {
        //存放在常量池，目的是共享
        String s1 = "javaEE";
        String s2 = "javaEE";

        //存放在堆中
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1 == s2);//true
        System.out.println(s3 == s4);//false
        System.out.println(s1 == s3);//false

        System.out.println("**************************");
        Person p1 =new Person("Tom",12);
        Person p2 =new Person("Tom",15);

        System.out.println(p1.name.equals(p2.name));//true,String类的该方法重写，改成了比较值
        System.out.println(p1.name == p2.name);//true，Person类的name是通过字面量定义方式，存储在常量池中，两者地址值一样

        p1.name = "Jerry";
        System.out.println(p2.name);//Tom
        System.out.println(p1.name.equals(p2.name));//false
        System.out.println(p1.name == p2.name);//false
    }

    @Test
    public void test1(){

        String s1 = "abc";//字面量的定义方式
        String s2 = "abc";

        s1 = "hello";


        System.out.println(s1 == s2); //比较s1与s2的地址值

        System.out.println(s1);//hello
        System.out.println(s2);//abc

        System.out.println("**************************");

        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);//abcdef

        String s4 = "abc";
        String s5 = s4.replace('a','m');
        System.out.println(s4);//abc
        System.out.println(s5);//mbc
    }

}
