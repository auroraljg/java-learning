package java32;

import org.testng.annotations.Test;

/**
 * @author : ljg
 * @ClassName: StringMethodTest
 * @Description
 *  int length()：返回字符串的长度： return value.length
 *  char charAt(int index)： 返回某索引处的字符return value[index]
 *  boolean isEmpty()：判断是否是空字符串：return value.length == 0
 *  String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写
 *  String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写
 *  String trim()：返回字符串的副本，忽略前导空白和尾部空白
 *  boolean equals(Object obj)：比较字符串的内容是否相同
 *  boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大
 * 小写
 *  String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
 *  int compareTo(String anotherString)：比较两个字符串的大小
 *  String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从
 * beginIndex开始截取到最后的一个子字符串。
 *  String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字
 * 符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
 * @date : 2022/5/3 16:59
 */
public class StringMethodTest {
    @Test
    public void test2(){
        String s1 = "HelloJava";
        String s2 = "hellojava";
        System.out.println(s1.equals(s2));//false
        System.out.println(s1.equalsIgnoreCase(s2));//true

        String s3 = "abc";
        String s4 = s3.concat("def");
        System.out.println(s3);//abc
        System.out.println(s4);//abcdef

        String s5 = "abc";
        String s6 = new String("abe");
        System.out.println(s5.compareTo(s6));//-2

        String s7 = "北京尚硅谷教育";
        String s8 = s7.substring(2);
        String s9 = s7.substring(2,5);//左闭右开原则
        System.out.println(s7);//北京尚硅谷教育
        System.out.println(s8);//尚硅谷教育
        System.out.println(s9);//尚硅谷 ,

    }

    @Test
    public void test1() {
        String s1 = "HelloJava";
        System.out.println(s1.length());
        System.out.println(s1.charAt(2));
        System.out.println(s1.charAt(5));
//        System.out.println(s1.charAt(9));//StringIndexOutOfBoundsException
        System.out.println(s1.isEmpty());

        String s2 = s1.toLowerCase();
        System.out.println(s1);//HelloJava
        System.out.println(s2);//hellojava

        String s3 = "   he llo java  ";
        String s4 = s3.trim();
        System.out.println("----" + s3 + "----");//----   he llo java  ----
        System.out.println("----" + s4 + "----");//----he llo java----
    }
}
