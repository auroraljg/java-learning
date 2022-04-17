package java24;

/**
 * @author : ljg
 * @ClassName: FinalTest
 * @Description final: 最终的，可修饰结构：类，方法，变量
 *              1.修饰类：此类不能被其他类继承
 *                          eg：String类，System类
 *              2.修饰方法：表明此方法不能被重写
 *                          eg：Object类中的getClass()；
 *              3.修饰变量：此时的“变量”被称为一个常量
 *                      3.1修饰属性：
 *                                  此时可赋值位置为：显示初始化、代码块、构造器
 *                      3.2修饰局部变量：
 *                                  特别使用final修饰形参时，表明此形参为一个常量。
 *                                  调用该方法时，给形参赋予一个实参，之后只能使用，不能重新赋值
 *              4.static final：用来修饰属性，全局常量
 *                              用来修饰方法，方法不能重写
 * @date : 2022/4/17 9:06
 */
public class FinalTest {
    final int WIDTH = 10; //显式赋值
    final int LEFT;  //代码块赋值
    final int RIGHT; //构造器赋值

    {
        LEFT = 20;
    }
    public FinalTest(){
        RIGHT = 30;
    }
    public FinalTest(int n){  //构造器是独立的，要保证给final变量构造器赋值每个构造器都有
//        this();
//        RIGHT = 30;
        RIGHT = n;
    }

    public void doWidth(){
 //       width = 20;
    }
    public void show (){
        final int NUM =12;
//        NUM =22;
    }
    public void show (final int num){
//        num++;
        System.out.println(num);

    }

    public static void main(String[] args) {
        FinalTest test1 = new FinalTest();
        test1.show(20);
    }

}

//final 类，不可被继承
final class Final{

}
class Person{
    public final void show(){

    }
}
class son extends Person{
   /* public void show(){   //不能被重写

    }*/
}

//class B extends Final{   //编译出错
//
//}

/*
class C extends System{

}*/
