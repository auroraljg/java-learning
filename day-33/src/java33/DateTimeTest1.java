package java33;

import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author : ljg
 * @ClassName: DateTimeTest1
 * @Description
 *
 * @date : 2022/5/5 17:06
 */
public class DateTimeTest1 {
    /*
     * Description: Calendar:一个抽象基类，主用用于完成日期字段之间相互操作的功能。
     *                  1.
     *                  2.
     *                  3.
     *
     * @param: []
     * @return: void
     * @author: ljg
     * @date: 2022/5/8 20:25
     */
    @Test
    public void CalendarTest() {
        //1.实例化
        //使用Calendar.getInstance()方法
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getClass());//class java.util.GregorianCalendar
        //调用它的子类GregorianCalendar的构造器。

        //2.常用方法
        //get()
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);//8
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));//128
        //set()，可变的
        calendar.set(Calendar.DAY_OF_MONTH,15);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);//15
        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);//12
        //getTime():日历类->Date类
        Date date = calendar.getTime();
        System.out.println(date);//Thu May 12 21:12:54 CST 2022
        //setTime():Date类->日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);//8



    }
    /*
     * Description:java.text.SimpleDateFormat类
     *      1.操作：
     *          格式化：日期->字符串
     *          解析：字符串->日期
     *      2.
     * @param: []
     * @return: void
     * @author: ljg
     * @date: 2022/5/5 17:06
     */
    @Test
    public void SimpleDateFormatTest() throws ParseException {
        //实例化SimpleDateFormat对象
        SimpleDateFormat sdf = new SimpleDateFormat();
        //格式化：
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);//2022/5/8 下午7:19
        System.out.println(format);

        //解析：默认格式
        String s = "2022/5/8 下午7:25";
        System.out.println(s);
        Date date1 = sdf.parse(s);//Unparseable date: "2022-05-08"
        System.out.println(date1);

        //格式化
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1 = sdf1.format(date);
        System.out.println(format1);//2022-05-08 07:26:29
        //解析：要求字符串必须是符合SimpleDateFormat识别的格式(通过构造器格式识别)
        Date date2 = sdf1.parse("2025-05-08 07:26:29");
        System.out.println(date2);

    }
    /*
     练习一:字符串“2025-05-08”转换成date
     */
    @Test
    public void testExer() throws ParseException {
        String birth = "2025-05-08";

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf2.parse(birth);

        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);

    }
    /**/
}

