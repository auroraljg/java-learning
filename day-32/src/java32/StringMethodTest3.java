package java32;

import org.testng.annotations.Test;

/**
 * @author : ljg
 * @ClassName: StringMethodTest3
 * @Description
 *  String replace(char oldChar, char newChar)：返回一个新的字符串，它是
 * 通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
 *  String replace(CharSequence target, CharSequence replacement)：使
 * 用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
 *  String replaceAll(String regex, String replacement) ： 使 用 给 定 的
 * replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
 *  String replaceFirst(String regex, String replacement) ： 使 用 给 定 的
 * replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
 *  boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。
 *  String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。
 *  String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此
 * 字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。
 * @date : 2022/5/3 19:18
 */
public class StringMethodTest3 {
    @Test
    public void test1(){
        String s1 = "北北京山龟骨教育";
        String s2 = s1.replace("北","南");
        System.out.println(s1);//北北京山龟骨教育
        System.out.println(s2);//南南京山龟骨教育

        String s3 = s1.replace("北京","南天");
        System.out.println(s3);//北南天山龟骨教育

//        String str = "12hello34world5java7891mysql456";
//        //把字符串中的数字替换成,，如果结果中开头和结尾有，的话去掉
//        String string = str.replaceAll("\\d+", ",").replaceAll("^,|,$", "");
//        System.out.println(string);
//
//        String str1 = "12345";
//        //判断str字符串中是否全部有数字组成，即有1-n个数字组成
//        boolean matches = str1.matches("\\d+");
//        System.out.println(matches);
//        String tel = "0571-4534289";
//        //判断这是否是一个杭州的固定电话
//        boolean result = tel.matches("0571-\\d{7,8}");
//        System.out.println(result);

        String str = "hello|world|java";
        String[] strs = str.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        System.out.println();
        String str2 = "hello.world.java";
        String[] strs2 = str2.split("\\.");
        for (int i = 0; i < strs2.length; i++) {
            System.out.println(strs2[i]);
        }
    }
}
