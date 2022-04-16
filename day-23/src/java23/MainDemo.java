package java23;

/**
 * @author : ljg
 * @ClassName: MainDemo
 * @Description 3.可以作为我们与控制台交互的方式(之前用Scanner)
 *              run--edit configurations -- program arguments
 * @date : 2022/4/16 11:14
 */
public class MainDemo {
    public static void main(String[] args) {

        for(int i = 0;i < args.length; i++){
            System.out.println("**********" + args[i]);

            int num = Integer.parseInt(args[i]);  //强制转化为int型
            System.out.println("######" + args[i]);
        }
    }
}
