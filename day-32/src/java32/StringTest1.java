package java32;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author : ljg
 * @ClassName: StringTest1
 * @Description String与基本数据类型转换
 * @date : 2022/5/3 19:50
 */
public class StringTest1 {
    /*
     * Description:
     *  字节数组  字符串
            String(byte[])：通过使用平台的默认字符集解码指定的 byte 数组，构
                造一个新的 String。
            String(byte[]，int offset，int length) ：用指定的字节数组的一部分，
                即从数组起始位置offset开始取length个字节构造一个字符串对象。
        字符串  字节数组
            public byte[] getBytes() ：使用平台的默认字符集将此 String 编码为
                byte 序列，并将结果存储到一个新的 byte 数组中。
            public byte[] getBytes(String charsetName) ：使用指定的字符集将
                此 String 编码到 byte 序列，并将结果存储到新的 byte 数组。
     * @param: []
     * @return: void
     * @author: ljg
     * @date: 2022/5/3 20:12
     */
    @Test
    public void test3() {
        String s1 = "abc123中国";
        byte[] bytes = s1.getBytes();//使用默认的字符集，UTF-8
        System.out.println(Arrays.toString(bytes));

        String str2 = new String(bytes);//使用默认的字符集，进行解码。
        System.out.println(str2);

    }

    /*
     * Description:
     *  字符数组  字符串
            String 类的构造器：String(char[]) 和 String(char[]，int offset，int
                length) 分别用字符数组中的全部字符和部分字符创建字符串对象。
        字符串  字符数组
            public char[] toCharArray()：将字符串中的全部字符存放在一个字符数组
                中的方法。
            public void getChars(int srcBegin, int srcEnd, char[] dst,
                int dstBegin)：提供了将指定索引范围内的字符串存放到数组中的方法。
     * @param: []
     * @return: void
     * @author: ljg
     * @date: 2022/5/3 19:59
     */
    @Test
    public void test2() {
        String s1 = "abc123";
        char[] charArray = s1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i]);//abc123
        }

        char[] arr = new char[]{'s', 'd', '2', 's', 'r'};
        String s2 = new String(arr);
        System.out.println(s2);//sd2sr
    }

    /*
     * Description:
     * 字符串  基本数据类型、包装类
            Integer包装类的public static int parseInt(String s)：可以将由“数字”字
                符组成的字符串转换为整型。
            类似地,使用java.lang包中的Byte、Short、Long、Float、Double类调相应
                的类方法可以将由“数字”字符组成的字符串，转化为相应的基本数据类型。
       基本数据类型、包装类  字符串
            调用String类的public String valueOf(int n)可将int型转换为字符串
            相应的valueOf(byte b)、valueOf(long l)、valueOf(float f)、valueOf(double 
                d)、valueOf(boolean b)可由参数的相应类型到字符串的转换
     * @param: []
     * @return: void
     * @author: ljg
     * @date: 2022/5/3 19:54
     */
    @Test
    public void test1() {
        String s1 = "123";
        int num = Integer.parseInt(s1);
        System.out.println(num);//123

        String s2 = String.valueOf(num);//"123"
        System.out.println(s2);//"123"

        String s3 = num + "";
        System.out.println(s1 == s3);//false
    }
}
