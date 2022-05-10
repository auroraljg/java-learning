package java34;

import org.testng.annotations.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @author : ljg
 * @ClassName: Jdk8DateTimeTest
 * @Description TODO
 * @date : 2022/5/9 10:38
 */
public class Jdk8DateTimeTest {
    /*
     * Description:
     * java.time.format.DateTimeFormatter 类：该类提供了三种格式化方法：
 预定义的标准格式。如：
ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
 本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)
 自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)

     * @param: []
     * @return: void
     * @author: ljg
     * @date: 2022/5/9 16:59
     */
    @Test
    public void test3() {
//         预定义的标准格式。如：
        DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = isoLocalDateTime.format(localDateTime);
        System.out.println(localDateTime);//2022-05-09T17:05:34.301418700
        System.out.println(str1);//2022-05-09T17:05:34.3014187

        //解析：字符串->日期
        TemporalAccessor parse = isoLocalDateTime.parse("2022-05-09T17:05:34.3014187");
        System.out.println(parse);//{},ISO resolved to 2022-05-09T17:05:34.301418700

//         本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withZone(ZoneOffset.ofHours(8));
        //格式化
        String str2 = dateTimeFormatter.format(localDateTime);
        System.out.println(str2);//2022年5月9日 +08:00 下午5:30:07

//      重点   自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str3 = dateTimeFormatter1.format(LocalDateTime.now());
        System.out.println(str3);//2022-05-09 05:33:52

        //解析
        TemporalAccessor parse1 = dateTimeFormatter1.parse("2022-05-09 05:33:52");
        System.out.println(parse1);//{NanoOfSecond=0, MinuteOfHour=33, MicroOfSecond=0, SecondOfMinute=52, HourOfAmPm=5, MilliOfSecond=0},ISO resolved to 2022-05-09


    }
    /*
     * Description:
     * 瞬时：Instant
     *      1.类似于java.util.Date类
     * @param:
     * @return:
     * @author: ljg
     * @date: 2022/5/9 16:32
     */

    @Test
    public void test2() {
        //now()：静态方法，返回默认UTC时区的Instant类的对象
        Instant instant = Instant.now();
        System.out.println(instant);//2022-05-09T08:47:05.081823600Z

        //结合即时的偏移来创建一个 OffsetDateTime,添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2022-05-09T16:50:53.819494600+08:00


        //toEpochMilli() 返回1970-01-01 00:00:00到当前时间的毫秒数，即为时间戳
        Long milli = instant.toEpochMilli();
        System.out.println(milli);//1652086549561

        //ofEpochMilli(long epochMilli) 静态方法，返回在1970-01-01 00:00:00基础上加上指定毫秒数之后的Instant类的对象
        Instant instant1 = Instant.ofEpochMilli(1652086549561l);
        System.out.println(instant1);//2022-05-09T08:55:49.561Z

    }

    /*
     * Description: LocalDate、LocalTime、LocalDateTime 类
     * @param: []
     * @return: void
     * @author: ljg
     * @date: 2022/5/9 10:45
     */
    @Test
    public void test1() {

        //now()，静态方法，获取当前时间日期
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);//2022-05-09
        System.out.println(localTime);//10:49:18.520406600
        System.out.println(localDateTime);//2022-05-09T10:49:18.520406600

        //of():
        LocalDateTime localDateTime1 = localDateTime.of(2022, 5, 9, 10, 52, 23);
        System.out.println(localDateTime1);//2022-05-09T10:52:23

        //getXxx():获取相关属性
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        //withXxx(),修改相关属性，不可变性
        LocalDate localDate1 = localDate.withDayOfMonth(19);
        System.out.println(localDate);//2022-05-09
        System.out.println(localDate1);//2022-05-19

        //plusXxx()、minusXxx()
        LocalDate localDate2 = localDate.plusDays(5);
        System.out.println(localDate);
        System.out.println(localDate2);//2022-05-14

        LocalDate localDate3 = localDate.minusDays(5);
        System.out.println(localDate);
        System.out.println(localDate3);//2022-05-04


    }

    @Test
    public void test() {
//        Date date = new Date(2022 - 1900,5 - 1,9);//含有偏移量
//        System.out.println(date);

    }
}
