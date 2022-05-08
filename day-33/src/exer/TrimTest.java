package exer;

/**
 * @author : ljg
 * @ClassName: TrimTest
 * @Description 1）模拟一个trim方法，去除字符串两端的空格。
 * @date : 2022/5/4 15:47
 */
public class TrimTest {
    public String myTrim(String str) {
        if (str == "") {
            return str;
        }
        char[] arr = str.toCharArray();
        int start = 0;
        int end = 0;
        //查找前端坐标
        for (int i = 0; i < arr.length && arr[i] == ' '; i++) {
            start++;
        }
        //查找后端坐标
        for (int j = arr.length - 1; j >= 0 && arr[j] == ' '; j--) {
            end++;
        }
        return str.substring(start, arr.length - end);//左闭右开原则
    }

    public static void main(String[] args) {
        TrimTest t = new TrimTest();
        String str = "  hello world  java    ";
        String str2 = t.myTrim(str);
        System.out.println("-----" + str + "-----");
        System.out.println("-----" + str2 + "-----");
    }
}
