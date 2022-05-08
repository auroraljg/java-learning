package java33;

import org.testng.annotations.Test;

/**
 * @author : ljg
 * @ClassName: StringBufferBuilderTest
 * @Description String类、StringBuffer类、StringBuilder类
 *
 * @date : 2022/5/4 10:13
 */
public class StringBufferBuilderTest {
    @Test
    public void test4() {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());//4
        System.out.println(sb);//null,字符串
        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);//NullPointerException
    }
    /*
     * Description: 三者的效率测试:从高到低
     *StringBuilder StringBuffer String
     * @param: []
     * @return: void
     * @author: ljg
     * @date: 2022/5/4 11:11
     */
    @Test
    public void test3 (){
        //初始设置
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        //开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));

    }

    /*
     * Description:
     * StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
        StringBuffer delete(int start,int end)：删除指定位置的内容
        StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
        StringBuffer insert(int offset, xxx)：在指定位置插入xxx
        StringBuffer reverse() ：把当前字符序列逆转
        *
        * public int indexOf(String str)
            public String substring(int start,int end) 截取指定位置的元素，返回String型
            public int length()
            public char charAt(int n )
            public void setCharAt(int n ,char ch
     * @param: []
     * @return: void
     * @author: ljg
     * @date: 2022/5/4 10:46
     */
    @Test
    public void test2() {
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.append(1);
        sb1.append('1');
        System.out.println(sb1);//abc11

        sb1.delete(1,3);
        System.out.println(sb1);//a11,左闭右开

        sb1.replace(1,2,"shell");
        System.out.println(sb1);//ashell1

        sb1.insert(5,'d');
        System.out.println(sb1);//asheldl1

        sb1.reverse();
        System.out.println(sb1);//1ldlehsa

        String s2 = sb1.substring(1,3);
        System.out.println(sb1);//
        System.out.println(sb1.length());//8
        System.out.println(s2);//ld

    }

    /*
     * Description:
     * String类:不可变的字符序列；底层用char[]存储
     * StringBuffer类:可变的字符序列；线程安全的、效率低；底层用char[]存储
     * StringBuilder类:可变的字符序列；线程不安全的、效率高；底层用char[]存储
     *
     * 总结：StringBuffer类扩容问题
     *          如果要添加的数据底层数组装不下去，则需要扩容底层数据大小。
     *          一般默认是原来数组的2倍加2，同时将现有的数组元素复制到新的数组
     *      因此开发中优先选用 StringBuffer sb = new StringBuffer(int capacity);
     * @param: []
     * @return: void
     * @author: ljg
     * @date: 2022/5/4 10:24
     */
    @Test
    public void test1() {
        StringBuffer sb1 = new StringBuffer("abc");//底层创建了一个容量为16+"abc".length的字符数组
        sb1.setCharAt(0,'m');
        System.out.println(sb1);//mbc
        System.out.println(sb1.length());//3

        StringBuffer sb2 = new StringBuffer();//默认底层创建了一个容量为16的字符数组
        System.out.println(sb2.length());//0，即已使用的长度

    }

}
