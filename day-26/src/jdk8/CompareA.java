package jdk8;

/**
 * @author : ljg
 * @ClassName: CompareA
 * @Description Java 8中，你可以为接口添加静态方法和默认方法。
 * 从技术角度来说，这是完全合法的，只是它看起来违反了接口作为一个抽象定义的理念。
 * 静态方法：使用 static 关键字修饰。可以通过接口直接调用静态方法，并执行
 *          其方法体。我们经常在相互一起使用的类中使用静态方法。你可以在标准库中
 *          找到像Collection/Collections或者Path/Paths这样成对的接口和类。
 * 默认方法：默认方法使用 default 关键字修饰。可以通过实现类对象来调用。
 *          我们在已有的接口中提供新方法的同时，还保持了与旧版本代码的兼容性。
 * 比如：java 8 API中对Collection、List、Comparator等接口提供了丰富的默认
 * 方法。
 * @date : 2022/4/19 16:03
 */
public interface CompareA {
    //静态方法
    public static void method1() {
        System.out.println("CompareA:北京");
    }

    //默认方法
    public default void method2() {
        System.out.println("CompareA:上海");
    }

    default void method3() {   //省略public
        System.out.println("CompareA:上海2");
    }

}
