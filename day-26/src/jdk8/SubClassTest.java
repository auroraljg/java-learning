package jdk8;

/**
 * @author : ljg
 * @ClassName: SubClassTest
 * @Description TODO
 * @date : 2022/4/19 16:12
 */
public class SubClassTest {
    public static void main(String[] args) {
        SubClass s = new SubClass();

        //1.接口中的静态方法只能通过接口来调用,不能通过实现类的对象来调用
//        s.method1();
        CompareA.method1();

        //2.通过实现类的对象来调用接口的默认方法
        //若实现类重写了默认方法，则调用重写方法
        s.method2();
        //3.接口与父类的方法同名同参数，则在没有重写此方法的情况下默认调用父类的方法-->类优先原则
        //4.如果实现类实现了多个接口，而多个接口定义了同名同参数的默认方法，则需要在实现类重写方法-->接口冲突
        s.method3();


    }
}

class SubClass extends SuperClass implements CompareA,CompareB {

    @Override
    public void method2() {
        System.out.println("CompareA:上海我不去了");
    }

    @Override
    public void method3() {
        System.out.println("CompareA:深圳");
    }

    //5.如何在子类(实现类)的方法中调用父类，接口中被重写的方法
    public void myMethod() {
        method3();  //调用自己定义的重写的方法
        super.method3();  //调用父类所声明的方法
        //调用接口中的默认方法
        CompareA.super.method3();
        CompareB.super.method3();
    }
}