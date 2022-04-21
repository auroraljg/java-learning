package java27;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author : ljg
 * @ClassName: ExceptionTest2
 * @Description 异常处理机制二：throws + 异常类型
 *                  1."throws + 异常类型"写在方法的声明处，指明此方法执行时，可能会抛出的异常类型。
 *                      一旦该方法执行时，出现异常，则会在异常代码处生成一个异常类的对象，
 *                      此对象会被抛出，后续代码不执行
 *                  2.该方法只是将异常抛给了方法的调用者，并未真正将异常处理掉。
 *                  3.开发时如何选择try-catch-finally或者throws + 异常类型
 *                      3.1如果父类被重写方法没有用throws抛出异常，则子类重写方法也不能用
 *                      3.2执行的方法a中，先后调用了另外几个方法，这几个方法是递进关系执行的。
 *                          建议这几个方法用throws抛出异常，a用try-catch-finally处理
 *                  4.
 * @date : 2022/4/21 11:21
 */
public class ExceptionTest2 {

    public static void main(String[] args) throws IOException {
        method2();
        method3();
    }
    //
    public static void method3() {
        try {
            method2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void method2() throws IOException {
        method1();
    }

    public static void method1() throws FileNotFoundException,IOException {
        File file = new File("hello.txt");
        FileInputStream fis = new FileInputStream(file);

        int date = fis.read();
        while (date != -1) {
            System.out.print((char)date);
            date = fis.read();
        }
        fis.close();
    }
}
