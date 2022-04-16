package java22;

/**
 * @author : ljg
 * @ClassName: StaticTest
 * @Description static关键字的使用
 * @date : 2022/4/15 15:59
 */
public class StaticTest {
    public static void main(String[] args) {
        Chinese.nation = "中国";
        System.out.println(Chinese.nation);//静态变量的加载要早于对象的创建
        Chinese.show();
//        Chinese.tospring;   //编译出错

        Chinese c1 = new Chinese();
        c1.names = "姚明";
        c1.age = 45;
        c1.nation = "CHN";

        Chinese c2 = new Chinese();
        c2.names = "马龙";
        c2.age = 35;
        c2.nation = "china";

        System.out.println(c2.nation);

        c1.eat();
        System.out.println(c1.toString());

    }
}
//中国人
class Chinese{
    String names;
    int age;
    static String nation; //类变量

    public void eat(){
        System.out.println("中国人吃中餐！");
        this.toString(); //调用非静态结构
    }
    public static void show(){     //静态方法，类方法
        System.out.println("我是中国人！");
//        eat();
        System.out.println(nation);  //静态方法可调用静态属性，不可调用非静态属性
    }

    @Override
    public String toString() {
        return "Chinese{" +
                "names='" + names + '\'' +
                ", age=" + age +
                '}';
    }
}