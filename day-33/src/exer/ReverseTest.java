package exer;

/**
 * @author : ljg
 * @ClassName: ReverseTest
 * @Description 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”
 * @date : 2022/5/4 16:23
 */
public class ReverseTest {
    //使用StringBuffer替换String
    public String myReverse3(String str, int start, int end) {
        if (str != "") {
            StringBuffer builder = new StringBuffer(str.length());
            //第一部分
            builder.append(str.substring(0,start));
            //第二部分
            for (int i = end; i >= start; i--) {
                builder.append(str.charAt(i));
            }
            //第三部分
            builder.append(str.substring(end + 1));
            return builder.toString();
        }
        return str;
    }

    //使用String方法的拼接,效率低
    public String myReverse2(String str, int start, int end) {
        if (str != "") {
            //第一部分
            String reverseStr = str.substring(0, start);
            //第二部分
            for (int i = end; i >= start; i--) {
                reverseStr += str.charAt(i);
            }
            //第三部分
            reverseStr += str.substring(end + 1);
            return reverseStr;
        }
        return str;
    }


    public String myReverse(String str, int start, int end) {
        if (str == "") {
            return str;
        }
        char[] arr = str.toCharArray();
        //两个指针逼近
        for (int i = start, j = end; i < j; i++, j--) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return new String(arr);

        //错误
//        int m = end;
//        for (int i = 0;i < arr.length;i++) {
//            if (i >= start && i <= (end - start) / 2) {
//                //开始交换指定部分字符
//                char tmp = arr[i];
//                arr[i] = arr[m];
//                arr[m--] = tmp;
//            }
//        }
//        String str2 = new String(arr);
//        return str2;
    }

    public static void main(String[] args) {
        ReverseTest t = new ReverseTest();
        String str = "abcdefg";
        String str2 = t.myReverse3(str, 2, 5);
        System.out.println(str);
        System.out.println(str2);
    }
}
