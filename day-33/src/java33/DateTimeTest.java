package java33;

import org.testng.annotations.Test;

import java.util.Date;

/**
 * @author : ljg
 * @ClassName: DateTimeTest
 * @Description TODO
 * @date : 2022/5/4 11:14
 */
public class DateTimeTest {


    //. java.util.Date类
    //表示特定的瞬间，精确到毫秒
    // 构造器：
    // Date()：使用无参构造器创建的对象可以获取本地当前时间。
    // Date(long date)
    // 常用方法
    // getTime():返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象
    //表示的毫秒数。
    // toString():把此 Date 对象转换为以下形式的 String： dow mon dd hh:mm:ss zzz yyyy
    // 其中： dow 是一周中的某一天 (Sun, Mon, Tue,Wed, Thu, Fri, Sat)，zzz是时间标准。
    @Test
    public void test2() {
        Date date1 = new Date();
        System.out.println(date1.toString());//Wed May 04 11:23:29 CST 2022
        System.out.println(date1.getTime());//1651634939820

        Date date2 = new Date(date1.getTime());
        System.out.println(date2);//Wed May 04 11:28:59 CST 2022
        System.out.println(date2.getTime());//1651634939820

        //创建java.sql.Date对象
        java.sql.Date date = new java.sql.Date(1651634939820l);
        System.out.println(date);//2022-05-04

        //将java.util.Date类转换为java.sql.Date对象
        Date date3 = new Date();
        java.sql.Date date4 = new java.sql.Date(date3.getTime());
        System.out.println(date4);//2022-05-04
    }

    //System类提供的public static long currentTimeMillis()用来返回当前时
    //间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。,成为时间戳
    @Test
    public void test1() {
        long time = System.currentTimeMillis();
        System.out.println(time);//
    }
}
