package exer;

/**
 * @author : ljg
 * @ClassName: StringTest2
 * @Description 4）获取两个字符串中最大相同子串。比如：
 *    str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
 *    提示：将短的那个串进行长度依次递减的子串与较长的串比较。
 * @date : 2022/5/4 21:00
 */
public class StringTest2 {
    public String getMaxSame(String str1,String str2) {
        if (str1 != null && str2 != null) {
            StringBuffer sbuffer = new StringBuffer();
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() < str2.length()) ? str1 : str2;

            int length = minStr.length();
            for (int i = 0;i < length;i++) {
                for (int x = 0,y = length - i;y <= length;x++,y++) {
                    String subString = minStr.substring(x,y);
                    if (maxStr.contains(subString)) {
                        sbuffer.append(subString + ",");
                    }
                }
            }
            String spilt = sbuffer.toString().replaceAll(",$"," ");
            return spilt;
        } else {
            return null;
        }
    }
}
