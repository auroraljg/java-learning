package java32;

import org.testng.annotations.Test;

/**
 * @author : ljg
 * @ClassName: StringMethodTest2
 * @Description
 *  boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
 *  boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
 *  boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的
 * 子字符串是否以指定前缀开始
 *  boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列
 * 时，返回 true
 *  int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
 *  int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出
 * 现处的索引，从指定的索引开始
 *  int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
 *  int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后
 * 一次出现处的索引，从指定的索引开始反向搜索
 * 注：indexOf和lastIndexOf方法如果未找到都是返回-1
 * @date : 2022/5/3 17:24
 */
public class StringMethodTest2 {
    @Test
    public void test1() {

        String s1 = "helloworld";
        boolean b1 = s1.endsWith("rld");
        System.out.println(b1);

        boolean b2 = s1.startsWith("hell");
        System.out.println(b2);

        boolean b3 = s1.startsWith("ll",2);
        System.out.println(b3);

        String s2 = "wo";
        System.out.println(s2.contains("O"));//false,严格需分大小写

        System.out.println(s1.indexOf("l"));//2
        System.out.println(s1.indexOf("p"));//-1
        System.out.println(s1.indexOf("l",3));//3

        System.out.println(s1.lastIndexOf("o"));//6
        System.out.println(s1.lastIndexOf("o",5));//4

    }
}
