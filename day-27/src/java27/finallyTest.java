package java27;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author : ljg
 * @ClassName: finallyTest
 * @Description try-catch-finally语句中finally的使用
 *                  1.finally可选
 *                  2.finally中声明的是一定被执行的代码，即使catch又出现异常，
 *                      或者try有返回语句或者catch没执行
 *                  3.像数据库连接、输入输出流、网络编程Socket等资源，JVM不能自动回收
 *                  4.try-catch-finally可以相互嵌套
 *                  5.仅针对编译时异常
 * @date : 2022/4/21 10:12
 */
public class finallyTest {

    @Test
    public void test3() {
        FileInputStream fis = null;
        try {
            File file = new File("hello.txt");
            fis = new FileInputStream(file);

            int date = fis.read();
            while (date != -1) {
                System.out.print((char)date);
                date = fis.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() {
        int num = method();
        System.out.println(num);
    }
    public int method() {
        try {
            int[] arr = new int[10];
            System.out.println(arr[10]);
            return 1;
        }catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return 2;
        }finally {
            System.out.println("我能被执行");

        }
    }

    @Test
    public void test1() {
        try {
            int a = 10;
            int b = 0;
            System.out.println(a / 5);
        }catch (ArithmeticException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("我真牛");
        }

    }
}
