package exer;

/**
 * @author : ljg
 * @ClassName: StringTest
 * @Description TODO
 * @date : 2022/5/3 16:43
 */
public class StringTest {
    String str = new String("good");//堆空间
    char[] ch = { 't', 'e', 's', 't' };
    public void change(String str, char ch[]) {  //传地址,引用
        str = "test ok";
        ch[0] = 'b';
    }
    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");//good and best
        System.out.println(ex.ch);
    }
}
