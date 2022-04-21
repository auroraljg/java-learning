package java27;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Scanner;

/**
 * @author : ljg
 * @ClassName: ExceptionTest
 * @Description
 *          异常：Exception
 *              1.编译时异常（checked）
 *                  1.1
 *              2.运行时异常(unchecked)
 *                  2.1
 * @date : 2022/4/20 12:11
 */
public class ExceptionTest {

//        @Test
//    public void test7() {
//        File file = new File("hello.txt");
//        FileInputStream fis = new FileInputStream(file);
//
//        int date = fis.read();
//        while (date != -1) {
//            System.out.println((char)date);
//            date = fis.read();
//        }
//        fis.close();
//    }est {
    ///****************以下为编译时异常*********************************/
//

    ///****************以下为运行时异常*********************************/
    //6.ArithmeticException
    @Test
    public void test6() {
        int a = 5;
        int b = 0;
        System.out.println(a / b);
    }

    //idea不允许在单元测试中从键盘输入元素
    //5.InputMismatchException
    @Test
    public void test5() {
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        System.out.println(score);
    }

    //4.NumberFormatException
    @Test
    public void test4() {
        String str = "123";
        str = "abc";
        int num = Integer.parseInt(str);
    }


    //3.ClassCastException
    @Test
    public void test3() {

        Object obj = new Date();
        String str = (String) obj;
    }



    //2.IndexOutOfBoundsException
    @Test
    public void test2() {
        //2.1ArrayIndexOutOfBoundsException
//        int[] arr = new int[10];
//        System.out.println(arr[10]);

        //2.2 StringIndexOutOfBoundsException
//        String str = "abc";
//        System.out.println(str.charAt(3));
    }

    // 1.NullPointerException
    @Test
    public void test1() {
        //1.1
//        int[] arr = null;
//        System.out.println(arr[3]);

        //1.2
//        String str = "abc";
//        str = null;
//        System.out.println(str.charAt(0));
    }

}
