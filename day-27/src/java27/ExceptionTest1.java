package java27;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;

/**
 * @author : ljg
 * @ClassName: ExceptionTest1
 * @Description 异常处理的抓抛模型
 *                  1."抛":执行过程中如出现异常，会生成一个异常类对象，
 *                              该异常对象将被提交给Java运行时系统
 *                      关于异常的产生;系统自动生成的异常对象
 *                                    手动的生成一个异常对象，并抛出(throw)
 *                  2."抓"：处理异常
 *                      2.1try-catch-finally语句
 *                      2.2 throws + 异常类型
 *try{
 *      ...... //可能产生异常的代码
 * }
 * catch( ExceptionName1 e ){
 *      ...... //当产生ExceptionName1型异常时的处置措施
 * }
 * catch( ExceptionName2 e ){
 *      ...... //当产生ExceptionName2型异常时的处置措施
 * }
 * [ finally{
 *      ...... //无论是否发生异常，都无条件执行的语句
 * } ]
 * 说明：
 *        1.finally可选
 *        2.捕获异常的第一步是用try{…}语句块选定捕获异常的范围，将可能出现
 *          异常的代码放在try语句块中。
 *        3.在catch语句块中是对异常对象进行处理的代码。每个try语句块可以伴随
 *          一个或多个catch语句，用于处理可能产生的不同类型的异常对象。
 *          3.1 catch中的异常类型满足子父类关系，则子类必须在父类之上
 *          3.2 try语句中只处理出现的第一个异常
 *          3.3 常用的异常处理方式  System.out.println(e.getMessage());
 *                                e.printStackTrace();
 *          3.4 try语句声明的变量，出了try结构不能在被调用。可以在try语句前声明并初始化
 *        4.捕获异常的最后一步是通过finally语句为异常处理提供一个统一的出口，
 *          使得在控制流转到程序的其它部分以前，能够对程序的状态作统一的管理。
 *
 *体会：使用try-catch-finally语句处理编译时异常，使得程序编译时不再报错，然而运行时仍可能报错
 *      即将一个编译时异常延迟到运行时出现
 * @date : 2022/4/21 9:24
 */

public class ExceptionTest1 {
    @Test
    public void test2() {
        try {
            File file = new File("hello.txt");
            FileInputStream fis = new FileInputStream(file);

            int date = fis.read();
            while (date != -1) {
                System.out.println((char)date);
                date = fis.read();
            }
            fis.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test4() {
        String str = "123";
        str = "abc";
        try {
            int num = Integer.parseInt(str);
            System.out.println("hello-----1");
        }catch (ClassCastException e) {
            System.out.println("空指针格式异常,请等待......");
        }catch (NumberFormatException e) {
//            System.out.println("数值格式异常,请等待......");
            //1.
//            System.out.println(e.getMessage());  //For input string: "abc"
            //2.
            e.printStackTrace(); //For input string: "abc"
        }catch (Exception e) {
            System.out.println("异常,请等待......");
        }
        System.out.println("hello-----2");
    }
}
