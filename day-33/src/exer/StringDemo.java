package exer;

/**
 * @author : ljg
 * @ClassName: StringDemo
 * @Description 3）获取一个字符串在另一个字符串中出现的次数。
 *       比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
 * @date : 2022/5/4 17:00
 */
public class StringDemo {
    public int getCount(String str,String subStr) {
        int mainLength = str.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;
        if (mainLength >= subLength) {
            while((index = str.indexOf(subStr,index)) != -1) {
                count++;
            }
            return count;
        } else {
            return 0;
        }
    }
}
