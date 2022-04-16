package java23;

/**
 * @author : ljg
 * @ClassName: MainTest
 * @Description main()方法的使用说明
 *              1.程序的入口
 *              2.普通的静态方法,可调用
 *              3.可以作为我们与控制台交互的方式(之前用Scanner)
 * @date : 2022/4/16 11:01
 */
public class MainTest {
    public static void main(String[] args) {  //入口
        Main.main(new String[100]);

    }
}
class Main{
    public static void main(String[] args) {
        for(int i = 0;i < args.length;i++){
            args[i] = "args_" + i;
            System.out.println(args[i]);
        }
    }
}